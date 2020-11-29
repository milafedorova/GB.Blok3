package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
// 1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
// 2. Перейти в окно авторизации.	Открывается новая страница авторизации https://lms.mtuci.ru/lms/login/index.php.
// 3. Ввести валидный логин Login_1.	Логин отображается в поле.
// 4. Ввести валидный пароль password_1.	Пароль введен и скрыт астерисками.
// 5. Нажать кнопку «Вход».	"1. Неуспешная авторизация. Появляется сообщение:""Неверный логин или пароль, попробуйте заново.""."


public class Task1Test {

    private final String ORIGIN_URL = "https://mtuci.ru/";
    static WebDriver driver;

    @BeforeAll
    static void setupWebDriverManager(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest(){

        goToUrl();
    }


    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void test1(){
        By btnLocator = By.xpath("/html/body/div[2]/header/div[1]/div/div/span[2]/a/img");

        Actions actions = new Actions(driver);
        WebElement loginLink = driver.findElement(btnLocator);
        actions.moveToElement(loginLink);
        actions.click().build().perform();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement loginBox = driver.findElement(By.id("username"));
        loginBox.sendKeys("login");
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("password");

        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
        actions.moveToElement(enterButton);
        actions.click().build().perform();

        WebElement answer = driver.findElement(By.xpath("//*[@id=\"region-main\"]/div/div/div/div/div/div[1]/div"));


        assertEquals("Неверный логин или пароль, попробуйте заново.", answer.getText());
    }

    private void goToUrl(){
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ORIGIN_URL);
    }
}

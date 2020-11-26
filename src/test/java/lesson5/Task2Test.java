package lesson5;
//Успешная отправка заявки на поступление
// 1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
// 2. На главной странице в поле "Имя" ввести валидное имя.	Имя отображается в поле.
// 3. Ввести валидную электронную почту в поле "email@example.com".	Почта отображается в поле.
// 4. Нажать кнопку "Отправить".	"1. Успешная отправка. Появляется сообщение: ""Спасибо! Вы успешно подписались на нашу рассылку.""2. Неуспешная отправка. Неправильно введена электронная почта."

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class Task2Test {
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

    private void goToUrl(){
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ORIGIN_URL);
    }

    @Test
    public void test2() {

        WebElement nameBox = driver.findElement(By.name("newsletter_name"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        nameBox.sendKeys("Людмила");

        WebElement mailBox = driver.findElement(By.xpath("/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[3]/input"));
        mailBox.sendKeys("huudj@gmail.com");

        WebElement enterButton = driver.findElement(By.xpath("/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[4]/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(enterButton);
        actions.click().build().perform();
    }
}

package lesson5;
//Проверка перевода сайта с русского языка на английский
// 1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
// 2. Перевести сайт на английскую версию.	Весь текст сайта переведен на английский язык.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class Task4Test {
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
    public void test4() {
        By button = By.xpath("/html/body/div[2]/header/div[2]/div/div[1]/div[3]/span[3]/span[2]/a");

        Actions actions = new Actions(driver);
        WebElement mButton = driver.findElement(button);
        actions.moveToElement(mButton);
        actions.click().build().perform();

        By page = By.tagName("body");
        WebElement mPage = driver.findElement(page);
        String pageText = mPage.getText();

        System.out.println(pageText);

        boolean cyrillic = pageText.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));

        assertTrue(!cyrillic);
    }
}

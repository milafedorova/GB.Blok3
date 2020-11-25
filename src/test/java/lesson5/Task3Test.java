package lesson5;
//Проверка версии сайта для слабовидящих
//  1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
//	2. Перейти в версию для слабовидящих.	Открывается сайт в версии для слабовидящих.
//	3. Проверить три размера шрифта сайта.	Размеры шрита меняются в зависимости от выбранного размера.
//	4. Проверить переход к обычной версии сайта.	Открывается сайт в обычной версии.

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
import static org.junit.Assert.*;


public class Task3Test {
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
    public void test3() {
        By button = By.xpath("/html/body/div[2]/header/div[2]/div/div[1]/div[3]/span[1]/span/a/img");

        Actions actions = new Actions(driver);
        WebElement mButton = driver.findElement(button);
        actions.moveToElement(mButton);
        actions.click().build().perform();

        WebElement enterButton1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a[2]"));
        actions.moveToElement(enterButton1);
        actions.click().build().perform();

        assertEquals("aaFontsize-normal a-current", enterButton1.getAttribute("class"));

        WebElement enterButton2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a[3]"));
        actions.moveToElement(enterButton2);
        actions.click().build().perform();

        assertEquals("aaFontsize-big a-current", enterButton2.getAttribute("class"));

        WebElement enterButton3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a[1]"));
        actions.moveToElement(enterButton3);
        actions.click().build().perform();

        assertEquals("aaFontsize-small a-current", enterButton3.getAttribute("class"));

        WebElement enterButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/span/a"));
        actions.moveToElement(enterButton);
        actions.click().build().perform();
    }
}


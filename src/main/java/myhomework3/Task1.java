//Успешная авторизация на сайте  используя валидные логин и пароль
// 1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
// 2. Перейти в окно авторизации.	Открывается новая страница авторизации https://lms.mtuci.ru/lms/login/index.php.
// 3. Ввести валидный логин Login_1.	Логин отображается в поле.
// 4. Ввести валидный пароль password_1.	Пароль введен и скрыт астерисками.
// 5. Нажать кнопку «Вход».	"1. Неуспешная авторизация. Появляется сообщение:""Неверный логин или пароль, попробуйте заново.""."
package myhomework3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mtuci.ru/");
        WebElement auth = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/span[2]/a/img"));
        auth.click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        WebElement loginBox = driver.findElement(By.id("username"));
        loginBox.sendKeys("login");
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("password");



        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
        enterButton.click();



        driver.quit();
    }
}

//Успешная отправка заявки на поступление
// 1. В браузере Google Chrome перейти на сайт https://mtuci.ru/.	Открывается главная страница сайта https://mtuci.ru/.
// 2. На главной странице в поле "Имя" ввести валидное имя.	Имя отображается в поле.
// 3. Ввести валидную электронную почту в поле "email@example.com".	Почта отображается в поле.
// 4. Нажать кнопку "Отправить".	"1. Успешная отправка. Появляется сообщение: ""Спасибо! Вы успешно подписались на нашу рассылку.""2. Неуспешная отправка. Неправильно введена электронная почта."

package myhomework3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://mtuci.ru/");

        WebElement nameBox = driver.findElement(By.name("newsletter_name"));
        nameBox.sendKeys("Людмила");

        WebElement mailBox = driver.findElement(By.xpath("/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[3]/input"));
        mailBox.sendKeys("huudj@gmail.com");

        WebElement enterButton = driver.findElement(By.xpath("/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[4]/button"));
        enterButton.click();

        driver.quit();

    }
}

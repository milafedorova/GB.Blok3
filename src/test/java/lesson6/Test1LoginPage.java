package lesson6;

import base.BaseUITest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPages;
import static org.junit.Assert.*;


public class Test1LoginPage extends BaseUITest {

    @Test
    @DisplayName("Test login page")
    @Description("Go to the login page from main page, insert incorrect login and password, check the access deny.")
    public void task1Test(){
        HomePage homePage = (HomePage) new HomePage(driver);

        LoginPages loginPages = homePage.clickToLoginLink()
                .switchToOtherTab()
                .loginPasswordBox("login", "password")
                .clickEnterButton();

        saveAllureScreenshot();


        assertEquals("Неверный логин или пароль, попробуйте заново.", loginPages.checkMessage());

    }

    @Attachment(value = "AuthFailed.jpg", type = "image/jpg")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

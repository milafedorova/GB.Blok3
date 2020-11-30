package lesson6;

import base.BaseUITest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;

public class Test2ApplicationForAdmission extends BaseUITest {

    @Test
    @DisplayName("Application for admission")
    @Description("Test application for admission on main page")
    public void task2Test(){
        HomePage homePage = (HomePage) new HomePage(driver)
                .enterMailName("1234mail.com", "Luda")
                .clickSendAnApplication();

        saveAllureScreenshot();
    }

    @Attachment(value = "applicationForAdmission.jpg", type = "image/jpg")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

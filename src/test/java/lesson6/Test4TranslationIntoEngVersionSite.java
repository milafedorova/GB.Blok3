package lesson6;

import base.BaseUITest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;

import static org.junit.Assert.*;

public class Test4TranslationIntoEngVersionSite extends BaseUITest {

    @Test
    @DisplayName("Translation Into Eng Version Site")
    @Description("Test of eng version site on containing russian char")
    public void task4Test() {
        HomePage homePage = (HomePage) new HomePage(driver)
                .clickRuEngButton();

        saveAllureScreenshot();

        assertTrue(homePage.checkIsRussianChar());
    }

    @Attachment(value = "EngVersionMainPage.jpg", type = "image/jpg")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

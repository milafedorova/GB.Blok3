package lesson6;

import base.BaseUITest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import static org.junit.Assert.*;

public class Test3VersionForTheVisuallyImpaired extends BaseUITest {

    @Test
    @DisplayName("Version for the visually impaired")
    @Description("Test version for the visually impaired main page")
    public void task3Test() {
        HomePage homePage = (HomePage) new HomePage(driver)
                .clickButtonChangeVersionForTheVisuallyImpaired()
                .clickEnterButtonNormalSize();

        assertEquals("aaFontsize-normal a-current", homePage.nameClassEnterButtonNormalSize());


        homePage
                .clickEnterButtonBigSize();


        assertEquals("aaFontsize-big a-current", homePage.nameClassEnterButtonBigSize());

        homePage
                .clickEnterButtonSmallSize();

        saveAllureScreenshot();

        assertEquals("aaFontsize-small a-current", homePage.nameClassEnterButtonSmallSize());

        homePage
                .clickEnterButtonBackToNormalVersion();
    }

    @Attachment(value = "SmallSizeFont.jpg", type = "image/jpg")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

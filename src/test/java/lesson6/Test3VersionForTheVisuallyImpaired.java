package lesson6;

import base.BaseUITest;
import org.junit.jupiter.api.*;
import pages.HomePage;
import static org.junit.Assert.*;

public class Test3VersionForTheVisuallyImpaired extends BaseUITest {

    @Test
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

        assertEquals("aaFontsize-small a-current", homePage.nameClassEnterButtonSmallSize());

        homePage
                .clickEnterButtonBackToNormalVersion();
    }
}

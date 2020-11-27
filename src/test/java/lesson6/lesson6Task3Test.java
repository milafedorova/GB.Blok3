package lesson6;

import base.BaseUITest;
import org.junit.jupiter.api.*;
import pages.HomePage;
import static org.junit.Assert.*;

public class lesson6Task3Test extends BaseUITest {

    @Test
    public void task3Test() {
        HomePage homePage = (HomePage) new HomePage(driver)
                .clickButton()
                .clickEnterButton1();

        assertEquals("aaFontsize-normal a-current", homePage.nameClassEnterButton1());

        homePage
                .clickEnterButton2();

        assertEquals("aaFontsize-big a-current", homePage.nameClassEnterButton2());

        homePage
                .clickEnterButton3();

        assertEquals("aaFontsize-small a-current", homePage.nameClassEnterButton3());

        homePage
                .clickEnterButton4();
    }
}

package lesson6;

import base.BaseUITest;
import org.junit.jupiter.api.*;
import pages.HomePage;

import static org.junit.Assert.*;

public class Test4TranslationIntoEngVersionSite extends BaseUITest {

    @Test
    public void task4Test() {
        HomePage homePage = (HomePage) new HomePage(driver)
                .clickRuEngButton();

        assertTrue(homePage.checkIsRussianChar());
    }
}

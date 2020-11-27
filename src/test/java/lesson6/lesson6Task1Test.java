package lesson6;

import base.BaseUITest;
import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.LoginPages;
import static org.junit.Assert.*;


public class lesson6Task1Test extends BaseUITest {

    @Test
    public void task1Test(){
        HomePage homePage = (HomePage) new HomePage(driver);

        LoginPages loginPages = homePage.clickToLoginLink()
                .switchToOtherTab()
                .loginPasswordBox("login", "password")
                .clickEnterButton();

        assertEquals("Неверный логин или пароль, попробуйте заново.", loginPages.checkMessage());

    }
}

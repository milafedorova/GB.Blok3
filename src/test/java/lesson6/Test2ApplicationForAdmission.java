package lesson6;

import base.BaseUITest;
import org.junit.jupiter.api.*;
import pages.HomePage;

public class Test2ApplicationForAdmission extends BaseUITest {

    @Test
    public void task2Test(){
        HomePage homePage = (HomePage) new HomePage(driver)
                .enterMailName("Luda", "1234@mail.ru")
                .clickSendAnApplication();
    }
}

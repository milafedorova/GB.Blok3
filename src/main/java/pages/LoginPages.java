package pages;

import base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class LoginPages extends BaseView {

    public LoginPages(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "username")
    private WebElement loginBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"loginbtn\"]")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@id=\"region-main\"]/div/div/div/div/div/div[1]/div")
    private WebElement answer;

    public LoginPages loginPasswordBox(String login, String password){
        loginBox.sendKeys(login);
        passwordBox.sendKeys(password);
        return this;
    }

    public LoginPages clickEnterButton(){
        enterButton.click();
        return this;
    }

    public String checkMessage(){
        return answer.getText();
    }

    public LoginPages switchToOtherTab(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}

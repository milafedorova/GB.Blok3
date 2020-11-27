package pages;

import base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseView {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/div/span[2]/a/img")
    private WebElement loginLink;

    public LoginPages clickToLoginLink(){
        loginLink.click();
        return new LoginPages(driver);
    }

    @FindBy(xpath = "/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[3]/input")
    private WebElement mailBox;


    @FindBy(name = "newsletter_name")
    private WebElement nameBox;

    public HomePage enterMailName(String mail, String name){
        mailBox.sendKeys(mail);
        nameBox.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "/html/body/div[13]/footer/div[1]/div[1]/form/div/div[1]/div[4]/button")
    private WebElement enterButton;

    public HomePage clickEnterButton(){
        enterButton.click();
        return this;
    }


    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div/div[1]/div[3]/span[1]/span/a/img")
    private WebElement button;

    public HomePage clickButton(){
        button.click();
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[2]")
    private WebElement enterButton1;

    public HomePage clickEnterButton1(){
        enterButton1.click();
        return this;
    }

    public String nameClassEnterButton1(){
        return enterButton1.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[3]")
    private WebElement enterButton2;

    public HomePage clickEnterButton2(){
        enterButton2.click();
        return this;
    }

    public String nameClassEnterButton2(){
        return enterButton2.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[1]")
    private WebElement enterButton3;

    public HomePage clickEnterButton3(){
        enterButton3.click();
        return this;
    }

    public String nameClassEnterButton3(){
        return enterButton3.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/span/a")
    private WebElement enterButton4;

    public HomePage clickEnterButton4(){
        enterButton4.click();
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div/div[1]/div[3]/span[3]/span[2]/a")
    private WebElement ruEngButton;

    public HomePage clickRuEngButton(){
        ruEngButton.click();
        return this;
    }

    @FindBy(tagName = "body")
    private WebElement mPage;

    public boolean checkIsRussianChar(){
        String pageText = mPage.getText();
        return (pageText.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC)));
    }

}

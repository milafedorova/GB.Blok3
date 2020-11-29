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
    private WebElement SendAnApplication;

    public HomePage clickSendAnApplication(){
        SendAnApplication.click();
        return this;
    }


    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div/div[1]/div[3]/span[1]/span/a/img")
    private WebElement buttonChangeVersionForTheVisuallyImpaired;

    public HomePage clickButtonChangeVersionForTheVisuallyImpaired(){
        buttonChangeVersionForTheVisuallyImpaired.click();
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[2]")
    private WebElement enterButtonNormalSize;

    public HomePage clickEnterButtonNormalSize(){
        enterButtonNormalSize.click();
        return this;
    }

    public String nameClassEnterButtonNormalSize(){
        return enterButtonNormalSize.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[3]")
    private WebElement enterButtonBigSize;

    public HomePage clickEnterButtonBigSize(){
        enterButtonBigSize.click();
        return this;
    }

    public String nameClassEnterButtonBigSize(){
        return enterButtonBigSize.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/a[1]")
    private WebElement enterButtonSmallSize;

    public HomePage clickEnterButtonSmallSize(){
        enterButtonSmallSize.click();
        return this;
    }

    public String nameClassEnterButtonSmallSize(){
        return enterButtonSmallSize.getAttribute("class");
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/span/a")
    private WebElement enterButtonBackToNormalVersion;

    public HomePage clickEnterButtonBackToNormalVersion(){
        enterButtonBackToNormalVersion.click();
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

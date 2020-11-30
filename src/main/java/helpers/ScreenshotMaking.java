package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaking {
    public static void makeScreenShot(WebDriver driver, String filename){
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/"+filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}

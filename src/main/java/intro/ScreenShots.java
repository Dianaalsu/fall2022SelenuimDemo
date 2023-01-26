package intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShots extends BaseTest {

    @Test

    public void screenshotTest()  throws Exception{
        browserHelper.openURL("https://www.amazon.com/");
        this.takeShapShot(driver, "C:\\Users\\User\\IdeaProjects\\UI_framework_Practic\\src\\main\\resources\\fall\\png");

    }

    public  void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
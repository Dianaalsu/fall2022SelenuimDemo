package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseTest{

    @Test
    public void test1(){
        browserHelper.openURL("http://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        Helper.pause(5000);
        browserHelper.swicthToWindow(0);
        Helper.pause(3000);

    }
}

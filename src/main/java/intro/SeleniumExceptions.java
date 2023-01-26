package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest {

    @Test
    public void noSuchElementExceptionTest(){
        //NoSuchElementExсeption - нету такого элемента
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");
    }

    @Test
    public void noSuchWindowException(){
        //noSuchWindowException - такого окошки не сущ-ет
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    public void noSuchFrameException(){
        //noSuchFrameException - не будет такого фрейма
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertException(){
        //noSuchAlertException - нет такого предупреждения
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.switchTo().alert();
    }

    @Test
    public void invalidSelectExceptionTest(){
        //invalidSelectExceptionTest - некорректный селектор
        browserHelper.openURL("http://demoqa.com/text-box");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session Id is:" + s);
        driver.findElement(By.cssSelector("//button[@type='button'][2]"));
    }

    @Test
    public void noSuchSessionException(){
        //noSuchSessionException - нету такой сессии
        driver.quit();
        browserHelper.openURL("http://demoqa.com/text-box");
    }

   @Test
    public void staleElementReferenceExceptionTest() {
       //staleElementReferenceExceptionTest - ссылка на устаревший элемент
       driver.get("https://www.amazon.com/");
       driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
       List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
       int count = 0;
       for (WebElement e : allBrands) {
           count++;
           if (e.getText().equals("SAMSUNG")) {
               driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();

           }
       }
   }


}
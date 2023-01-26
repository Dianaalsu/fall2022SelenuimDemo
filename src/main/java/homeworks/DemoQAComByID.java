package homeworks;

import com.github.javafaker.Faker;
import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQAComByID extends BaseTestForHW {
    @Test
    public void test1(){
        Faker faker = new Faker();
        driver.get("http://demoqa.com/text-box");

        String expextedName = faker.name().firstName();
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(expextedName);

        String expextedEmail = faker.internet().emailAddress();
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(expextedEmail);

        String expectedCurrentAddress = faker.address().fullAddress();
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(expectedCurrentAddress);

        String expectedPermanentAddress = faker.address().secondaryAddress();
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(expectedPermanentAddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");
        WebElement submitButton = driver.findElement(By.id("submit"));

        submitButton.click();

        String actualName;
        String actualEmail;
        String actualCurrentAddress;
        String actualPermanentAddress;

        WebElement actualName0 = driver.findElement(By.id("name"));
        actualName = actualName0.getText();
        Assert.assertEquals("Name:"+expextedName, actualName);

        JavascriptExecutor js1 = (JavascriptExecutor)  driver;
        js.executeScript("window.scrollBy(0,250", "");

        WebElement actualCurrentAddress0 = driver.findElement(By.id("(.//p[@class='mb-1'])[3]"));
        actualCurrentAddress = actualCurrentAddress0.getText();
        Assert.assertEquals("CurrentAddress:"+expectedCurrentAddress,actualCurrentAddress);

        WebElement actualPermanentAddress0 = driver.findElement(By.id("(.//p[@class='mb-1'])[4]"));
        actualPermanentAddress = actualPermanentAddress0.getText();
        Assert.assertEquals("PermanentAddress:"+expectedPermanentAddress,actualPermanentAddress);

        Helper.pause(3000);
}
}

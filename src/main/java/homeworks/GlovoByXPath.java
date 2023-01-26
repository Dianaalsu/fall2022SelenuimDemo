package homeworks;

import com.github.javafaker.Faker;
import intro.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GlovoByXPath extends BaseTestForHW{

    @Test
    public void testGlovo(){

        driver.get("http://glovoapp.com/");

        driver.findElement(By.xpath("(.//span[@class='helio-button__content'])[2]")).click();
        Helper.pause(3000);
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        driver.findElement(By.xpath("(.//input[@class='el-input__inner'])[2]")).sendKeys(name);

        driver.findElement(By.xpath("(.//input[@class='el-input__inner'])[3]")).sendKeys(email);

        driver.findElement(By.xpath("(.//input[@class='el-input__inner'])[4]")).sendKeys(password);

        driver.findElement(By.xpath("(.//span[@class='helio-button-content'])")).click();

        Helper.pause(3000);

    }
}

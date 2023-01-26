package homeworks;

import intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonSamsungClick extends BaseTestForHW{

        @Test
        public void test1() {
            driver.get("https://www.amazon.com/");
            driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);


            WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
            System.out.println(appleText.getText()); // Apple

            // nuta version
            List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
            int count = 0;
            for (WebElement e : allBrands) {
                count++;
                if (e.getText().equals("SAMSUNG")) {
                    Helper.pause(3000);
                    driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
                    break;
                }
            }
        }
    }

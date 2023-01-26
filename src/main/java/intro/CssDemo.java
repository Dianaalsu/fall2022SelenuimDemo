package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {
    @Test
    public void cssTest1(){

        driver.get("https://www.amazon.com/");

        WebElement element = driver.findElement(By.xpath("twotabsearchtextbox"));

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        WebElement appleText = driver.findElement(By.cssSelector("Li[id='p_89/Apple']"));

        System.out.println(appleText.getText());

        driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[8]/span/div/a/span")).click();
        By brandName = By.xpath("//li[contains(@id,'p_89/')]/span/a/div");
        By checkBoxes = By.xpath("/label/i");
        List<WebElement> allBrands = driver.findElements(brandName);
        

        for (WebElement e : allBrands){
            System.out.println(e.getText());
            if (e.getText().equals("OnePlus")){
                driver.findElement(brandName).findElement(checkBoxes).click();
                 break;
            }

        }

}
}

package intro;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ActionsDemo extends BaseTest{

        @Test
        public void testRadioButton(){
            driver.get("https://demoqa.com/radio-button");

            WebElement yes = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
            yes.click();

            Assert.assertTrue(yes.isEnabled());
        }

        @Test
        @Ignore
        public void testCheckbox(){
            driver.get("https://demoqa.com/checkbox");

            driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[1]")).click();
            driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]")).click();
            WebElement command = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]"));
            command.click();

            Assert.assertTrue(command.isEnabled());
        }

        @Test
        @Ignore
        public void testClicks(){
            driver.get("https://demoqa.com/buttons");

            Actions actions = new Actions(driver);

            WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
            //                              like do it --> always use perform when we work with Actions
            actions.doubleClick(doubleClick).perform();
            Helper.pause(3000);
            Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");

            WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
            actions.contextClick(rightClick).perform();
            Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(), "You have done a right click");

            WebElement сlickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
            actions.click(сlickMe).perform();
            Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(), "You have done a dynamic click");

        }

        @Test
        @Ignore
        public void testMoveToElementAndSelect(){
            driver.get("https://www.imoving.com/");

            WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
            Select select = new Select(houseTypeSelectMenu);

            Helper.pause(3000);
            select.selectByValue("1080"); // My house
            Helper.pause(3000);
            select.selectByVisibleText("My Apartment");
            Helper.pause(3000);
            select.selectByIndex(3); // My storage
            Helper.pause(3000);


        }
    }


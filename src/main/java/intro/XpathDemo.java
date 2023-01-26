package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class XpathDemo {


        public void xpathTest(){
            WebDriverManager.chromedriver().setup(); // Configure ChromeDriver to connect browser

            WebDriver driver = new ChromeDriver(); // Creating instance of ChromeDriver
            driver.manage().window().maximize(); // Maximizing window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Driver will wait 20 secs
            driver.get("https://demoqa.com/text-box");// заходим на наш нужный сайт

            WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));

            String expectedEmailText = "Email"; //ищем такой текст

            Assert.assertEquals(nameText.getText(),expectedEmailText); //сравниваем фактический и ожидаемый результат

            driver.close();// нам закрывает сайт
            driver.quit();


                }
            }




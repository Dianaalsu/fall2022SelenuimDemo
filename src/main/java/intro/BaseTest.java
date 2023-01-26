package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public  abstract class BaseTest {
    WebDriver driver;

    BrowserHelper browserHelper;

    AlertHelper alertHelper;

    @BeforeClass
    public void setUp(){
        WebDriver driver = new ChromeDriver(); // Creating instance of ChromeDriver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Driver will wait 20 secs
        driver.get("https://demoqa.com/text-box");// заходим на наш нужный сайт
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    protected void takeShapShot(WebDriver driver, String s) {
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import utilities.DriverSetup;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeMethod
    public void beforeTest(){
//        softAssert=new SoftAssert();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver=DriverSetup.setUp("firefox");
    }
    @AfterMethod
    public void afterTest(){
//        driver.close();
    }
}

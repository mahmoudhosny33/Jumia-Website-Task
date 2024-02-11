import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.IdentificationPage;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.DriverSetup;


public class ParameterizedTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    IdentificationPage identificationPage;
    SoftAssert softAssert=new SoftAssert();
    @Parameters({"email"})
    @Test
    public void identificationTest(String email) {
        driver=DriverSetup.setUp("firefox");
        driver.navigate().refresh();
        homePage=new HomePage(driver);
        identificationPage=new IdentificationPage(driver);
        homePage.clickOnAccountButton();
        homePage.clickOnSignInLink();
        identificationPage.enterTextInEmailField(email);
        identificationPage.clickOnContinue();
        identificationPage.clickOnSkipForNowButton();
        registerPage=new RegisterPage(driver);
    }
    //PreCondition you must run identificationTest
    @Parameters({"password","confirmPass","firstName","lastName","phone","gender","dateOfBirth"})
    @Test
    public void registerWithValidData(String password,String confirmPass,String firstName,String lastName,String phone,String gender,String dateOfBirth) throws InterruptedException {
        registerPage.enterTextInPasswordBox(password);
        registerPage.enterTextInConfirmPasswordBox(confirmPass);
        //you must press click continue bySelf
        registerPage.clickOnContinueBtnAfterPassword();
        registerPage.enterTextInFirstNameBox(firstName);
        registerPage.enterTextInLastNameBox(lastName);
        registerPage.enterTextInPhoneBox(phone);
        registerPage.clickOnContinueBtnAfterPhone();
        registerPage.selectGender();
        driver.findElement(By.xpath("//li[@data-value='M']")).click();

        //make sleep to enetr date of birth manually
        // because of problem of this field to accept entered data
        Thread.sleep(10000);
        //registerPage.enterTextInDateOfBirthBox("02062000");

        registerPage.setCheckBox();
        registerPage.clickOnContinueBtnAfterDOB();


        //To get started account
        Thread.sleep(10000);
       softAssert.assertEquals(driver.getCurrentUrl(),"https://www.jumia.com.eg/");
       softAssert.assertAll();
    }
    //PreCondition you must have registeration account
    @Parameters({"email","password"})
    @Test
    public void loginTest(String email,String password){
        driver=DriverSetup.setUp("firefox");
        driver.navigate().refresh();
        homePage=new HomePage(driver);
        identificationPage=new IdentificationPage(driver);
        homePage.clickOnAccountButton();
        homePage.clickOnSignInLink();
        identificationPage.enterTextInEmailField(email);
        identificationPage.clickOnContinue();
        loginPage=new LoginPage(driver);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        loginPage.clickOnSkipForNowButton();
    }

    @Test
    public void addItemAndVerifySubTotalNumber(){
        driver=DriverSetup.setUp("firefox");
        driver.navigate().refresh();
        homePage=new HomePage(driver);

        homePage.hoverOnFashionLink();
        homePage.clickOnShirtsLink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll Down by 350 pixels
        js.executeScript("window.scrollBy(0,350)", "");
        homePage.addToCart();
        int num=2;
        homePage.increaseQtyFirstTime(num);
        homePage.viewCart();
        homePage.increaseQtyCartPage(num-1);



        String Str=new String(homePage.getPriceOfItem());
        System.out.println(Str.substring(4));
        Integer priceOfItem=Integer.valueOf(Str.substring(4));
        Integer numberOfQty=Integer.valueOf(homePage.getnumberOfQtyOfItem());
        Str=new String(homePage.getSubTotalNumber());
        Integer subTotal=Integer.valueOf(Str.substring(4));
        Integer total=priceOfItem*numberOfQty;
        System.out.println(homePage.getPriceOfItem());
        System.out.println(homePage.getnumberOfQtyOfItem());
        System.out.println(homePage.getSubTotalNumber());
        softAssert.assertEquals(subTotal,total);
        softAssert.assertAll();


    }

}

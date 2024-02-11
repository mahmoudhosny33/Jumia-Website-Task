package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class HomePage  {
    WebDriver driver;

    /*********** Elements Locators ***********/


    // By searchTextBox= By.xpath("//input[@name='q']");

    // By searchButton= By.xpath("//button[text()='Search']");

     By accountButton= By.xpath("//label[text()='Account']");
     By signInLink=By.xpath("//a[text()='Sign In']");

     By fashionLink=By.xpath("//a[@href='/category-fashion-by-jumia/']");
     By shirtsLink=By.xpath("//a[@href='/mens-casual-button-down-shirts/']");

    // By addToCartBtn=By.xpath("//a[@data-gtm-id ='GA158MW1GILFTNAFAMZ']//..//footer//button");
    By item=By.xpath("(//img[@class='img'])[2]");
    By addToCartBtn=By.xpath("//button[text()='Add To Cart']");


    By nameOfItem=By.xpath("//a[@href='/wool-shirt-check-winter-gate-mpg960818.html']//div//h3");
    By increaseQtyinCartPage=By.xpath("//button[@value='in']");

    By increaseQtyAfterAddToCart=By.xpath("//p[text()='L']//..//..//form//button[@value='in']");

     By viewCartAndCheckOutBtn=By.xpath("//a[text()='View Cart and Checkout']");

     By numberOfQtyOfItem=By.xpath("//span[@class='-w-32 -mas -m -fs14 -tac -lh-1']");
     By priceOfItem=By.xpath("//h3//..//..//div[@class='prc']");
     By subTotalNumber=By.xpath("//p[text()='Subtotal']//..//p[2]");

    /*********** page Constructor**************/
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    /************** Page Functions ****************/
    public void clickOnAccountButton(){ BrowserActions.clickButton(driver,accountButton);}
    public void clickOnSignInLink(){ BrowserActions.clickButton(driver,signInLink);}
    public void hoverOnFashionLink(){ BrowserActions.hover(driver,fashionLink);}
    public void clickOnShirtsLink(){
        BrowserActions.clickButton(driver,shirtsLink);
    }

    public void addToCart(){
        BrowserActions.hover(driver,item);
        BrowserActions.clickButton(driver,addToCartBtn);
    }
    public void increaseQtyFirstTime(int num){
        BrowserActions.increase(driver,increaseQtyAfterAddToCart,num);
    }
    public void increaseQtyCartPage(int num){
        BrowserActions.increase(driver,increaseQtyinCartPage,num);
    }
    public void viewCart(){

        BrowserActions.clickButton(driver,viewCartAndCheckOutBtn);
    }
    public  String getNameOfItem(){
        return driver.findElement(nameOfItem).getText();
    }
    public  String getSubTotalNumber(){
        return driver.findElement(subTotalNumber).getText();
    }
    public  String getPriceOfItem(){
        return driver.findElement(priceOfItem).getText();
    }
    public String getnumberOfQtyOfItem(){
        return driver.findElement(numberOfQtyOfItem).getText();
    }



}

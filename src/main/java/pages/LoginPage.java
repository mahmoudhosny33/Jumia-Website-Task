package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class LoginPage {
    WebDriver driver;

    /*********** Elements Locators ***********/


    By passwordTextBox=By.xpath("//input[@name='password']");
    By loginButton=By.xpath("//button[@id='loginButton']");
    By skipFoNowButton=By.xpath("//button[@id='btn-skip-passkeys-enrollment']");



    /*********** page Constructor**************/
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    /************** Page Functions ****************/
    public void clickOnLoginButton(){
        BrowserActions.clickButton(driver,loginButton);
    }

    public void enterPassword(String password){
        BrowserActions.sendKey(driver,passwordTextBox,password);}
    public void clickOnSkipForNowButton(){ BrowserActions.clickButton(driver,skipFoNowButton);}


}

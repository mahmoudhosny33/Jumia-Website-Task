package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class IdentificationPage {
    WebDriver driver;

    /*********** Elements Locators ***********/


    By emailTextBox= By.xpath("//input[@id='input_identifierValue']");

    By continueButton=By.xpath("//button[@type='submit']");

    By skipFoNowButton=By.xpath("//button[@id='btn-skip-passkeys-enrollment']");






    /*********** page Constructor**************/
    public IdentificationPage(WebDriver driver){
        this.driver=driver;
    }

    /************** Page Functions ****************/
    public void enterTextInEmailField(String text){ BrowserActions.sendKey(driver,emailTextBox,text);}

    public void clickOnContinue(){ BrowserActions.clickButton(driver,continueButton);}

    public void clickOnSkipForNowButton(){ BrowserActions.clickButton(driver,skipFoNowButton);}

}

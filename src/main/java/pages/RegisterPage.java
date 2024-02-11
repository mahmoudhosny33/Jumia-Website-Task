package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserActions;

public class RegisterPage  {
    WebDriver driver;

    /*********** Elements Locators ***********/

    By passwordField=By.xpath("//input[@tabindex='1']");

    By confirmPasswordField=By.xpath("//input[@tabindex='2']");

    By continueBtnAfterPassword=By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded']");

    By firstNameField=By.xpath("//input[@id='input_first_name']");

    By lastNameField=By.xpath("//input[@id='input_last_name']");
    By phoneField=By.xpath("//input[@type='tel']");

    By continueBtnAfterPhone=By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded']");
    By genderField=By.xpath("//div[@tabindex='0' and @aria-required='true']");

    By dateOfBirthField=By.xpath("//input[@id='input_birth_date']");
    By checkBox=By.xpath("//input[@id='acceptTC']");
    By continueBtnAfterDOB=By.xpath("//button[@id='confirmBtn']");




    /*********** page Constructor**************/
    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    /************** Page Functions ****************/
        public void enterTextInPasswordBox(String text){
        BrowserActions.sendKey(driver,passwordField,text);}
    public void enterTextInConfirmPasswordBox(String text){
        BrowserActions.sendKey(driver,confirmPasswordField,text);}
    public void clickOnContinueBtnAfterPassword(){
        BrowserActions.clickButton(driver,continueBtnAfterPassword);
    }
    public void enterTextInFirstNameBox(String text){
        BrowserActions.sendKey(driver,firstNameField,text);}
    public void enterTextInLastNameBox(String text){
        BrowserActions.sendKey(driver,lastNameField,text);}
    public void enterTextInPhoneBox(String text){
        BrowserActions.sendKey(driver,phoneField,text);}

    public void clickOnContinueBtnAfterPhone(){
        BrowserActions.clickButton(driver,continueBtnAfterPhone);
    }
    public void selectGender(){
        BrowserActions.clickButton(driver,genderField);

    }

    public void enterTextInDateOfBirthBox(String text) {
        BrowserActions.clickButton(driver,dateOfBirthField);
            BrowserActions.sendKey(driver,dateOfBirthField,text);
        }
    public void setCheckBox(){
        BrowserActions.clickButton(driver,checkBox);
    }
    public void clickOnContinueBtnAfterDOB(){
        BrowserActions.clickButton(driver,continueBtnAfterDOB);
    }




}

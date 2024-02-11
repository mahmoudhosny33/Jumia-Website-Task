package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class BrowserActions {
     static WebDriverWait wait;




    public static void clickButton(WebDriver driver,By element){
        executeWait( driver, element);
        driver.findElement(element).click();
    }
     public static void increase(WebDriver driver,By element,int num){

         //WebElement ele= driver.findElement(element);
        for (int i=0;i<num;i++){
            executeWait( driver, element);
            driver.findElement(element).click();
        }
         executeWait( driver, element);
     }
     public static void sendKey(WebDriver driver,By element,String text){
         executeWait( driver, element);
         driver.findElement(element).sendKeys(text);
     }
     public static String getText(WebDriver driver,By element){
         executeWait( driver, element);
        return driver.findElement(element).getText();
     }
     public static void hover(WebDriver driver,By element){
         executeWait( driver, element);
         WebElement ele=driver.findElement(element);
          Actions action = new Actions(driver);
           action.moveToElement(ele).perform();
     }
     public static void executeWait(WebDriver driver,By element){
         wait =new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.elementToBeClickable(element));
         wait.until(ExpectedConditions.visibilityOfElementLocated(element));
         }
}

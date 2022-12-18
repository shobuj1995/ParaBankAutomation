package selenium.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.pom.base.BaseTest;

public class CustomerLoginPage extends BaseTest {
   @FindBy(name = "username")
    WebElement usernameEl;
   @FindBy(name = "password")
    WebElement passwordEl;
   @FindBy(css = "input.button")
    WebElement loginBtn;
   public CustomerLoginPage(){
       PageFactory.initElements(driver,this);
   }
   public CustomerLoginPage fillUsername(String username){
       usernameEl.isDisplayed();
       usernameEl.sendKeys(username);
       return this;

   }
   public CustomerLoginPage fillPassword(String password){
       passwordEl.isDisplayed();
       passwordEl.sendKeys(password);
       return this;

   }
   public LandingPage clickLoginBtn(){
       loginBtn.isDisplayed();
       loginBtn.click();
       return new LandingPage();


   }


}

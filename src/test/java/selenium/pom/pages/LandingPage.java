package selenium.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.pom.base.BaseTest;

import java.util.List;

public class LandingPage extends BaseTest {
    @FindBy(css = "#leftPanel > ul:nth-child(3) > li:nth-child(8) > a:nth-child(1)")
    List<WebElement> logoutLink;
    public LandingPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean isLogoutLink(){
        return  logoutLink.size()>0;

    }

}

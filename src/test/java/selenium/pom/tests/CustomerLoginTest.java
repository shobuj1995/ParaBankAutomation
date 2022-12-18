package selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.pom.base.BaseTest;
import selenium.pom.pages.CustomerLoginPage;
import selenium.pom.pages.LandingPage;

public class CustomerLoginTest extends BaseTest {
    LandingPage landingPage;
    CustomerLoginPage customerLoginPage;
    public CustomerLoginTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        browserSetup();
        customerLoginPage = new CustomerLoginPage();
    }
    @Test
    public void loginShoulSucceed(){
       landingPage = customerLoginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(landingPage.isLogoutLink());

    }
    @Test
    public void loginWithUsernameShoulFailed(){
       customerLoginPage = customerLoginPage
                .fillUsername(getUsername())
                .clickLogin();
        Assert.assertTrue(customerLoginPage.hasErrorMessage());

    }
    @Test
    public void loginWithUserPasswordShoulFailed(){
        customerLoginPage = customerLoginPage
                .fillPassword(getPassword())
                .clickLogin();
        Assert.assertTrue(customerLoginPage.hasErrorMessage());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

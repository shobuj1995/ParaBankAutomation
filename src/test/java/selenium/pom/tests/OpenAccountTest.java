package selenium.pom.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.pom.base.BaseTest;
import selenium.pom.pages.CustomerLoginPage;
import selenium.pom.pages.LandingPage;
import selenium.pom.pages.OpenAccountPage;

public class OpenAccountTest extends BaseTest {
    LandingPage landingPage;
    OpenAccountPage openAccountPage;

    public OpenAccountTest(){
        super();
    }
    @BeforeMethod
    public void start(){
        browserSetup();
        landingPage = new CustomerLoginPage().login(getUsername(),getPassword());
    }
    @Test
    public void openAccountShouldSucceed(){
       openAccountPage = landingPage
               .clickOpenAccountLink()
               .selectAccountType("0")
               .selectAccountType(1)
               .clickOpenAccountBtn();

        Assert.assertTrue(openAccountPage.hasNewAccountId(), "The account id is not created!");

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if(ITestResult.SUCCESS == result.getStatus()){
            takeScreenshot(result.getMethod().getMethodName());
        }
//        Thread.sleep(3000);
        driver.quit();
    }
}

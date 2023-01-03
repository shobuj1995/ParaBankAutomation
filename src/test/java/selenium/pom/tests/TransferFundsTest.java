package selenium.pom.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.pom.base.BaseTest;
import selenium.pom.pages.CustomerLoginPage;
import selenium.pom.pages.LandingPage;
import selenium.pom.pages.TransferFunds;

public class TransferFundsTest extends BaseTest {
    LandingPage landingPage;
    TransferFunds transferFunds;

    public TransferFundsTest(){
        super();
    }
    @BeforeMethod
    public void start(){
        browserSetup();
        landingPage = new CustomerLoginPage().login(getUsername(),getPassword());
    }
    @Test
    public void transferFundShouldSucceed(){
        transferFunds = landingPage
                .clickTransferLink()
                .fillAmount(500)
                .clickTransferBtn();
        Assert.assertTrue(transferFunds.hasTransferAmount());

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

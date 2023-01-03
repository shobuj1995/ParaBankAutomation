package selenium.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.pom.base.BaseTest;
import selenium.pom.util.GeneralUtil;

import java.util.List;

public class TransferFunds extends BaseTest {
    @FindBy(id = "amount")
    WebElement amountEL;
    @FindBy(css = "input.button")
    WebElement transferBtn;
    @FindBy(css = "span#amount")
    List<WebElement> transferAmount;
    @FindBy(id = "fromAccountId")
    WebElement fromAccountId;
    public TransferFunds(){
        PageFactory.initElements(driver,this);

    }
    public TransferFunds fillAmount(int amount){
        amountEL.isDisplayed();
        fromAccountId.isDisplayed();
        amountEL.sendKeys(String.valueOf(amount));
        GeneralUtil.domStable();
        return this;
    }
    public TransferFunds clickTransferBtn(){
        GeneralUtil.domStable();
        transferBtn.isDisplayed();
        transferBtn.click();
        return this;
    }
    public boolean hasTransferAmount(){
        return transferAmount.size()>0;
    }

}

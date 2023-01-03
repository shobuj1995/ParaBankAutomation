package selenium.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.pom.base.BaseTest;
import selenium.pom.util.GeneralUtil;

import java.util.List;

public class OpenAccountPage extends BaseTest {
    @FindBy(id = "type")
    WebElement accountType;
    @FindBy(id = "fromAccountId")
    WebElement fromAccountId;
    @FindBy(css = "input.button")
    WebElement openAccountBtn;
    @FindBy(id = "newAccountId")
    List<WebElement> newAccountid;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public OpenAccountPage selectAccountType(int index) {
        new Select(accountType).selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectAccountType(String value) {
        new Select(accountType).selectByValue(value);
        return this;
    }

    public OpenAccountPage selectFromAccount(int index) {
        GeneralUtil.domStable();
        new Select(fromAccountId).selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectFromAccount(String text) {
        new Select(fromAccountId).selectByVisibleText(text);
        return this;
    }

    public OpenAccountPage clickOpenAccountBtn() {
        GeneralUtil.domStable();
        openAccountBtn.isDisplayed();
        openAccountBtn.click();
        return this;
    }

    public boolean hasNewAccountId() {
        return newAccountid.size() > 0;
    }


}

package components.otherComponents.dropDowns.otherModulesDropDowns;

import components.otherComponents.dropDowns.BaseDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class DropDown extends BaseDropDown {

    public static final By ACCOUNT_NAME_DROPDOWN =
            By.xpath("//label[contains(., 'Account')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//input[@type='text']");

    private static final String OPTION_LIST_PATTERN = "//span[@title='%s']";


    public DropDown(WebDriver driver) {
        super(driver);
    }

    public void selectOptionFromDropDown(By locator, String optionName) {
        openOptionsPopup(locator);
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(optionLocator));
    }

}

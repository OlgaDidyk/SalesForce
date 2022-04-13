package components.otherComponents.dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsDropDown extends BaseDropDown {

    private String label;
    public By dropdownLocator;
    private static final String ACCOUNT_DROPDOWN_LOCATOR_PATTERN =
            "//span[@id and contains(., '%s')]/ancestor::div[contains(@class,'uiInput')]//div[@data-aura-class='uiPopupTrigger']";
    private static final String OPTION_LIST_PATTERN = "//div[@aria-labelledby='%s']//li[contains(.,'%s')]";


    public AccountsDropDown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator = By.xpath(String.format(ACCOUNT_DROPDOWN_LOCATOR_PATTERN, label));
    }

    private String getLabelId() {
        return driver.findElement(dropdownLocator).getAttribute("id");
    }


    public void selectAccountOption(String optionName) {
        openOptionsPopup(dropdownLocator);
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, getLabelId(), optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, optionName));

    }

}

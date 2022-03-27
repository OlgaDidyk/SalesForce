package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDown extends AbstractComponent {

    private static final String ACCOUNT_DROPDOWN_LOCATOR_PATTERN =
            "//span[@id and contains(., '%s')]/ancestor::div[contains(@class,'uiInput')]//div[@data-aura-class='uiPopupTrigger']";

    public static final By CONTACT_SALUTATION_DROPDOWN_LOCATOR = By.xpath(
            "//label[contains(., 'Salutation')]/ancestor::lightning-combobox[contains(@class,'slds-form-element')]//button[@name='salutation']");

    public static final By CONTACT_ACCOUNT_NAME_DROPDOWN_LOCATOR = By.xpath(
            "//label[contains(., 'Account')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//input[@type='text']");


    private String label;
    public By dropdownLocator;
    private static final String OPTION_LIST_PATTERN = "//div[@aria-labelledby='%s']//li[contains(.,'%s')]";
    private static final String CONTACT_OPTION_LIST_PATTERN = "//span[@title='%s']";


    public DropDown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator = By.xpath(String.format(ACCOUNT_DROPDOWN_LOCATOR_PATTERN, label));

    }

    private void openOptionsPopup(By locator) {
        driver.findElement(locator).click();
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

    public void selectContactOptions(By locator, String optionName) {
        openOptionsPopup(locator);
        By optionLocator = By.xpath(String.format(CONTACT_OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();

    }


}

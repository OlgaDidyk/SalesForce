package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends AbstractComponent {

    private static final String ACCOUNT_INPUT_LOCATOR_PATTERN = "//label[contains(., '%s')]/ancestor::div[contains(@class,'uiInput')]//input";
    private static final String CONTACT_FIRST_LAST_NAME_LOCATOR_PATTERN = "//label[contains(., '%s')]/ancestor::lightning-input[contains(@class,'slds-form-element')]//input";
    private String label;
    public By accountInputLocator;
    public By contactInputLocator;


    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.accountInputLocator = By.xpath(String.format(ACCOUNT_INPUT_LOCATOR_PATTERN, label));
        this.contactInputLocator = By.xpath(String.format(CONTACT_FIRST_LAST_NAME_LOCATOR_PATTERN, label));
    }

    public void insert(String text) {
        driver.findElement(accountInputLocator).sendKeys(text);
    }

    public void newContactInsert(String text) {
        driver.findElement(contactInputLocator).sendKeys(text);
    }

}

package components.otherComponents.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsInput extends BaseInput{

    public static final String INPUT_FIELD_LOCATOR_PATTERN =
            "//label[contains(., '%s')]/ancestor::lightning-input[contains(@class,'slds-form-element')]//input";
    public By contactInputLocator = By.xpath(String.format(INPUT_FIELD_LOCATOR_PATTERN, label));


    public ContactsInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void insertText(String text){
        contactInputLocator = By.xpath(String.format(INPUT_FIELD_LOCATOR_PATTERN, label));
        driver.findElement(contactInputLocator).sendKeys(text);
    }
}

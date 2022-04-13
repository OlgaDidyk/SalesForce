package components.otherComponents.dropDowns.otherModulesDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactsDropDown extends DropDown {

    private String label;

    public static final By CONTACT_SALUTATION_DROPDOWN_LOCATOR = By.xpath(
            "//label[contains(., 'Salutation')]/ancestor::lightning-combobox[contains(@class,'slds-form-element')]//button[@name='salutation']");

    public ContactsDropDown(WebDriver driver) {
        super(driver);
        this.label = label;
    }


}

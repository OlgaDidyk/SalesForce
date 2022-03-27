package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsDetailsComponent extends AbstractComponent {

    public static final By ACCOUNT_NAME_FIELD = By.xpath("//span[ text()='Account Name']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]//slot[@name='outputField']//span[@force-lookup_lookup]");
    public static final By NAME_FIELD = By.xpath("//span[ text()='Name']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]//slot[@name='outputField']/lightning-formatted-name");

    private String label;

    public ContactsDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public static String getAccountNameTextFieldLocator() {
        return driver.findElement(ACCOUNT_NAME_FIELD).getText();
    }

    public static String getNameTextFieldLocator() {
        return driver.findElement(NAME_FIELD).getText();
    }
}

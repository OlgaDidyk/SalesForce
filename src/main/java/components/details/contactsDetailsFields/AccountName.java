package components.details.contactsDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountName extends AbstractComponent {

    public static final By ACCOUNT_NAME_FIELD =
            By.xpath("//span[ text()='Account Name']" +
                    "/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']//span[@force-lookup_lookup]");


    public AccountName(WebDriver driver) {
        super(driver);
    }

    public static String getAccountNameFieldValue() {
        return driver.findElement(ACCOUNT_NAME_FIELD).getText();
    }

}

package components.details.contactsDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Name extends AbstractComponent {

    public static final By NAME_FIELD =
            By.xpath("//span[ text()='Name']" +
                    "/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']/lightning-formatted-name");


    public Name(WebDriver driver) {
        super(driver);
    }

    public static String getNameFieldValue() {
        return driver.findElement(NAME_FIELD).getText();
    }

}

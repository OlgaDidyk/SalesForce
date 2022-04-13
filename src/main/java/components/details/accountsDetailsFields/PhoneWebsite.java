package components.details.accountsDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhoneWebsite extends AbstractComponent {

    private static final String DETAILS_COMPONENT_DATA_FIELD =
            "//span[ text()='%s']/ancestor::" +
                    "div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']//a";
    private String label;
    private static By phoneWebsiteField;

    public PhoneWebsite(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.phoneWebsiteField = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD, label));
    }


    public String getFieldValue() {
        return driver.findElement(phoneWebsiteField).getText();
    }


}

package components.details.accountsDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountNameTypeIndustry extends AbstractComponent {

    private static final String DETAILS_COMPONENT_DATA_FIELD =
            "//span[ text()='%s']/ancestor::" +
                    "div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']/lightning-formatted-text";
    private String label;
    private static By accountNameTypeIndustryField;

    public AccountNameTypeIndustry(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.accountNameTypeIndustryField = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD, label));
    }


    public String getFieldValue() {
        return driver.findElement(accountNameTypeIndustryField).getText();
    }

}

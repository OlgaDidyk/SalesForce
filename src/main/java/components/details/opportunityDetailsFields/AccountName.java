package components.details.opportunityDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountName extends AbstractComponent {

    private static final By ACCOUNT_NAME_DETAILED_FIELD =
            By.xpath(
            "//forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-opportunity_-record_-page___-opportunity___-v-i-e-w" +
            "//span[ text()='Account Name']/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
            "//slot[@name='outputField']//a//span");

    public AccountName(WebDriver driver) {
        super(driver);
    }

    public String getAccountNameFieldValue() {
        return driver.findElement(ACCOUNT_NAME_DETAILED_FIELD).getText();
    }
}

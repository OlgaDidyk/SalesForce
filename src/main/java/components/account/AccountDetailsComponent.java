package components.account;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsComponent extends AbstractComponent {

    private static final String DETAILS_COMPONENT_DATA_FIELD =
            "//span[ text()='%s']/ancestor::" +
                    "div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']";
    private String label;
    public static By accountNameTypeIndustryFields;
    public static By phoneWebsiteFields;
    public static By employeesField;


    public AccountDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.accountNameTypeIndustryFields = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD + "/lightning-formatted-text", label));
        this.phoneWebsiteFields = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD + "//a", label));
        this.employeesField = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD + "/lightning-formatted-number", label));
    }


    public String getValueAccountNameTypeIndustryFields() {
        return driver.findElement(accountNameTypeIndustryFields).getText();
    }

    public String getValuePhoneWebsiteFields() {
        return driver.findElement(phoneWebsiteFields).getText();
    }

    public String getValueEmployeesField() {
        return driver.findElement(employeesField).getText();
    }
}

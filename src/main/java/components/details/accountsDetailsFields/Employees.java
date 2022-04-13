package components.details.accountsDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Employees extends AbstractComponent {

    private static final String DETAILS_COMPONENT_DATA_FIELD =
            "//span[ text()='%s']/ancestor::" +
                    "div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
                    "//slot[@name='outputField']/lightning-formatted-number";
    private String label;
    public static By employeesField;

    public Employees(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.employeesField = By.xpath(String.format(DETAILS_COMPONENT_DATA_FIELD, label));

    }

    public String getFieldValue() {
        return driver.findElement(employeesField).getText();
    }


}

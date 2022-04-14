package components.details.opportunityDetailsFields;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OppNameCloseDateStage extends AbstractComponent {

    private static final String DETAILS_FIELD_PATTERN = "//span[ text()='%s']" +
            "/ancestor::div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]" +
            "//slot[@name='outputField']/lightning-formatted-text";
    private String label;
    public static By oppNameCloseStageField;


    public OppNameCloseDateStage(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.oppNameCloseStageField = By.xpath(String.format(DETAILS_FIELD_PATTERN, label));
    }

    public String getFieldValue() {
        return driver.findElement(oppNameCloseStageField).getText();
    }

}

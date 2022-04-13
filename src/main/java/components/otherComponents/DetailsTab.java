package components.otherComponents;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailsTab extends AbstractComponent {

    public static final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");
    public static final By DETAILS_TAB_PANEL = By.xpath("//div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]");

    public DetailsTab(WebDriver driver) {
        super(driver);
    }

    public void openDetailsTab() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB));
        driver.findElement(DETAILS_TAB).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_TAB, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_PANEL));
    }


}

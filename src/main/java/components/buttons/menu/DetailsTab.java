package components.buttons.menu;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsTab extends AbstractComponent {

    public static final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");
    public static final By DETAILS_TAB_PANEL = By.xpath("//div[@records-recordlayoutitem_recordlayoutitem and contains(@class, 'label-stacked')]");

    public DetailsTab(WebDriver driver) {
        super(driver);
    }

}

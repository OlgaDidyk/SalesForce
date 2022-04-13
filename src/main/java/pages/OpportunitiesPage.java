package pages;

import components.otherComponents.Buttons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunitiesPage extends BasePage{

    private static final String BASE_URL = "https://testtest4.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent";
    public static final By HEADER = By.xpath("//h1[contains(., 'Opportunities')]");

    public OpportunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

/*    public void openNewContactForm() {
        Buttons buttons = new Buttons(driver);
        buttons.clickNewButton();
    }*/
}

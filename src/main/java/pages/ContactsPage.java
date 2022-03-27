package pages;

import components.buttons.menu.Buttons;
import components.buttons.menu.DetailsTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {

    private static final String BASE_URL = "https://ewavecommerce2.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    public static final By HEADER = By.xpath("//h1[contains(., 'Contacts')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));

    }

    @Override
    public ContactsPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void openNewContactForm() {
        driver.findElement(Buttons.NEW_BUTTON).click();
    }

    //TODO сделать этот метод универсальным под любой таб
    public void openDetailsTab() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DetailsTab.DETAILS_TAB));
        driver.findElement(DetailsTab.DETAILS_TAB).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DetailsTab.DETAILS_TAB, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DetailsTab.DETAILS_TAB_PANEL));
    }

}

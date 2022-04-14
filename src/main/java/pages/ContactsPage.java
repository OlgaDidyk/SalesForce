package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage {

    private static final String BASE_URL = "https://testtest4.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
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


}

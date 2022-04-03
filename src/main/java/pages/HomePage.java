package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    //private static final String BASE_URL = "https://ewavecommerce2.lightning.force.com/lightning/page/home";
    private static final String BASE_URL = "https://ewavecommerce3.lightning.force.com/one/one.app";
    //private static final String BASE_URL = "https://login.salesforce.com/";
    public static final By HEADER = By.xpath("//h1[contains(., 'Home')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));

    }

    @Override
    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}

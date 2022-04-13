package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountPage extends BasePage {

    private static final String BASE_URL = "https://testtest4.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public static final By HEADER = By.xpath("//h1[contains(., 'Account')]");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public AccountPage openPage() {
        driver.get(BASE_URL);
        return this;
    }


}

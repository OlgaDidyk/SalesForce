package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String BASE_URN = "https://login.salesforce.com/";

    public static final By USERNAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void authentication(String username, String password) {
        log.info("Insert [{}] in [{}] field", username, "Username");
        driver.findElement(USERNAME).sendKeys(username);
        log.info("Insert [{}] in [{}] field", "*******", "Password");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Click [{}] button", "Log In");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

}

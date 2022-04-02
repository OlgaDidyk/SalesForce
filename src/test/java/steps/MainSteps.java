package steps;

import components.buttons.menu.AccountsButton;
import components.buttons.menu.ContactsButton;
import components.buttons.menu.MenuButton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.SalesforceLoginPage;
import utils.PropertiesUtils;

public class MainSteps extends AbstractStep {

    private SalesforceLoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private ContactsPage contactsPage;
    private AccountsButton accountsButton;
    private ContactsButton contactsButton;
    //private static final String VALID_LOGIN = System.getProperty("login");
    //private static final String VALID_PASSWORD = System.getProperty("password");
    public static String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    public static String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public MainSteps openSalesforceLoginPage() {
        loginPage = new SalesforceLoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;

    }

    @Step("Login with valid credentials {VALID_LOGIN}/{VALID_PASSWORD}")
    public MainSteps loginWithValidCreds() {
        loginPage.authentication(VALID_LOGIN, VALID_PASSWORD);
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
        return this;
    }

    @Step("Opening Account page")
    public AccountsSteps openAccountPage() {
        accountsButton = new AccountsButton(driver);
        Assert.assertTrue(accountsButton.isComponentDisplayed(MenuButton.buttonLocator),
                accountsButton.getClass().getSimpleName().concat(" not displayed"));
        accountsButton.click();
        accountPage = new AccountPage(driver);
        validatePageIsLoaded(accountPage);
        return new AccountsSteps(driver);
    }

    @Step("Opening Contacts page")
    public ContactsSteps openContactsPage() {
        contactsButton = new ContactsButton(driver);
        Assert.assertTrue(contactsButton.isComponentDisplayed(MenuButton.buttonLocator),
                contactsButton.getClass().getSimpleName().concat(" not displayed"));
        contactsButton.click();
        contactsPage = new ContactsPage(driver);
        validatePageIsLoaded(contactsPage);
        return new ContactsSteps(driver);
    }
}

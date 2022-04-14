package steps;

import components.forms.BaseForm;
import components.menuButtons.AccountsButton;
import components.menuButtons.ContactsButton;
import components.menuButtons.MenuButton;
import components.menuButtons.OpportunitiesButton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.PropertiesUtils;

public class MainSteps extends AbstractStep {

    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private ContactsPage contactsPage;
    private OpportunitiesPage opportunitiesPage;
    private AccountsButton accountsButton;
    private ContactsButton contactsButton;
    private OpportunitiesButton opportunitiesButton;
    public static String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    public static String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public MainSteps openLoginPage() {
        log.info("Opening login page");
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;

    }

    @Step("Login with valid credentials {VALID_LOGIN}/{VALID_PASSWORD}")
    public MainSteps loginWithValidCreds() {
        log.info("Login with valid credentials");
        loginPage.authentication(VALID_LOGIN, VALID_PASSWORD);
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
        return this;
    }

    @Step("Opening Account page")
    public AccountsSteps openAccountPage() {
        log.info("Opening Account page");
        accountsButton = new AccountsButton(driver);
        isMenuButtonDisplayed(accountsButton);
        accountsButton.click();
        accountPage = new AccountPage(driver);
        validatePageIsLoaded(accountPage);
        return new AccountsSteps(driver);
    }

    @Step("Opening Contacts page")
    public ContactsSteps openContactsPage() {
        log.info("Opening Contacts page");
        contactsButton = new ContactsButton(driver);
        isMenuButtonDisplayed(contactsButton);
        contactsButton.click();
        contactsPage = new ContactsPage(driver);
        validatePageIsLoaded(contactsPage);
        return new ContactsSteps(driver);
    }

    @Step("Opening Opportunities page")
    public OpportunitiesSteps openOpportunitiesPage() {
        log.info("Opening Opportunities page");
        opportunitiesButton = new OpportunitiesButton(driver);
        isMenuButtonDisplayed(opportunitiesButton);
        opportunitiesButton.click();
        opportunitiesPage = new OpportunitiesPage(driver);
        validatePageIsLoaded(opportunitiesPage);
        return new OpportunitiesSteps(driver);
    }

    public MainSteps openPage(MenuButton menuButton, BasePage basePage) {
        isMenuButtonDisplayed(menuButton);
        menuButton.click();
        validatePageIsLoaded(basePage);
        return this;

    }

    public void isMenuButtonDisplayed(MenuButton menuButton) {
        Assert.assertTrue(menuButton.isComponentDisplayed(MenuButton.buttonLocator),
                menuButton.getClass().getSimpleName().concat(" not displayed"));
    }

    public static void isFormDisplayed(BaseForm form, By header) {
        Assert.assertTrue(
                form.isFormDisplayed(header),
                form.getClass().getSimpleName().concat(" not displayed"));
    }


}

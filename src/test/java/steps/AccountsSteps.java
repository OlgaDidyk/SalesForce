package steps;

import components.account.AccountDetailsComponent;
import components.forms.CreateAccountFormComponent;
import components.forms.DropDown;
import components.forms.Input;
import io.qameta.allure.Step;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }


    @Step("Creating a new account")
    public AccountsSteps createNewAccount(AccountModel accountModel) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateAccountFormComponent form = new CreateAccountFormComponent(driver);

        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed"));

        fillAccountForm(accountModel);
        form.save();
        validatePageIsLoaded(accountPage);
        return this;
    }

    @Step("Filling the form during creating a new account")
    private void fillAccountForm(AccountModel accountModel) {
        Input accountNameInput = new Input(driver, "Account Name");
        accountNameInput.insert(accountModel.getAccountName());
        new Input(driver, "Phone").insert(accountModel.getPhone());
        new Input(driver, "Website").insert(accountModel.getWebsite());
        new Input(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new DropDown(driver, "Type").selectAccountOption(accountModel.getType());
        new DropDown(driver, "Industry").selectAccountOption(accountModel.getIndustry());
    }

    @Step("Validation if new account is created")
    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetailsTab();
        AccountModel actualModel = getActualAccountModel();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel));
    }

    @Step("To get an account model")
    private AccountModel getActualAccountModel() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(new AccountDetailsComponent(driver, "Account Name").getValueAccountNameTypeIndustryFields());
        accountModel.setPhone(new AccountDetailsComponent(driver, "Phone").getValuePhoneWebsiteFields());
        accountModel.setWebsite(new AccountDetailsComponent(driver, "Website").getValuePhoneWebsiteFields());
        accountModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees").getValueEmployeesField()));
        accountModel.setType(new AccountDetailsComponent(driver, "Type").getValueAccountNameTypeIndustryFields());
        accountModel.setIndustry(new AccountDetailsComponent(driver, "Industry").getValueAccountNameTypeIndustryFields());

        return accountModel;
    }

}

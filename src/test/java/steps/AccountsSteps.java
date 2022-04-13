package steps;

import components.details.accountsDetailsFields.AccountNameTypeIndustry;
import components.details.accountsDetailsFields.Employees;
import components.details.accountsDetailsFields.PhoneWebsite;
import components.forms.AccountForm;
import components.forms.ContactForm;
import components.otherComponents.dropDowns.AccountsDropDown;
import components.otherComponents.inputs.AccountsInput;
import components.otherComponents.DetailsTab;
import io.qameta.allure.Step;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;


public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;
    public DetailsTab detailsTab;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }


    @Step("Creating a new account")
    public AccountsSteps createNewAccount(AccountModel accountModel) {
        log.info("Creating a new account");
        accountPage = new AccountPage(driver);
        accountPage.openNewForm();
        AccountForm form = new AccountForm(driver);
        detailsTab = new DetailsTab(driver);

/*        Assert.assertTrue(
                form.isFormDisplayed(AccountForm.HEADER),
                form.getClass().getSimpleName().concat(" not displayed"));*/

        MainSteps.isFormDisplayed(form, AccountForm.HEADER);
        fillAccountForm(accountModel);
        form.saveForm(AccountForm.SAVE_BUTTON);
        validatePageIsLoaded(accountPage);
        return this;
    }

    @Step("Filling the form during creating a new account")
    private void fillAccountForm(AccountModel accountModel) {
        log.info("Filling the Account form");
        AccountsInput accountNameInput = new AccountsInput(driver, "Account Name");
        accountNameInput.insert(accountModel.getAccountName());
        new AccountsInput(driver, "Phone").insert(accountModel.getPhone());
        new AccountsInput(driver, "Website").insert(accountModel.getWebsite());
        new AccountsInput(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new AccountsDropDown(driver, "Industry").selectAccountOption(accountModel.getIndustry());
        new AccountsDropDown(driver,"Type").selectAccountOption(accountModel.getType());
    }

    @Step("Validation if new account is created")
    public void validateAccountCreated(AccountModel expectedModel) {
        log.info("Validation created account");
        detailsTab.openDetailsTab();
        AccountModel actualModel = getActualAccountModel();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel));
    }

    @Step("To get an account model")
    private AccountModel getActualAccountModel() {
        log.info("Creating an actual account model");
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountName(new AccountNameTypeIndustry(driver, "Account Name").getFieldValue());
        accountModel.setPhone(new PhoneWebsite(driver, "Phone").getFieldValue());
        accountModel.setWebsite(new PhoneWebsite(driver, "Website").getFieldValue());
        accountModel.setEmployees(Integer.parseInt(new Employees(driver, "Employees").getFieldValue()));
        accountModel.setType(new AccountNameTypeIndustry(driver, "Type").getFieldValue());
        accountModel.setIndustry(new AccountNameTypeIndustry(driver, "Industry").getFieldValue());
        return accountModel;
    }

}

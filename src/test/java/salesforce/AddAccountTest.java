package salesforce;

import builders.AccountBuilder;
import model.AccountModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AccountModelUtils;

public class AddAccountTest extends BaseTest {

    AccountModel testAccount = AccountModelUtils.getDefaultAccountModel();
    AccountModel testAccount2 = AccountBuilder
            .defaultAccount()
            .setPhone("123")
            .build();

    @BeforeMethod
    private void login() {
        mainSteps
                .openSalesforceLoginPage()
                .loginWithValidCreds();
    }

    @Test
    public void addNewAccountTest() {
        mainSteps
                .openAccountPage()
                .createNewAccount(testAccount)
                .validateAccountCreated(testAccount);
    }

    private AccountModel buildTestAccount() {
        return AccountBuilder.newValues()
                .setAccountName("USERNAME")
                .setPhone("+3245242352")
                .setWebsite("teachmeskills.by")
                .setEmployees(10)
                .setType("Customer")
                .setIndustry("Banking")
                .build();
    }

}

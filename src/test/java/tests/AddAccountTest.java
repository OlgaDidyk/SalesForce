package tests;

import io.qameta.allure.Link;
import model.AccountModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddAccountTest extends BaseLogin {

    AccountModel defaultModel = AccountModel.builder().build();
    BaseLogin baseLogin = new BaseLogin();

    @BeforeMethod
    @Link("https://www.salesforce.com/")
    public void login() {
        baseLogin.login();
    }


    @Test(description = "Test to add a new Account"/*, retryAnalyzer = Retry.class*/)
    public void addNewAccountTest() {
        mainSteps
                .openAccountPage()
                .createNewAccount(defaultModel)
                .validateAccountCreated(defaultModel);
    }

    @AfterMethod
    public void deleteAccount() {

    }

}

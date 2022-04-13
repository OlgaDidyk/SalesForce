package salesforce;

import io.qameta.allure.Link;
import model.AccountModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Retry;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddAccountTest extends BaseTest {

    public static String accountName = "USERNAME";
    static String phone = "+3245242352";
    static String webSite = "teachmeskills.by";
    static int employees = 10;
    static String type = "Customer";
    static String industry = "Banking";


/*    AccountModel accountModel = AccountModel.builder()
            .accountName(accountName)
            .employees(employees)
            .industry(industry)
            .phone(phone)
            .website(webSite)
            .type(type)
            .build();*/

    AccountModel defaultModel = AccountModel.builder().build();

    //TODO Логин вынести в отдельный класс БейсЛогин и класс будет наследоваться от БейсЛогин и от БейсТест
    @BeforeMethod
    @Link("https://www.salesforce.com/")
    private void login() {
        mainSteps
                .openLoginPage()
                .loginWithValidCreds();
    }

    @Test (description = "Test to add a new Account"/*, retryAnalyzer = Retry.class*/)
    public void addNewAccountTest() {
        mainSteps
                .openAccountPage()
                //.createNewAccount(accountModel)
                .createNewAccount(defaultModel)
                //.validateAccountCreated(accountModel);
                .validateAccountCreated(defaultModel);
    }

}

package tests;

import io.qameta.allure.Link;
import model.OpportunitiesModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddOpportunitiesTest extends BaseTest {

    OpportunitiesModel defaultModel = OpportunitiesModel.builder().build();
    BaseLogin baseLogin = new BaseLogin();

    @BeforeMethod
    @Link("https://www.salesforce.com/")
    public void login() {
        baseLogin.login();
    }


    @Test(description = "Test to add a new Opportunity")
    public void addNewOpportunityTest2() {
        mainSteps
                .openOpportunitiesPage()
                .createNewOpportunity(defaultModel)
                .validateOpportunityCreated(defaultModel);
    }

}

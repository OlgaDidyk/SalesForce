package salesforce;

import io.qameta.allure.Link;
import model.OpportunitiesModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddOpportunitiesTest extends BaseTest {


/*    OpportunitiesModel opportunitiesModel = OpportunitiesModel.builder()
            .opportunityName("NameModelByLombok")
            .closeDate("12/24/2023")
            .stage("Qualification")
            .accountName(AddAccountTest.accountName)
            .build();*/

    OpportunitiesModel defaultModel = OpportunitiesModel.builder().build();

    @BeforeMethod
    @Link("https://www.salesforce.com/")
    private void login() {
        mainSteps
                .openLoginPage()
                .loginWithValidCreds();
    }


    @Test(description = "Test to add a new Opportunity")
    public void addNewOpportunityTest2() {
        mainSteps
                .openOpportunitiesPage()
                //.createNewOpportunity(opportunitiesModel)
                .createNewOpportunity(defaultModel)
                //.validateOpportunityCreated(opportunitiesModel);
                .validateOpportunityCreated(defaultModel);
    }

}

package steps;

import components.details.opportunityDetailsFields.AccountName;
import components.details.opportunityDetailsFields.OppNameCloseDateStage;
import components.forms.OpportunitiesForm;
import components.menuButtons.OpportunitiesButton;
import components.otherComponents.DetailsTab;
import components.otherComponents.dropDowns.otherModulesDropDowns.ContactsDropDown;
import components.otherComponents.dropDowns.otherModulesDropDowns.DropDown;
import components.otherComponents.dropDowns.otherModulesDropDowns.OpportunitiesDropDown;
import components.otherComponents.inputs.ContactsInput;
import io.qameta.allure.Step;
import model.OpportunitiesModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.OpportunitiesPage;

public class OpportunitiesSteps extends AbstractStep {

    private OpportunitiesPage opportunitiesPage;

    public DetailsTab detailsTab;

    public OpportunitiesSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Creating a new Opportunity")
    public OpportunitiesSteps createNewOpportunity(OpportunitiesModel opportunitiesModel) {
        log.info("Creating a new Opportunity");
        OpportunitiesForm form = new OpportunitiesForm(driver);
        opportunitiesPage = new OpportunitiesPage(driver);
        opportunitiesPage.openNewForm();
        detailsTab = new DetailsTab(driver);
        MainSteps.isFormDisplayed(form, OpportunitiesForm.HEADER);
        fillOpportunitiesForm(opportunitiesModel);
        form.saveForm(OpportunitiesForm.SAVE_BUTTON);
        validatePageIsLoaded(opportunitiesPage);
        return this;
    }

    @Step("Filling the form during creating a new opportunity")
    private void fillOpportunitiesForm(OpportunitiesModel opportunitiesModel) {
        log.info("Fill the Opportunity form");
        new ContactsInput(driver, "Opportunity Name").insertText(opportunitiesModel.getOpportunityName());
        new ContactsInput(driver, "Close Date").insertText(opportunitiesModel.getCloseDate());
        new ContactsDropDown(driver).selectOptionFromDropDown(DropDown.ACCOUNT_NAME_DROPDOWN, opportunitiesModel.getAccountName());
        new OpportunitiesDropDown(driver).selectOptionFromDropDown(OpportunitiesDropDown.STAGE_DROPDOWN, opportunitiesModel.getStage());
    }

    @Step("Validation if new opportunity is created")
    public void validateOpportunityCreated(OpportunitiesModel expectedModel) {
        log.info("Validation created opportunity");
        detailsTab.openDetailsTab();
        OpportunitiesModel actualOpportunityModel = getActualOpportunitiesModel();
        Assert.assertEquals(
                actualOpportunityModel,
                expectedModel,
                String.format("Opportunity is not valid: %s", actualOpportunityModel));
    }

    private OpportunitiesModel getActualOpportunitiesModel() {
        log.info("Creating an actual opportunity model");
        OpportunitiesModel opportunitiesModel = new OpportunitiesModel();
        opportunitiesModel.setAccountName(new AccountName(driver).getAccountNameFieldValue());
        opportunitiesModel.setOpportunityName(new OppNameCloseDateStage(driver, "Opportunity Name").getFieldValue());
        opportunitiesModel.setCloseDate(new OppNameCloseDateStage(driver, "Close Date").getFieldValue());
        opportunitiesModel.setStage(new OppNameCloseDateStage(driver, "Stage").getFieldValue());
        return opportunitiesModel;
    }

/*    @Step("Analog of Sorting in SauceDemo from Lombok lesson")
    public void validateOpportunityCreated2(OpportunitiesModel expectedModel) {
        detailsTab.openDetailsTab();
        OpportunitiesModel actualOpportunityModel = getActualOpportunitiesModel();
        Assert.assertEquals(
                actualOpportunityModel,
                expectedModel,
                String.format("Opportunity is not valid: %s", actualOpportunityModel));
    }*/



}

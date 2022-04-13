package steps;

import components.details.contactsDetailsFields.AccountName;
import components.details.contactsDetailsFields.Name;
import components.forms.ContactForm;
import components.otherComponents.dropDowns.otherModulesDropDowns.ContactsDropDown;
import components.otherComponents.DetailsTab;
import components.otherComponents.dropDowns.otherModulesDropDowns.DropDown;
import components.otherComponents.inputs.ContactsInput;
import io.qameta.allure.Step;
import model.ContactsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactsPage;

public class ContactsSteps extends AbstractStep {

    private ContactsPage contactsPage;
    public DetailsTab detailsTab;

    public ContactsSteps(WebDriver driver) {
        super(driver);
    }


    @Step("Creating a new contact")
    public ContactsSteps createNewContact(ContactsModel contactsModel) {
        log.info("Creating a new contact");
        contactsPage = new ContactsPage(driver);
        contactsPage.openNewForm();
        ContactForm form = new ContactForm(driver);
        detailsTab = new DetailsTab(driver);
        MainSteps.isFormDisplayed(form, ContactForm.HEADER);
        fillContactForm(contactsModel);
        form.saveForm(ContactForm.SAVE_BUTTON);
        validatePageIsLoaded(contactsPage);
        return this;
    }


    @Step("Filling the form during creating a new contact")
    private void fillContactForm(ContactsModel contactsModel) {
        log.info("Filling the Contact form");
        new ContactsInput(driver, "First Name").insertText(contactsModel.getFirstName());
        new ContactsInput(driver, "Last Name").insertText(contactsModel.getLastName());
        new ContactsDropDown(driver).selectOptionFromDropDown(ContactsDropDown.CONTACT_SALUTATION_DROPDOWN_LOCATOR, contactsModel.getSalutation());
        new ContactsDropDown(driver).selectOptionFromDropDown(DropDown.ACCOUNT_NAME_DROPDOWN, contactsModel.getAccountName());
    }


    @Step("Validation if new contact is created")
    public void validateContactCreated(ContactsModel expectedModel) {
        log.info("Validation created contact");
        detailsTab.openDetailsTab();
        ContactsModel actualModel = getActualModel();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Contact is not valid: %s", actualModel));
    }

    private ContactsModel getActualModel() {
        log.info("Creating an actual contact model");
        ContactsModel contactsModel = new ContactsModel();
        contactsModel.setName(new Name(driver).getNameFieldValue());
        contactsModel.setAccountName(new AccountName(driver).getAccountNameFieldValue());
        return contactsModel;

    }

}

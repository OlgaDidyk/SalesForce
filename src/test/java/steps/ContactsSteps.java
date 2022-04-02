package steps;

import components.account.ContactsDetailsComponent;
import components.forms.CreateContactFormComponent;
import components.forms.DropDown;
import components.forms.Input;
import io.qameta.allure.Step;
import model.ContactsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.ContactsPage;
import utils.ContactModelUtils;

public class ContactsSteps extends AbstractStep {

    private ContactsPage contactsPage;

    public ContactsSteps(WebDriver driver) {
        super(driver);
    }


    @Step("Creating a new contact")
    public ContactsSteps createNewContact(ContactsModel contactsModel) {
        contactsPage = new ContactsPage(driver);
        contactsPage.openNewContactForm();
        CreateContactFormComponent form = new CreateContactFormComponent(driver);

        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed"));

        fillContactForm(contactsModel);
        form.save();
        validatePageIsLoaded(contactsPage);
        return this;
    }


    @Step("Filling the form during creating a new contact")
    private void fillContactForm(ContactsModel contactsModel) {
        new Input(driver, "First Name").newContactInsert(contactsModel.getFirstName());
        new Input(driver, "Last Name").newContactInsert(contactsModel.getLastName());
        new DropDown(driver, "Salutation").selectContactOptions(DropDown.CONTACT_SALUTATION_DROPDOWN_LOCATOR, contactsModel.getSalutation());
        new DropDown(driver, "Account Name").selectContactOptions(DropDown.CONTACT_ACCOUNT_NAME_DROPDOWN_LOCATOR, contactsModel.getAccountName());
    }

    @Step("Validation if new contact is created")
    public void validateContactCreated() {
        contactsPage.openDetailsTab();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getActualAccountName(), ContactModelUtils.getAccountNameFieldData(), "Data in Account Name field is incorrect");
        softAssert.assertEquals(getActualName(), ContactModelUtils.getNameFieldData(), "Data in Name field is incorrect");
        softAssert.assertAll();
    }

    private String getActualAccountName() {
        return ContactsDetailsComponent.getAccountNameTextFieldLocator();
    }

    private String getActualName() {
        return ContactsDetailsComponent.getNameTextFieldLocator();
    }

}

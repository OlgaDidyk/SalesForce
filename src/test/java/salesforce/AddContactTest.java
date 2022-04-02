package salesforce;

import builders.AccountBuilder;
import builders.ContactsBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import model.AccountModel;
import model.ContactsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactTest extends BaseTest {

    static String accountName = "USERNAME";
    static String salutation = "Ms.";
    static String firstName = "FirstName";
    static String lastName = "LastName";

    ContactsModel contactModel = ContactModelUtils.getDefaultContactModel();
    ContactsModel testAccount2 = ContactsBuilder
            .defaultContact()
            //.setPhone("123")
            .build();

    @BeforeMethod
    @Link("https://www.salesforce.com/")
    private void login() {
        mainSteps
                .openSalesforceLoginPage()
                .loginWithValidCreds();
    }

    @Test (description = "Test to add a new Contact")
    //@Description("Some description from the @Description annotation")
    public void addNewContactTest() {
        mainSteps
                .openContactsPage()
                .createNewContact(contactModel)
                .validateContactCreated();
    }

    private ContactsModel buildTestContact(){
        return ContactsBuilder.newValues()
                .setSalutation(salutation)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAccountName(accountName)
                .build();
    }}

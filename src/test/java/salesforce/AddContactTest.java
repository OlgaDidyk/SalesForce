package salesforce;

import builders.AccountBuilder;
import builders.ContactsBuilder;
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
    private void login() {
        mainSteps
                .openSalesforceLoginPage()
                .loginWithValidCreds();
    }

    @Test
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

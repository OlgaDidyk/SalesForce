package salesforce;

import io.qameta.allure.Link;
import model.ContactsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddContactTest extends BaseTest {

/*    static String salutation = "Ms.";
    static String firstName = "FirstName";
    static String lastName = "LastName";*/

/*    ContactsModel contactModel = ContactsModel.builder()
            .salutation(salutation)
            .firstName(firstName)
            .lastName(lastName)
            .accountName(AddAccountTest.accountName)
            .build();*/

/*    ContactsModel contactsModelSplitName = ContactsModel.builder()
            .name(salutation + " " + firstName + " " + lastName)
            .accountName(AddAccountTest.accountName)
            .build();*/

    ContactsModel defaultModel = ContactsModel.builder().build();
    ContactsModel defaultModelSplitName = ContactsModel.builder()
            .name(ContactsModel.salutation + " " + ContactsModel.firstName + " " + ContactsModel.lastName)
            .build();


    @BeforeMethod
    @Link("https://www.salesforce.com/")
    private void login() {
        mainSteps
                .openLoginPage()
                .loginWithValidCreds();
    }

    @Test(description = "Test to add a new Contact")
    public void addNewContactTest() {
        mainSteps
                .openContactsPage()
                .createNewContact(defaultModel)
                .validateContactCreated(defaultModelSplitName);
    }

}

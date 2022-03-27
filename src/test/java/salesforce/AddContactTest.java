package salesforce;

import model.ContactsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactTest extends BaseTest {

    ContactsModel contactModel = ContactModelUtils.getDefaultContactModel();

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

}

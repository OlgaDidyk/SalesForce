package tests;

import io.qameta.allure.Link;
import model.ContactsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners({TestListener.class})
public class AddContactTest extends BaseLogin {

    ContactsModel defaultModel = ContactsModel.builder().build();
    ContactsModel defaultModelSplitName = ContactsModel.builder()
            .name(ContactsModel.salutation + " " + ContactsModel.firstName + " " + ContactsModel.lastName)
            .build();
    BaseLogin baseLogin = new BaseLogin();

    @BeforeMethod
    @Link("https://www.salesforce.com/")
    public void login() {
        baseLogin.login();
    }


    @Test(description = "Test to add a new Contact")
    public void addNewContactTest() {
        mainSteps
                .openContactsPage()
                .createNewContact(defaultModel)
                .validateContactCreated(defaultModelSplitName);
    }

}

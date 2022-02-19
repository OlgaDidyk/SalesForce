package utils;

import model.ContactsModel;

public class ContactModelUtils {
    static String accountName = "USERNAME";
    static String salutation = "Ms.";
    static String firstName = "FirstName";
    static String lastName = "LastName";


    public static ContactsModel getDefaultContactModel() {
        ContactsModel contactsModel = new ContactsModel();
        contactsModel.setSalutation(salutation);
        contactsModel.setFirstName(firstName);
        contactsModel.setLastName(lastName);
        contactsModel.setAccountName(accountName);

        return contactsModel;
    }

    public static String getAccountNameFieldData() {

        ContactsModel contactsModel = new ContactsModel();
        contactsModel.setAccountName(accountName);
        return accountName;
    }

    public static String getNameFieldData() {
        ContactsModel contactsModel = new ContactsModel();
        contactsModel.setSalutation(salutation);
        contactsModel.setFirstName(firstName);
        contactsModel.setLastName(lastName);
        String nameField = salutation + " " + firstName + " " + lastName;
        return nameField;
    }
}

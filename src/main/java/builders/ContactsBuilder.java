package builders;

import model.AccountModel;
import model.ContactsModel;

public class ContactsBuilder {

    static String accountName = "USERNAME";
    static String salutation = "Ms.";
    static String firstName = "FirstName";
    static String lastName = "LastName";

    ContactsModel contactsModel = new ContactsModel();

    public static ContactsBuilder newValues(){
        return new ContactsBuilder();
    }

    public static ContactsBuilder defaultContact() {
        ContactsModel contactsModel = new ContactsModel();
        contactsModel.setSalutation(salutation);
        contactsModel.setFirstName(firstName);
        contactsModel.setLastName(lastName);
        contactsModel.setAccountName(accountName);
        return new ContactsBuilder(contactsModel);
    }

    public ContactsBuilder() {
    }

    public ContactsBuilder(ContactsModel contactsModel) {
        this.contactsModel = contactsModel;
    }

    public ContactsBuilder setAccountName(String accountName) {
        this.contactsModel.setAccountName(accountName);
        return this;
    }

    public ContactsBuilder setSalutation(String salutation) {
        this.contactsModel.setSalutation(salutation);
        return this;
    }

    public ContactsBuilder setFirstName(String firstName) {
        this.contactsModel.setFirstName(firstName);
        return this;
    }

    public ContactsBuilder setLastName(String lastName) {
        this.contactsModel.setLastName(lastName);
        return this;
    }

    public ContactsModel build() {
        return contactsModel;
    }

}

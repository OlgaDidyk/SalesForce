package model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactsModel {

    @Builder.Default
    public static String salutation = "Ms.";
    @Builder.Default
    public static String firstName = "FirstName";
    @Builder.Default
    public static String lastName = "LastName";
    @Builder.Default
    public  String accountName = AccountModel.accountName;
    //@Builder.Default
    public String name = salutation + " " + firstName + " " + lastName;

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

/*    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

   /* public ContactsModel() {
    }

    public String getSalutation() {
        return Salutation;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsModel contact = (ContactsModel) o;
        return Objects.equals(Salutation, contact.Salutation) && Objects.equals(FirstName, contact.FirstName) && Objects.equals(LastName, contact.LastName) && Objects.equals(AccountName, contact.AccountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Salutation, FirstName, LastName, AccountName);
    }*/
}

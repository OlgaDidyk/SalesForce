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
    public String accountName = AccountModel.accountName;
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

}

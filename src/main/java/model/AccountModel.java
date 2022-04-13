package model;

import lombok.*;

import java.util.Objects;

//Модели используются всегда и везде. Через модели работают почти все фреймворки
// в пакете model хранятся сущности. В нашем случае сущность - это Аккаунт, Contacts

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AccountModel {

    @Builder.Default
    public static String accountName = "USERNAME";
    @Builder.Default
    public String phone = "+3245242352";
    @Builder.Default
    public String website = "teachmeskills.by";
    @Builder.Default
    public int employees = 10;
    @Builder.Default
    public String type = "Customer";
    @Builder.Default
    public String industry = "Banking";

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
/*
// Объект pojo(java объект) должен обязательно содержать пустой конструктор, геттеры и сеттеры,
// переопределить equals и hashcode для того чтобы сравнивать эти объекты

    public AccountModel() {
    }

    public String getAccountName() {
        return AccountName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getWebsite() {
        return Website;
    }

    public int getEmployees() {
        return Employees;
    }

    public String getType() {
        return Type;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public void setEmployees(int employees) {
        Employees = employees;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountModel account = (AccountModel) o;
        return Employees == account.Employees && Objects.equals(AccountName, account.AccountName) && Objects.equals(Phone, account.Phone) && Objects.equals(Website, account.Website) && Objects.equals(Type, account.Type) && Objects.equals(Industry, account.Industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountName, Phone, Website, Employees, Type, Industry);
    }

    //toString не является обязательным для pojo объекта, но он может пригодятся когда мы
    // пишем сообщения об ошибках с данными из теста, когда что-то не совпадает
    @Override
    public String toString() {
        return "Account{" +
                "AccountName='" + AccountName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Website='" + Website + '\'' +
                ", Employees=" + Employees +
                ", Type='" + Type + '\'' +
                ", Industry='" + Industry + '\'' +
                '}';
    }
*/
}

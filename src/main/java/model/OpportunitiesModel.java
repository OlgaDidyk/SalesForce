package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OpportunitiesModel {

    @Builder.Default
    public String opportunityName = "NameModelByLombok";
    @Builder.Default
    public String accountName = AccountModel.accountName;
    @Builder.Default
    public String closeDate = "12/24/2023";
    @Builder.Default
    public String stage = "Qualification";

/* @AllArgsConstructor    public OpportunitiesModel2(String opportunityName, String accountName, String closeDate, String stage) {
        this.opportunityName = opportunityName;
        this.accountName = accountName;
        this.closeDate = closeDate;
        this.stage = stage;
    }*/

/* @NoArgsConstructor   public OpportunitiesModel2() {
            }*/

/* @Getter    public String getOpportunityName() {
        return opportunityName;
    }*/

/* @Setter    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }*/

/* @Getter    public String getAccountName() {
        return accountName;
    }*/

/* @Setter    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }*/

/* @Getter    public String getCloseDate() {
        return closeDate;
    }*/

/* @Setter    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }*/

/* @Getter    public String getStage() {
        return stage;
    }*/

/* @Setter    public void setStage(String stage) {
        this.stage = stage;
    }*/

/* @EqualsAndHashCode    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpportunitiesModel2 that = (OpportunitiesModel2) o;
        return Objects.equals(opportunityName, that.opportunityName) && Objects.equals(accountName, that.accountName) && Objects.equals(closeDate, that.closeDate) && Objects.equals(stage, that.stage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opportunityName, accountName, closeDate, stage);
    }*/
}

package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OpportunitiesModel {

    @Builder.Default
    public String opportunityName = "OpportunityName";
    @Builder.Default
    public String accountName = AccountModel.accountName;
    @Builder.Default
    public String closeDate = "12/24/2023";
    @Builder.Default
    public String stage = "Qualification";

}

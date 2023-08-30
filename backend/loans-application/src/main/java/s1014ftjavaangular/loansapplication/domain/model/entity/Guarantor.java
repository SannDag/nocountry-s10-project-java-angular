package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.IdentificationType;

@Data
@Builder
public class Guarantor {

    private String loanApplicationId;
    private String name;
    private String lastname;
    private IdentificationType identificationType;
    private String identification;
    private String city;
    private String state;
    private String address;
    private String apartment;
    private String zipcode;
    private String phone;
}

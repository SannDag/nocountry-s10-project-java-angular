package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.HousingStatus;

@Data
@Builder
public class GeneralData {

    private String loanApplicationId;
    private HousingStatus housingStatus;
    private Integer yearsInHouse;
    private Integer monthsInHouse;
    private String city;
    private String state;
    private String address;
    private String apartment;
    private String zipcode;
}

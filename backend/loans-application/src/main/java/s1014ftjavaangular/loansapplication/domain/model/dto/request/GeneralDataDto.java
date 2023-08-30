package s1014ftjavaangular.loansapplication.domain.model.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.HousingStatus;
@Data
@Builder
public class GeneralDataDto {

    @NotNull
    private String loanApplicationId;
    @NotEmpty(message = "Field required")
    private HousingStatus housingStatus;
    @NotEmpty(message = "Field required")
    private Integer yearsInHouse;
    @NotEmpty(message = "Field required")
    private Integer monthsInHouse;
    @NotEmpty(message = "Field required")
    private String city;
    @NotEmpty(message = "Field required")
    private String state;
    @NotEmpty(message = "Field required")
    private String address;
    @NotEmpty(message = "Field required")
    private String apartment;
    @NotEmpty(message = "Field required")
    private String zipcode;
    @NotEmpty(message = "Field required")
    private String phone;


}

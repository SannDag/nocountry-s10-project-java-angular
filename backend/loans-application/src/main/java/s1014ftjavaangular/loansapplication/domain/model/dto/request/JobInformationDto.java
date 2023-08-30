package s1014ftjavaangular.loansapplication.domain.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s1014ftjavaangular.loansapplication.domain.model.enums.WorkShift;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobInformationDto {

    @NotNull
    private String loanApplicationId;
    @NotEmpty(message = "Field required")
    private String company;
    @NotEmpty(message = "Field required")
    private String occupation;
    @NotEmpty(message = "Field required")
    private WorkShift workShift;
    @NotEmpty(message = "Field required")
    private Integer yearsInCompany;
    @NotEmpty(message = "Field required")
    private Double monthlyIncome;
    private Double otherIncome;
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
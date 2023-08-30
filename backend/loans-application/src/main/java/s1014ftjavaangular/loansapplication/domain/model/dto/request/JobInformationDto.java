package s1014ftjavaangular.loansapplication.domain.model.dto.request;

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
    private String loanApplicationId;
    private String company;
    private String occupation;
    private WorkShift workShift;
    private Integer yearsInCompany;
    private Double monthlyIncome;
    private Double otherIncome;
    private String city;
    private String state;
    private String address;
    private String phone;
}

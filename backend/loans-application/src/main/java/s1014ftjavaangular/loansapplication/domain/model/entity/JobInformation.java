package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.WorkShift;

@Data
@Builder
public class JobInformation {

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

package s1014ftjavaangular.loansapplication.domain.model.dto.request;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.entity.PersonalReferences;
import s1014ftjavaangular.loansapplication.domain.model.enums.WorkShift;

import java.util.List;

@Data
@Builder
public class LoanApplicationFormDto {

    //to do

    //user id
    private String customerId;

    //job information
    private String company;
    private String occupation;
    private WorkShift workShift;
    private Integer yearsInCompany;
    private Double monthlyIncome;
    private Double otherIncome;
    private String phone;

    //parents reference
    private String spousesName;
    private String spousesPhone;
    private String familyName;
    private String familyPhone;
    private List<PersonalReferences> personalReferencesList;


}

package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class LoansApplication {

    private String loanApplicationId;

    private String customersUuid;

    private String loanApplicationNumber;

    private Double requestedAmount;

    private LocalDate creationDate;

    private JobInformation jobInformation;

    private List<References> references;

    private Guarantor guarantor;

    private Status status;

}

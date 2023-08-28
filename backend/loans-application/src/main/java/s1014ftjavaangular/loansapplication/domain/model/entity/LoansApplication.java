package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loansapplication.domain.model.enums.Status;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.CreditAuditEntity;

import java.time.LocalDate;

@Data
@Builder
public class LoansApplication {

    private String loanApplicationId;

    private String customersUuid;
    private CreditAudit creditAuditorId;

    private String loanApplicationNumber;

    private Double requestedAmount;

    private LocalDate creationDate;

    private JobInformation jobInformation;

    private Guarantor guarantor;

    private Status status;

}

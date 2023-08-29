package s1014ftjavaangular.loan.domain.model.entities;


import lombok.Builder;
import lombok.Data;
import s1014ftjavaangular.loan.domain.model.enums.LoanStatus;

import java.time.LocalDate;


@Data
@Builder
public class Loan {
    private String loanId;

    private String loanApplicationId;

    private LocalDate createAt;

    private String loanNumber;

    private Double amountApproved;

    private String calculationType;

    private String numberInstallments;

    private String frequencyPayment;

    private LoanStatus status;
}

package s1014ftjavaangular.loan.domain.model.dtos;

import lombok.*;

import java.time.LocalDate;

@Value
public class ApplicationLoanMessage {
    String applicationLoanId;
    Double amountApproved;
    LocalDate approvedDate;
}

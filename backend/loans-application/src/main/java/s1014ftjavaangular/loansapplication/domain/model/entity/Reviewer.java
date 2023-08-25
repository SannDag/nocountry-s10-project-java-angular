package s1014ftjavaangular.loansapplication.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Reviewer {
    private String reviewerId;
    private LocalDate initDate;
    private String loanApplicationNumber;
}

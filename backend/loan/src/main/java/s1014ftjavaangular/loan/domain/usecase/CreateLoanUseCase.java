package s1014ftjavaangular.loan.domain.usecase;

import s1014ftjavaangular.loan.domain.model.dtos.ApplicationLoanMessage;

public interface CreateLoanUseCase {
    void createLoan(final ApplicationLoanMessage message);
}

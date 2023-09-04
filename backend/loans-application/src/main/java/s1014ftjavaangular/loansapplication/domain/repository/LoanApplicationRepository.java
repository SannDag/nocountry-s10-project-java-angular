package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;

public interface LoanApplicationRepository {
    void updateLoanApplicationStatus(final LoanApplication dto);
    void updateLoanApplication(final Double requestAmount, final String id);
    LoanApplication findById(final String id);
}

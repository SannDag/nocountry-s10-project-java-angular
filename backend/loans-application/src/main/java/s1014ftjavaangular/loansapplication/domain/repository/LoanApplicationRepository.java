package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;

public interface LoanApplicationRepository {

    LoanApplication findById(final String id);
    void saveLoanApplication(final LoanApplication model);

    String findLastLoanApplicationNumber();

    Integer countOfInactiveOrAuditingLoanApplicatin(final String identification);
}

package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.dto.LoanApplicationForCustomer;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;

import java.util.List;
import java.util.Set;

public interface LoanApplicationRepository {

    void updateLoanApplicationStatus(final LoanApplication dto);
    void updateLoanApplication(final Double requestAmount, final String id);

    List<LoanApplicationForCustomer> findByCustomerId(final String customerId);
    LoanApplication findById(final String id);

    void saveLoanApplication(final LoanApplication model);

    String findLastLoanApplicationNumber();

    Integer countOfInactiveOrAuditingLoanApplicatin(final String identification);

}

package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;

public interface GuarantorRepository {
    void updateGuarantor(final Guarantor dto, final LoanApplication loanApplication);
    void deleteGuarantor(final String id);
}

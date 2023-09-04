package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.entity.GeneralData;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;

public interface GeneralDataRepository {
    void updateGeneralData(final GeneralData model, final LoanApplication loanApplication);
    void deleteGeneralDataById(final String id);
}

package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationFormDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoansApplication;

public interface LoanApplicationRepository {
    void updateLoanApplicationStatus(final LoansApplication dto);
}

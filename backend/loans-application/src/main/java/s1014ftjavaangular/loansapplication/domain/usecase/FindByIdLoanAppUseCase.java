package s1014ftjavaangular.loansapplication.domain.usecase;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationDto;

public interface FindByIdLoanAppUseCase {

    LoanApplicationDto findById(String id);

}

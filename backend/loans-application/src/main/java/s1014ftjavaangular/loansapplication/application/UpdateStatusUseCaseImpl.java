package s1014ftjavaangular.loansapplication.application;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoansApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateStatusUseCase;

@Service
@RequiredArgsConstructor
public class UpdateStatusUseCaseImpl implements UpdateStatusUseCase {

    private final LoanApplicationRepository repository;
    @Override
    public void updateStatus(LoansApplication request) {
        repository.updateLoanApplicationStatus(request);
    }
}
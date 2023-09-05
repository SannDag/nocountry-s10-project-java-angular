package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateStatusUseCase;

@Service
@RequiredArgsConstructor
public class UpdateStatusUseCaseImpl implements UpdateStatusUseCase {

    private final LoanApplicationRepository repository;
    @Override
    public void updateStatus(LoanApplication request) {
        repository.updateLoanApplicationStatus(request);
    }
}
package s1014ftjavaangular.loansapplication.application;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.mapper.LoanApplicationMapper;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.LoanApplicationDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.FindByIdLoanAppUseCase;

@RequiredArgsConstructor
@Service
public class FindByIdLoanAppUseCaseImpl implements FindByIdLoanAppUseCase {
    private final LoanApplicationRepository repository;
    private final LoanApplicationMapper mapper;

    @Override
    public LoanApplicationDto findById(String id) {
        LoanApplication entity = repository.findById(id);
        if(entity == null){
            throw new NotFoundException("Loan Application was not found");
        }

        return null;
    }
}

package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.exceptions.ResourceAlreadyExists;
import s1014ftjavaangular.loansapplication.domain.mapper.GuarantorMapper;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.GeneralData;
import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGuarantorUseCase;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SaveGuarantorUseCaseImpl implements SaveGuarantorUseCase {
    private final GuarantorRepository guarantorRepository;
    private final LoanApplicationRepository loanApplicationRepository;
    private final GuarantorMapper guarantorMapper;


    @Override
    public void saveGuarantor(GuarantorDto request) {
        var loanApplication = loanApplicationRepository.findById(request.getLoanApplicationId());

        if(loanApplication.getGuarantor() != null) throw new ResourceAlreadyExists("Guarantor is already registered");


        guarantorRepository.saveGuarantor(guarantorMapper.dtoToModel.apply(request), loanApplication);

    }

}

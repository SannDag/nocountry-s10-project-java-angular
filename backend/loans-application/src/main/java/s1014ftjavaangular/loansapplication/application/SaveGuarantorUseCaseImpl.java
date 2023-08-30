package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGuarantorUseCase;

@Service
@RequiredArgsConstructor
public class SaveGuarantorUseCaseImpl implements SaveGuarantorUseCase {

    private final GuarantorRepository guarantorRepository;

    @Override
    public void saveGuarantor(GuarantorDto request) {
        guarantorRepository.saveGuarantor(request);
    }
}

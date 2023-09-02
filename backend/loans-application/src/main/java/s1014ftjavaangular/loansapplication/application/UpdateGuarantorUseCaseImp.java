package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateGuarantorUseCase;

@Service
@RequiredArgsConstructor
public class UpdateGuarantorUseCaseImp implements UpdateGuarantorUseCase {
    private final GuarantorRepository repository;
    @Override
    public void updateGuarantor(GuarantorDto request) {
        repository.updateGuarantor(request);
    }
}
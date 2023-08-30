package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GeneralDataDto;
import s1014ftjavaangular.loansapplication.domain.repository.GeneralDataRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveGeneralDataUseCase;

@Service
@RequiredArgsConstructor
public class SaveGeneralDataUseCaseImpl implements SaveGeneralDataUseCase {

    private final GeneralDataRepository repository;

    @Override
    public void saveGeneralData(GeneralDataDto request) {
        repository.saveGeneralData(request);
    }
}

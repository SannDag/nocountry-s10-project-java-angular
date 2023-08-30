package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.SaveJobInformationUseCase;

@Service
@RequiredArgsConstructor
public class SaveJobInformationUseCaseImpl implements SaveJobInformationUseCase {

    private final JobInformationRepository repository;

    @Override
    public void saveJobInformation(JobInformationDto request) {
        repository.saveJobInformation(request);
    }
}

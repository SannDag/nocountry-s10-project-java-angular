package s1014ftjavaangular.loansapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.domain.usecase.UpdateJobInformationUseCase;

@Service
@RequiredArgsConstructor
public class UpdateJobInformationUseCaseImp implements UpdateJobInformationUseCase {

    private final JobInformationRepository repository;

    @Override
    public void updateJobInformation(JobInformationDto request) {
        repository.updateJobInformation(request);
    }
}

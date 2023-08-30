package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.dto.request.JobInformationDto;

public interface JobInformationRepository {
    void updateJobInformation(final JobInformationDto dto);
}

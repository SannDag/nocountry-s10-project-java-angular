package s1014ftjavaangular.loansapplication.domain.repository;

import s1014ftjavaangular.loansapplication.domain.model.entity.JobInformation;

public interface JobInformationRepository {

    void saveJobInformation(final JobInformation model);
}
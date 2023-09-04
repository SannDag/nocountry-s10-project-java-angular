package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.jobInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.entity.JobInformation;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.JobInformationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.JobInformationEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationFormJpaRepository;

@Repository
@RequiredArgsConstructor
public class JobInformationRepositoryAdapter implements JobInformationRepository {
    private final JobInformationJpaRepository jpaRepository;
    private final LoanApplicationFormJpaRepository loanApplicationFormJpaRepository;

    @Transactional
    @Override
    public void updateJobInformation(JobInformation model, LoanApplication loanApplication) {
        if(model == null) throw new IllegalArgumentException("");
        jpaRepository.save(JobInformationEntity.modelToEntity.apply(model, loanApplication));
    }

    @Override
    public void deleteJobInformation(String id) {
        jpaRepository.deleteById(id);
    }

}

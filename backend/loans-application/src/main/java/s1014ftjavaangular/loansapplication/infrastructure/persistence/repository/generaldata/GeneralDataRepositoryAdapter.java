package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.generaldata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.entity.GeneralData;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.GeneralDataRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GeneralDataEntity;

@Repository
@RequiredArgsConstructor
public class GeneralDataRepositoryAdapter implements GeneralDataRepository {
    private final GeneralDataJpaRepository jpaRepository;

    @Override
    public void updateGeneralData(GeneralData model, LoanApplication loanApplication) {
        if(model == null) throw new IllegalArgumentException("Request cannot be empty");

        jpaRepository.save(GeneralDataEntity.modelToEntity.apply(model, loanApplication));
    }

    @Override
    public void deleteGeneralDataById(String id) {
        jpaRepository.deleteById(id);
    }
}

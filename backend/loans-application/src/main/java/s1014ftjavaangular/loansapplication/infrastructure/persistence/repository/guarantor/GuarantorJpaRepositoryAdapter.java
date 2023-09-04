package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.guarantor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GuarantorEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationFormJpaRepository;

@Repository
@RequiredArgsConstructor
public class GuarantorJpaRepositoryAdapter implements GuarantorRepository {

    private final GuarantorJpaRepository jpaRepository;
    private final LoanApplicationFormJpaRepository loanApplicationFormJpaRepository;

    @Transactional
    @Override
    public void updateGuarantor(Guarantor model, LoanApplication loanApplication) {
        if(model == null) throw new IllegalArgumentException("Request cannot be empty");

        jpaRepository.save(GuarantorEntity.modelToEntity.apply(model, loanApplication));
    }
    @Transactional
    @Override
    public void deleteGuarantor(String id) {
        jpaRepository.deleteById(id);
    }
}

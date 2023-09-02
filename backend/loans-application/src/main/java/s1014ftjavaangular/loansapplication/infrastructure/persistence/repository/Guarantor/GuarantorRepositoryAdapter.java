package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.Guarantor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.GuarantorEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationJpaRepository;

import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class GuarantorRepositoryAdapter implements GuarantorRepository {

    private final GuarantorJpaRepository jpaRepository;
    private final LoanApplicationJpaRepository loanApplicationJpaRepository;

    private final Function<Guarantor, GuarantorEntity> modelToEntity = (model) -> {
        GuarantorEntity entity = new GuarantorEntity();
            entity.setLoanApplicationId(model.getLoanApplicationId());
            entity.setName(model.getName());
            entity.setLastname(model.getLastname());
            entity.setIdentificationType(model.getIdentificationType());
            entity.setIdentification(model.getIdentification());
            entity.setCity(model.getCity());
            entity.setState(model.getState());
            entity.setAddress(model.getAddress());
            entity.setApartment(model.getApartment());
            entity.setPhone(model.getPhone());
            entity.setZipcode(model.getZipcode());

            return entity;

    };

    @Override
    public void saveGuarantor(Guarantor model) {
        if(model == null) throw new IllegalArgumentException("The guarantor information cannot be empty");

        Optional<LoanApplicationEntity> loanApplication = loanApplicationJpaRepository.findById(model.getLoanApplicationId());

        if (!loanApplication.isPresent()) {
            throw new IllegalArgumentException("Loan application not found");
        }

            jpaRepository.save(modelToEntity.apply(model));

    }
}

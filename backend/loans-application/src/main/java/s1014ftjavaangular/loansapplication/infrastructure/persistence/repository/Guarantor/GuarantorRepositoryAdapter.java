package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.Guarantor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
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

    private final Function<GuarantorDto, GuarantorEntity> modelToEntity = (dto) -> {
        GuarantorEntity entity = new GuarantorEntity();
            entity.setLoanApplicationId(dto.getLoanApplicationId());
            entity.setName(dto.getName());
            entity.setLastname(dto.getLastname());
            entity.setIdentificationType(dto.getIdentificationType());
            entity.setIdentification(dto.getIdentification());
            entity.setCity(dto.getCity());
            entity.setState(dto.getState());
            entity.setAddress(dto.getAddress());
            entity.setApartment(dto.getApartment());
            entity.setPhone(dto.getPhone());
            entity.setZipcode(dto.getZipcode());

            return entity;

    };

    @Override
    public void saveGuarantor(GuarantorDto dto) {
        if(dto == null) throw new IllegalArgumentException("The guarantor information cannot be empty");

        Optional<LoanApplicationEntity> loanApplication = loanApplicationJpaRepository.findById(dto.getLoanApplicationId());
        if (!loanApplication.isPresent()) {
            throw new IllegalArgumentException("Loan application not found");
        }

            jpaRepository.save(modelToEntity.apply(dto));

    }
}

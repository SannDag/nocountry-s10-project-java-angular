package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.guarantor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.dto.request.GuarantorDto;
import s1014ftjavaangular.loansapplication.domain.repository.GuarantorRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication.LoanApplicationFormJpaRepository;

@Repository
@AllArgsConstructor
public class GuarantorJpaRepositoryAdapter implements GuarantorRepository {

    private final GuarantorJpaRepository guarantorJpaRepository;
    private final LoanApplicationFormJpaRepository loanApplicationFormJpaRepository;

    @Transactional
    @Override
    public void updateGuarantor(GuarantorDto dto) {
        var loanApplicationEntity = loanApplicationFormJpaRepository.findById(dto.getLoanApplicationId()).get();
        var loanApplicationStatus = loanApplicationEntity.getStatus().toString();
        if (loanApplicationStatus.equals("INCOMPLETE")){
        if(dto == null) throw new IllegalArgumentException("The request cannot be empty");
        var isGuarantorExists = guarantorJpaRepository.existsByUuid(dto.getLoanApplicationId());
        if (!isGuarantorExists) throw new RuntimeException("Guarantor does not exists");

        var entity = guarantorJpaRepository.findById(dto.getLoanApplicationId()).get();

        if (dto.getLoanApplicationId() != null) entity.setLoanApplicationId(dto.getLoanApplicationId());
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getLastname() != null) entity.setLastname(dto.getLastname());
        if (dto.getIdentificationType() != null) entity.setIdentificationType(dto.getIdentificationType());
        if (dto.getIdentification() != null) entity.setIdentification(dto.getIdentification());
        if (dto.getCity() != null) entity.setCity(dto.getCity());
        if (dto.getState() != null) entity.setState(dto.getState());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getZipcode() != null) entity.setZipcode(dto.getZipcode());
        if (dto.getPhone() != null) entity.setPhone(dto.getPhone());

        }
        else{
            throw new IllegalArgumentException("You cannot update this form");
        }
    }
}
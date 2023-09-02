package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoansApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    private final LoanApplicationFormJpaRepository jpaRepository;

    @Transactional
    @Override
    public void updateLoanApplicationStatus(LoansApplication dto) {
        var loanApplication = jpaRepository.findById(dto.getLoanApplicationId()).get();
        var loanApplicationStatus = loanApplication.getStatus().toString();
        if (loanApplicationStatus.equals("REVIEW")){
            var isLoanApplicationExists = jpaRepository.existsById(dto.getLoanApplicationId());
            if(!isLoanApplicationExists) throw new RuntimeException("Loan Application does not exists");

            if(dto.getLoanApplicationId() == null) loanApplication.setLoanApplicationId(loanApplication.getLoanApplicationId());
            if(dto.getCustomersUuid() == null) loanApplication.setCustomersUuid(loanApplication.getCustomersUuid());
            if(dto.getLoanApplicationNumber() == null) loanApplication.setLoanApplicationNumber(loanApplication.getLoanApplicationNumber());
            if(dto.getRequestedAmount() == null) loanApplication.setRequestedAmount(loanApplication.getRequestedAmount());
            if(dto.getCreatedAt() == null) loanApplication.setCreateAt(loanApplication.getCreateAt());
            if(dto.getJobInformation() == null) loanApplication.setJobInformation(loanApplication.getJobInformation());
            if(dto.getGuarantor() == null) loanApplication.setGuarantor(loanApplication.getGuarantor());
            if(dto.getCreditAuditorId() == null) loanApplication.setCreditAuditId(loanApplication.getCreditAuditId());
            if(dto.getStatus() == null) loanApplication.setStatus(loanApplication.getStatus());

            if(dto.getLoanApplicationId() != null) loanApplication.setLoanApplicationId(loanApplication.getLoanApplicationId());
            if(dto.getCustomersUuid() != null) loanApplication.setCustomersUuid(loanApplication.getCustomersUuid());
            if(dto.getLoanApplicationNumber() != null) loanApplication.setLoanApplicationNumber(loanApplication.getLoanApplicationNumber());
            if(dto.getRequestedAmount() != null) loanApplication.setRequestedAmount(loanApplication.getRequestedAmount());
            if(dto.getCreatedAt() != null) loanApplication.setCreateAt(loanApplication.getCreateAt());
            if(dto.getJobInformation() != null) loanApplication.setJobInformation(loanApplication.getJobInformation());
            if(dto.getGuarantor() != null) loanApplication.setGuarantor(loanApplication.getGuarantor());
            if(dto.getCreditAuditorId() != null) loanApplication.setCreditAuditId(loanApplication.getCreditAuditId());
            if(dto.getStatus() != null) loanApplication.setStatus(dto.getStatus());

            jpaRepository.save(loanApplication);
        } else {
            throw new RuntimeException("You cannot update this form");
        }
    }
}

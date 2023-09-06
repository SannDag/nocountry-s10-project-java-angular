package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.loanApplication;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.dto.LoanApplicationForCustomer;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Repository
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    private final LoanApplicationJpaRepository jpaRepository;

    @Transactional
    @Override
    public String findLastLoanApplicationNumber(){
        var lastNumber = jpaRepository.findLastLoanApplicationNumber();
        return lastNumber.isEmpty() ? "" : lastNumber.get();
    }

    @Override
    public void updateLoanApplicationStatus(LoanApplication dto) {

    }

    @Transactional
    @Override
    public void updateLoanApplication(Double updatedRequestedAmount, String id) {
        var entity = jpaRepository.findById(id).get();
        entity.setRequestedAmount(updatedRequestedAmount);
        jpaRepository.save(entity);
    }

    @Override
    public List<LoanApplicationForCustomer> findByCustomerId(String customerId) {
        if(customerId == null) throw new IllegalArgumentException("Identification cannot be empty");

        var response = jpaRepository.findByCustomerId(customerId);
        return response.isEmpty() ? List.of() : response.get();
    }

    @Transactional
    @Override
    public Integer countOfInactiveOrAuditingLoanApplicatin(String identification) {
        if(identification == null) throw new IllegalArgumentException("Identification cannot be empty");

        return jpaRepository.countIncompleteOrAuditingStatusLoanApplication(identification);
    }

    @Override
    public LoanApplication findById(String id) {
        if(id == null) throw new IllegalArgumentException("ID cannot be empty");

        var loan = jpaRepository.findById(id);

        return loan.isEmpty()
                ? null
                : loan.map(entity-> entity.entityToModel());
    }

    @Override
    public void saveLoanApplication(LoanApplication model) {
        if(model == null) throw new IllegalArgumentException("The request cannot be empty");

        jpaRepository.save(LoanApplicationEntity.modelToEntity(model));
    }

}

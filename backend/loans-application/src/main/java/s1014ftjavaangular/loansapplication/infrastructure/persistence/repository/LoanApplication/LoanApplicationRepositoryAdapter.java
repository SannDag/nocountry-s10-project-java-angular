package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.model.enums.Status;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;

@Repository
@RequiredArgsConstructor
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {
    private final LoanApplicationFormJpaRepository jpaRepository;

    @Override
    public void updateLoanApplicationStatus(LoanApplication dto) {

    }

    @Transactional
    @Override
    public void updateLoanApplication(Double updatedRequestedAmount, String id) {
        var entity = jpaRepository.findById(id).get();
        entity.setRequestedAmount(updatedRequestedAmount);
    }

    @Transactional(readOnly = true)
    @Override
    public LoanApplication findById(String id) {
        if(id == null) throw new IllegalArgumentException("ID cannot be empty");

        var loan = jpaRepository.findById(id);

        if(loan.isEmpty()) throw new NotFoundException("Loan application with id " + id + "was not found.");

        return loan.get().entityToModel();
    }
}

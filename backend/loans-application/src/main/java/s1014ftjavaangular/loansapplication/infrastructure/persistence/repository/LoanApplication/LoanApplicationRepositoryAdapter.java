package s1014ftjavaangular.loansapplication.infrastructure.persistence.repository.LoanApplication;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import s1014ftjavaangular.loansapplication.domain.model.entity.LoanApplication;
import s1014ftjavaangular.loansapplication.domain.repository.LoanApplicationRepository;
import s1014ftjavaangular.loansapplication.infrastructure.persistence.entities.LoanApplicationEntity;

@RequiredArgsConstructor
@Repository
public class LoanApplicationRepositoryAdapter implements LoanApplicationRepository {

    private final LoanApplicationJpaRepository jpaRepository;

    @Override
    public LoanApplication findById(String id) {
        var loan = jpaRepository.findById(id).get();

        if(loan == null){
            throw new NotFoundException("Loan application with id " + id + "was not found.");
        }

        return LoanApplication.builder()
                .loanApplicationId(loan.getLoanApplicationId())
                .customersUuid(loan.getCustomersUuid())
                .loanApplicationNumber(loan.getLoanApplicationNumber())
                .requestedAmount(loan.getRequestedAmount())
                .createAt(loan.getCreateAt())
                .status(loan.getStatus())
                //faltaría JobInformation, Guarantor, GeneralData y Credit Audit pero tengo error
                // con las relaciones, y no encontré como mapearlas todavía
                .build();
    }

    @Override
    public void saveLoanApplication(LoanApplication request) {
        jpaRepository.save(LoanApplicationEntity.modelToEntity(request));
    }

}

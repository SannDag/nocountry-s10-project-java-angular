package s1014ftjavaangular.loan.infrastructure.persistence.repository;

import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.LoanStatus;
import s1014ftjavaangular.loan.domain.repository.LoanRepository;
import s1014ftjavaangular.loan.infrastructure.persistence.entities.LoanEntity;

import java.util.function.Function;

public class LoanRepositoryAdapter implements LoanRepository {
    private LoanJpaRepository repository;

    private Function<Loan, LoanEntity> modelToEntity =
            (model)-> LoanEntity.builder()
                    .loanId(model.getLoanId())
                    .loanApplicationId(model.getLoanApplicationId())
                    .loanNumber(model.getLoanNumber())
                    .amountApproved(model.getAmountApproved())
                    .createAt(model.getCreateAt())
                    .status(model.getStatus())
            .build();
    @Override
    public String getLastLoanNumber() {
        var number = repository.findLastLoanNumber();
        return number.isEmpty()
                ? ""
                : number.get();
    }

    @Override
    public void saveLoan(Loan loan) {
        var entity = modelToEntity.apply(loan);
        repository.save(entity);
    }
}

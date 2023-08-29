package s1014ftjavaangular.loan.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import s1014ftjavaangular.loan.domain.model.dtos.ApplicationLoanMessage;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.LoanStatus;
import s1014ftjavaangular.loan.domain.repository.LoanRepository;
import s1014ftjavaangular.loan.domain.usecase.CreateLoanUseCase;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public final class CreateLoanUseCaseImpl implements CreateLoanUseCase {
    private final LoanRepository repository;

    @Override
    public void createLoan(final ApplicationLoanMessage message) {
        var lastLoanNumber =repository.getLastLoanNumber();
        var updateLoanNumber = createNextLoanNumber(lastLoanNumber);

        var loan = Loan.builder()
                .loanId(UUID.randomUUID().toString())
                .loanApplicationId(message.getApplicationLoanId())
                .loanNumber(updateLoanNumber)
                .amountApproved(message.getAmountApproved())
                .createAt(message.getApprovedDate())
                .status(LoanStatus.NORMAL)
                .build();

        repository.saveLoan(loan);
    }

    private String createNextLoanNumber(String lastLoanNumber){
        //Se debe desarrollar la logica para el siguiente numero
        if (!StringUtils.hasText(lastLoanNumber)) {
            return "1";
        } else {


            return "";
        }
    }
}

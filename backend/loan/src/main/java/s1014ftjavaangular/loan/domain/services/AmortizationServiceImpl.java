package s1014ftjavaangular.loan.domain.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import s1014ftjavaangular.loan.domain.model.entities.AmortizationSchedule;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.AmortizationStatus;
import s1014ftjavaangular.loan.domain.model.enums.AmortizationType;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class AmortizationServiceImpl implements AmortizationService {
    private CalculateStrategy strategy;

    @Override
    public Double calculateCapital(Double capital, Double interest, Integer numberInstallments, LocalDate currentDate) {
        return strategy.calculateCapital(capital, interest, numberInstallments, currentDate);
    }

    @Override
    public Double calculateInterest(Double capital, Double interest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment){
        return strategy.calculateInterest(capital, interest, numberInstallments,currentDate, frequencyPayment);
    }

    @Override
    public void setStrategy(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<AmortizationSchedule> generate(Loan model) {
        //AmortizationType.OUTSTANDING_INTEREST

        //Capital del prestamo
        Double capital = model.getAmountApproved();

        //Porcentaje anual del prestamo
        Double interestAnnual = model.getInterestRateLoan().getAnnualPercentage();

        //Numero de cuotas
        Integer numbersInstallments = model.getNumberInstallments();

        List<AmortizationSchedule> amortizationSchedules = new LinkedList<>();

        for(int i = 1; i<= numbersInstallments; i++) {

            var currentPaymentDate = i == 1
                    ? model.getStartAt()
                    : calculateNextLoanDate(
                    amortizationSchedules.get(i - 2).getPaymentDate(),
                    model.getStartAt(),
                    model.getFrequencyPayment().getValue(),
                    model.getFrequencyPayment()
            );

            var capitalInstallment = calculateCapital(
                    capital,
                    interestAnnual,
                    numbersInstallments,
                    currentPaymentDate
            );
//

            var amortizationSchedule = AmortizationSchedule.builder()
                    .loanId(model.getLoanId())
                    .amortizationScheduleId(UUID.randomUUID().toString())
                    .paymentDate(currentPaymentDate)
                    .capitalInstallment(capitalInstallment)
                    .interest(calculateInterest(capital, interestAnnual, numbersInstallments,currentPaymentDate, model.getFrequencyPayment()))
                    .capitalBalance(i == 1
                            ? model.getAmountApproved()-capitalInstallment
                            : calculateCapitalBalance(amortizationSchedules.get(i - 2).getCapitalBalance(), capitalInstallment))
                    .totalPaid(0.00)
                    .status(AmortizationStatus.CURRENT)
                    .build();

            amortizationSchedules.add(amortizationSchedule);
        }

        return amortizationSchedules;
    }

}

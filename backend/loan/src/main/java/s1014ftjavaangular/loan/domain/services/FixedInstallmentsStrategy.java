package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.entities.AmortizationSchedule;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.AmortizationStatus;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.*;

public class FixedInstallmentsStrategy extends AmortizationStrategy{


    private Double calculateCapital(Double capital, Integer numberInstallments) {
        return capital / numberInstallments;
    }

    private Double calculateInterest(Double capital, Double annualInterest, Integer numberInstallments) {
        Double porcentage = (annualInterest/HUNDRED_PERCENT);
        Double interestInstallmentAnnual = capital * porcentage;
        Double interestInstallmentMonthly = interestInstallmentAnnual/NUMBER_OF_MONTHS;
        return interestInstallmentMonthly;
    }

    @Override
    public List<AmortizationSchedule> generateTable(Loan model) {
        List<AmortizationSchedule> amortizationSchedules = new LinkedList<>();
        //Numero de cuotas
        Integer numbersInstallments = model.getNumberInstallments();
        for(int i = 1; i<= numbersInstallments; i++) {

            var currentPaymentDate = (i == 1)
                    ? model.getStartAt()
                    : calculateNextLoanDate(
                        amortizationSchedules.get(i - 2).getPaymentDate(),
                        model.getStartAt(),
                        model.getFrequencyPayment().getValue(),
                        model.getFrequencyPayment()
                    );
            var capitalInstallment = calculateCapital(
                    model.getAmountApproved(),
                    numbersInstallments
            );

            var capitalBalance = (i == 1)
                    ? model.getAmountApproved() - capitalInstallment
                    : amortizationSchedules.get(i - 2).getCapitalBalance() - capitalInstallment;

            var interestInstallment = calculateInterest(
                    model.getAmountApproved(),
                    model.getInterestRateLoan().getAnnualPercentage(),
                    model.getNumberInstallments()
            );

            var amortizationSchedule = AmortizationSchedule.builder()
                    .loanId(model.getLoanId())
                    .amortizationScheduleId(UUID.randomUUID().toString())
                    .paymentDate(currentPaymentDate)
                    .capitalInstallment(capitalInstallment)
                    .interest(formatDecimal(interestInstallment))
                    .capitalBalance(capitalBalance)
                    .totalPaid(0.00)
                    .status(AmortizationStatus.CURRENT)
                    .build();

            amortizationSchedules.add(amortizationSchedule);
        }

        return amortizationSchedules;

    }
}

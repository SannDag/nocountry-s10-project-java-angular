package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.entities.AmortizationSchedule;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.AmortizationStatus;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.NUMBER_OF_MONTHS;
import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.calculateNextLoanDate;

public class OutstandingInterestStrategy extends AmortizationStrategy{

    public Double calculateCapital(Double capital, Double annualInterest, LocalDate currentDate, Integer numberInstallments, FrequencyPayment frequencyPayment) {

        if (FrequencyPayment.MONTHLY.getValue() == frequencyPayment.getValue()) {
            BigDecimal annualInterestRate = BigDecimal.valueOf(annualInterest);
            BigDecimal numerator = annualInterestRate.multiply(BigDecimal.valueOf(numberInstallments / NUMBER_OF_MONTHS)).add(BigDecimal.ONE);
            BigDecimal denominator = BigDecimal.valueOf(Math.pow(numerator.doubleValue(), numberInstallments));
            BigDecimal result = BigDecimal.valueOf(capital).multiply(numerator.divide(denominator, 10, RoundingMode.HALF_UP));
            return result.doubleValue();
        }
        return null;

    }


    public Double calculateInterest(Double capital, Double annualInterest, Integer numberInstallments, FrequencyPayment frequencyPayment) {
        BigDecimal capitalInstallment = BigDecimal.valueOf(calculateCapital(capital, annualInterest, null, numberInstallments, null));
        BigDecimal interest = capitalInstallment.subtract(BigDecimal.valueOf(capital));
        return interest.doubleValue();
    }

    @Override
    public List<AmortizationSchedule> generateTable(Loan model) {
        //Numero de cuotas
        Integer numbersInstallments = model.getNumberInstallments();

        List<AmortizationSchedule> amortizationSchedules = new LinkedList<>();

        for (int i = 1; i <= numbersInstallments; i++) {

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
                    model.getInterestRateLoan().getAnnualPercentage(),
                    model.getStartAt(),
                    numbersInstallments,
                    model.getFrequencyPayment()
            );

            var capitalBalance = formatDecimal(
                    (i == 1)
                            ? model.getAmountApproved() - capitalInstallment
                            : amortizationSchedules.get(i - 2).getCapitalBalance() - capitalInstallment
            );

            if (i == numbersInstallments && capitalBalance != 0) {
                capitalInstallment += capitalBalance;
                capitalBalance = 0.00;
            }

            var interestInstallment = calculateInterest(
                    (i == 1) ? model.getAmountApproved() : amortizationSchedules.get(i - 2).getCapitalBalance(),
                    model.getInterestRateLoan().getAnnualPercentage(),
                    numbersInstallments,
                    model.getFrequencyPayment()
            );

            var amortizationSchedule = AmortizationSchedule.builder()
                    .loanId(model.getLoanId())
                    .amortizationScheduleId(UUID.randomUUID().toString())
                    .paymentDate(currentPaymentDate)
                    .capitalInstallment(formatDecimal(capitalInstallment))
                    .interest(formatDecimal(interestInstallment))
                    .capitalBalance(formatDecimal(capitalBalance))
                    .totalPaid(0.00)
                    .status(AmortizationStatus.CURRENT)
                    .build();

            amortizationSchedules.add(amortizationSchedule);
        }

        return amortizationSchedules;
    }
}

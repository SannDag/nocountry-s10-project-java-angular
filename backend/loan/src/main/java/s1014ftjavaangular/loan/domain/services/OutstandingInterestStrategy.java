package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;

public class OutstandingInterestStrategy implements CalculateStrategy{
    @Override
    public Double calculateCapital(Double capital, Double interest, Integer numberInstallments, LocalDate currentDate) {
        return 1.00;
    }

    @Override
    public Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments) {
        return calculateCapital(capital, annualInterest, numberInstallments, null);
    }

    @Override
    public Double calculateInterest(Double capital, Double interest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment) {
        return 1.00;
    }
}

package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;

import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.*;

public class FixedInstallmentsStrategy implements CalculateStrategy{

    @Override
    public Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments, LocalDate currentDate) {
        return capital / numberInstallments;
    }
    @Override
    public Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments) {
        return calculateCapital(capital, annualInterest, numberInstallments, null);
    }

    @Override
    public Double calculateInterest(Double capital, Double annualInterest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment) {
        Double interestInstallment = capital * ((annualInterest/ NUMBER_OF_MONTHS)/HUNDRED_PERCENT)/numberInstallments;
        return interestInstallment;
    }
}

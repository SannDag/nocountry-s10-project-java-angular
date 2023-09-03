package s1014ftjavaangular.loan.domain.services;

import org.springframework.cglib.core.Local;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Year;

import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.*;

public class SimpleInterestStrategy implements CalculateStrategy{
    @Override
    public Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments, LocalDate currentDate) {

        var daysOfYears = daysInYear(currentDate);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);
        Double percentageMonthly = Double.valueOf(df.format((annualInterest/daysOfYears) * getNumberDaysInThisMonth(currentDate)));

        Double interestPayment = capital * percentageMonthly/HUNDRED_PERCENT;
        Double interestMonthly = Double.valueOf(df.format(interestPayment/numberInstallments));
        var ds = capital / numberInstallments + (capital * interestMonthly / HUNDRED_PERCENT);
        Double amountInstallment =  capital + interestPayment / numberInstallments;

        Double capitalPayment = (capital/numberInstallments) - interestMonthly;
        //
        return Double.valueOf(df.format(capitalPayment));
    }

    @Override
    public Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments) {
        return calculateCapital(capital, annualInterest, numberInstallments, null);
    }

    @Override
    public Double calculateInterest(Double capital, Double annualInterest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment) {
        var daysOfYears = daysInYear(currentDate);

        Double percentageMonthly = (annualInterest/daysOfYears) * getNumberDaysInThisMonth(currentDate);
        Double interestPayment = capital * percentageMonthly/HUNDRED_PERCENT;
        return interestPayment/numberInstallments;
    }
}

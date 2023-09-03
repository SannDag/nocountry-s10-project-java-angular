package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;

import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.DAYS_OF_YEAR;
import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.DAYS_OF_YEAR_IN_LEAP;

public interface CalculateStrategy {

    Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments, LocalDate currentDate);
    Double calculateCapital(Double capital, Double annualInterest, Integer numberInstallments);

    Double calculateInterest(Double capital, Double annualInterest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment);

    default Integer daysInYear(LocalDate date) {
        return isLeapYears(date) ? DAYS_OF_YEAR_IN_LEAP : DAYS_OF_YEAR;
    }

    default Boolean isLeapYears(LocalDate date){
        return date.isLeapYear();
    }

    default Integer getNumberDaysInThisMonth(LocalDate currentDate){
        return currentDate.getMonth().length(isLeapYears(currentDate));
    }
}

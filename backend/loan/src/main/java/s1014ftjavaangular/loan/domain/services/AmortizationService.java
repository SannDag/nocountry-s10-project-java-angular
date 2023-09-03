package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.entities.AmortizationSchedule;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;
import static s1014ftjavaangular.loan.domain.util.UtilitiesCalculations.*;
import java.util.List;


public interface AmortizationService {

    Double calculateCapital(Double capital, Double interest, Integer numberInstallments, LocalDate currentDate);
    Double calculateInterest(Double capital, Double interest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment);
    void setStrategy(CalculateStrategy strategy);

    List<AmortizationSchedule> generate(Loan model);

    default LocalDate calculateNextLoanDate(LocalDate currentDate, LocalDate startDate, Integer timeAdd, FrequencyPayment frequencyPayment){
        var monthNumber = currentDate.getMonth().getValue();
        if(frequencyPayment == FrequencyPayment.MONTHLY){
            if(isFebruaryTheMonth(monthNumber+1) && dateOlderThanTwentyEight(startDate)){
                return currentDate.isLeapYear()
                        ? LocalDate.of(currentDate.getYear(), 2, 29)
                        : LocalDate.of(currentDate.getYear(), 2, 28);
            }

            if(isFebruaryTheMonth(monthNumber)){
                return LocalDate.of(currentDate.getYear(), 3, startDate.getDayOfMonth());
            }

            if(isTheNextMonthHas31Days(monthNumber) && startDate.getDayOfMonth() == 31){
                var next = currentDate.plusMonths(1);
                return LocalDate.of(next.getYear(), next.getMonth(), 31);
            }

            return currentDate.plusMonths(timeAdd);
        }

        return currentDate.plusDays(timeAdd);
    }

    default Double calculateCapitalBalance(Double capitalBalance, Double capital){
        return capitalBalance - capital;
    }
}

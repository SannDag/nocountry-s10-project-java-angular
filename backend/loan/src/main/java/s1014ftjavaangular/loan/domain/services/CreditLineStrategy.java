package s1014ftjavaangular.loan.domain.services;

import s1014ftjavaangular.loan.domain.model.entities.AmortizationSchedule;
import s1014ftjavaangular.loan.domain.model.entities.Loan;
import s1014ftjavaangular.loan.domain.model.enums.FrequencyPayment;

import java.time.LocalDate;
import java.util.List;

public class CreditLineStrategy extends AmortizationStrategy{

    public Double calculateCapital(Double capital, Double interest, Integer numberInstallments, LocalDate currentDate) {
        return 1.00;
    }

    public Double calculateInterest(Double capital, Double interest, Integer numberInstallments,LocalDate currentDate, FrequencyPayment frequencyPayment) {
        return 1.00;
    }

    @Override
    public List<AmortizationSchedule> generateTable(Loan model) {

        return  null;
    }
}

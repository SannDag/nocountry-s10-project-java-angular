package s1014ftjavaangular.loan.domain.util;

import java.time.LocalDate;

public class UtilitiesCalculations {

    public static final Integer NUMBER_OF_MONTHS = 12;
    public static final  Integer HUNDRED_PERCENT = 100;
    public static final Integer DAYS_OF_YEAR = 365;
    public static final Integer DAYS_OF_YEAR_IN_LEAP = 366;


    public static Boolean isFebruaryTheMonth(Integer monthNumber){
        return (monthNumber == 2);
    }

    public static Boolean dateOlderThanTwentyEight(LocalDate startDate){
        return (startDate.getDayOfMonth() == 29 || startDate.getDayOfMonth() == 30 || startDate.getDayOfMonth() == 31);
    }

    public static Boolean isTheNextMonthHas31Days(Integer monthNumber){
        return (monthNumber == 12) ||
                (monthNumber == 2) ||
                (monthNumber == 4) ||
                (monthNumber == 6) ||
                (monthNumber == 7) ||
                (monthNumber == 9) ||
                (monthNumber == 11);
    }

    public static Boolean isAMonthOfThirtyOneDays(Integer daysOfMonthsNumber){
        return daysOfMonthsNumber == 31;
    }
}

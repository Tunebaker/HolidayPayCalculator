package com.example.calculator.service;

import com.example.calculator.data.HolidayDatesReader;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Calculator {
    private static final BigDecimal AVERAGE_MONTHLY_NUMBER_OF_DAYS = BigDecimal.valueOf(29.3);
    private static final int BIG_DECIMAL_SCALE = 3;
    private final HolidayDatesReader holidayDatesReader;

    public Calculator(HolidayDatesReader holidayDatesReader) {
        this.holidayDatesReader = holidayDatesReader;
    }

    public BigDecimal calculateByDuration(BigDecimal avgMountlySalary, int duration) {
        return avgMountlySalary.multiply(BigDecimal.valueOf(duration)).divide(AVERAGE_MONTHLY_NUMBER_OF_DAYS, BIG_DECIMAL_SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateByVacationDates(BigDecimal avgMontlySalary, LocalDate vacationStart, LocalDate vacationEnd) {
        List<LocalDate> vacationDates = vacationStart.datesUntil(vacationEnd.plusDays(1))
                .collect(Collectors.toList());
        int paidDays = vacationDates.size() - getNonWorkingDaysNumber(vacationDates);

        return calculateByDuration(avgMontlySalary, paidDays);
    }

    private int getNonWorkingDaysNumber(List<LocalDate> vacationDates) {

        int nonWorkingDaysNumber = 0;
        Set<LocalDate> allHolidaysDates = holidayDatesReader.getHolidays();

        for (LocalDate vacationDay : vacationDates) {
            if (allHolidaysDates.contains(vacationDay)) {
                nonWorkingDaysNumber++;
            }
        }
        return nonWorkingDaysNumber;
    }
}

package com.example.calculator.service;

import com.example.calculator.data.HolidayDatesReader;
import com.example.calculator.data.HolidaysDatesXmlReader;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Calculator {
    private static final double AVERAGE_MONTHLY_NUMBER_OF_DAYS = 29.3;

    public static double calculateByDuration(double avgMountlySalary, int duration) {
        return avgMountlySalary / AVERAGE_MONTHLY_NUMBER_OF_DAYS * duration;
    }

    public static double calculateByVacationDates(double avgMontlySalary, LocalDate vacationStart, LocalDate vacationEnd) {
        List<LocalDate> vacationDates = vacationStart.datesUntil(vacationEnd.plusDays(1))
                .collect(Collectors.toList());
        int paidDays = vacationDates.size() - getNonWorkingDaysNumber(vacationDates);

        return calculateByDuration(avgMontlySalary, paidDays);
    }

    private static int getNonWorkingDaysNumber(List<LocalDate> vacationDates) {

        int nonWorkingDaysNumber = 0;
        HolidayDatesReader holidayDatesReader = new HolidaysDatesXmlReader();
        Set<LocalDate> allHolidaysDates = holidayDatesReader.getHolidays();

        for (LocalDate vacationDay : vacationDates) {
            if (allHolidaysDates.contains(vacationDay)) {
                nonWorkingDaysNumber++;
            }
        }
        return nonWorkingDaysNumber;
    }
}

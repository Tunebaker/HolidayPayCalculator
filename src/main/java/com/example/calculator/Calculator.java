package com.example.calculator;

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

    public static double calculateByVacationDates(double avgMountlySalary, LocalDate vacationStart, LocalDate vacationEnd) {
        List<LocalDate> vacationDates = vacationStart.datesUntil(vacationEnd.plusDays(1))
                .collect(Collectors.toList());
        int paidDays = vacationDates.size() - getNonWorkingDaysNumber(vacationDates);

        return calculateByDuration(avgMountlySalary, paidDays);
    }

    private static int getNonWorkingDaysNumber(List<LocalDate> vacationDates) {

        Set<LocalDate> nonWorkingDates = Set.of(); // TODO add non-working day source
        int nonWorkingDaysNumber = 0;

        for (LocalDate date : vacationDates) {
            if (nonWorkingDates.contains(date)) {
                nonWorkingDaysNumber++;
            }
        }
        return nonWorkingDaysNumber;
    }
}

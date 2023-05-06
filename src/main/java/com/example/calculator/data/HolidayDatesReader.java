package com.example.calculator.data;

import java.time.LocalDate;
import java.util.Set;

public interface HolidayDatesReader {
    Set<LocalDate> getHolidays();
}

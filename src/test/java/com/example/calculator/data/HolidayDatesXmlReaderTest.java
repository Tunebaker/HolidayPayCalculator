package com.example.calculator.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HolidayDatesXmlReaderTest {

    @Test
    void getHolidays() {
        HolidayDatesReader holidayDatesReader = new HolidayDatesXmlReader();
        Set<LocalDate> holidays = holidayDatesReader.getHolidays();

        Assertions.assertNotNull(holidays);
        Assertions.assertEquals(20, holidays.size(), "Set size is wrong");
        Assertions.assertTrue(holidays.contains(LocalDate.of(2023, 5, 9)));

    }
}
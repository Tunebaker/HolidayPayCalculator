package com.example.calculator.service;

import com.example.calculator.data.HolidayDatesXmlReader;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Calculator calculator = new Calculator(new HolidayDatesXmlReader());

    @Test
    void calculateByDuration() {
        BigDecimal calculated = calculator.calculateByDuration(BigDecimal.valueOf(29.3), 1000);
        BigDecimal expected = BigDecimal.valueOf(1000);
        assertEquals(0, expected.compareTo(calculated));

        calculated = calculator.calculateByDuration(BigDecimal.valueOf(0), 1);
        expected = BigDecimal.valueOf(0);
        assertEquals(0, expected.compareTo(calculated));

        calculated = calculator.calculateByDuration(BigDecimal.valueOf(1_000_000), 10_000_000);
        expected = BigDecimal.valueOf(341296928327.645);
        assertEquals(0, expected.compareTo(calculated));
    }

   /*
    @Test
    void calculateByVacationDates() {

    }*/
}
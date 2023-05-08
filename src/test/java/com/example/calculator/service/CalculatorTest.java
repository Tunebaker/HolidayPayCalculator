package com.example.calculator.service;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    @Test
    void calculateByDuration() {
        BigDecimal calculated = Calculator.calculateByDuration(BigDecimal.valueOf(29.3), 1000);
        BigDecimal expected = BigDecimal.valueOf(1000);
        assertEquals(0, expected.compareTo(calculated));

        calculated = Calculator.calculateByDuration(BigDecimal.valueOf(0), 1);
        expected = BigDecimal.valueOf(0);
        assertEquals(0, expected.compareTo(calculated));

        calculated = Calculator.calculateByDuration(BigDecimal.valueOf(1_000_000), 10_000_000);
        expected = BigDecimal.valueOf(341296928327.645);
        assertEquals(0, expected.compareTo(calculated));
    }


    @Test
    void calculateByVacationDates() {

    }
}
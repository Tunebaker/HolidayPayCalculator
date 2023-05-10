package com.example.calculator.controller;

import com.example.calculator.service.Calculator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculate")
@Validated
public class CalculatorController {

    Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping(params = {"salary", "vacationDuration"})
    public BigDecimal calculatePay(@RequestParam(value = "salary") @PositiveOrZero BigDecimal avgMonthlySalary,
                                   @RequestParam(value = "vacationDuration") @Min(1) int vacationDuration) {
        return calculator.calculateByDuration(avgMonthlySalary, vacationDuration);
    }

    @GetMapping(params = {"salary", "vacationStart", "vacationEnd"})
    public BigDecimal calculatePay(@RequestParam(value = "salary") @PositiveOrZero BigDecimal avgMonthlySalary,
                                   @RequestParam(value = "vacationStart") @Valid LocalDate vacationStartDate,
                                   @RequestParam(value = "vacationEnd") @Valid LocalDate vacationEndDate) {

        return calculator.calculateByVacationDates(avgMonthlySalary, vacationStartDate, vacationEndDate);
    }

}

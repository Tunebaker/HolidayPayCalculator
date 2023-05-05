package com.example.calculator.controller;

import com.example.calculator.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculate")
public class CalculatorController {
    @GetMapping(params = {"salary", "duration"} )
    public double calculatePay(@RequestParam(value = "salary") @Min(0) double avgMountlySalary,
                               @RequestParam(value = "vacationDuration") @Min(1) int vacationDuration) {
        return Calculator.calculateByDuration(avgMountlySalary, vacationDuration);
    }

    @GetMapping(params = {"salary", "vacationStart", "vacationEnd"} )
    public double calculatePay(@RequestParam(value = "salary") @Min(0) double avgMountlySalary,
                               @RequestParam(value = "vacationStart")  @Valid LocalDate vacationStartDate,
                               @RequestParam(value = "vacationEnd")  @Valid LocalDate vacationEndDate) {

        return Calculator.calculateByVacationDates(avgMountlySalary, vacationStartDate, vacationEndDate);
    }

}

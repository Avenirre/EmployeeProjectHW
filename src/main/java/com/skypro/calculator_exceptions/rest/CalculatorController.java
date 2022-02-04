package com.skypro.calculator_exceptions.rest;

import com.skypro.calculator_exceptions.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/greeting")
    public String greet() {
        return "Welcome to our project";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer num1,
                       @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "Please add the both parameters";
        }
        return num1 + "+" + num2 + "=" + calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "Please add the both parameters";
        }
        return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer num1,
                         @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "Please add the both parameters";
        }
        return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1,
                           @RequestParam(name = "num2", required = false) Integer num2){
        if (num1 == null || num2 == null){
            return "Please add the both parameters";
        }
        return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
    }
}

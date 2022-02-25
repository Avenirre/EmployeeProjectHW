package com.skypro.calculator_exceptions.services.impl;

import com.skypro.calculator_exceptions.services.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public String divide(int num1, int num2) {
        String result;
        try {
            if (num2 == 0) {
                throw new ArithmeticException();
            }
          result = String.valueOf((double)num1 / num2);
        } catch (Exception e) {
            result = "don't divide by zero!";
        }
        return result;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}

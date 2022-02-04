package com.skypro.calculator_exceptions.services;

import com.skypro.calculator_exceptions.model.Employee;

import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}

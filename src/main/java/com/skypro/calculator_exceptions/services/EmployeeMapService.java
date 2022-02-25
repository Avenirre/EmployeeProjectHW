package com.skypro.calculator_exceptions.services;

import com.skypro.calculator_exceptions.model.Employee;

import java.util.Collection;
import java.util.Set;

public interface EmployeeMapService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}

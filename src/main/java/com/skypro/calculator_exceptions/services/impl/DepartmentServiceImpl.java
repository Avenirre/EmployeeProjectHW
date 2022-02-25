package com.skypro.calculator_exceptions.services.impl;

import com.skypro.calculator_exceptions.exceptions.EmployeeNotFoundException;
import com.skypro.calculator_exceptions.model.Employee;
import com.skypro.calculator_exceptions.services.DepartmentService;
import com.skypro.calculator_exceptions.services.EmployeeMapService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeMapService employeeService;

    public DepartmentServiceImpl(EmployeeMapService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has been already added"));
                //.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has been already added"));
                //.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId).
                collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId() {
        Map<Integer, List<Employee>> result = new HashMap<>();
        employeeService.getAllEmployees().stream().
                forEach(e -> {
                    List<Employee> departmentEmployees = result.getOrDefault(e.getDepartmentId(), new ArrayList<>());
                    departmentEmployees.add(e);
                    result.put(e.getDepartmentId(), departmentEmployees);
                });
        return result;
        //return employeeService.getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}

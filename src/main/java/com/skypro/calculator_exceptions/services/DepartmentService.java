package com.skypro.calculator_exceptions.services;

import com.skypro.calculator_exceptions.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId);

    Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId);

    Collection<Employee> findEmployeesByDepartmentId(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeesByDepartmentId();
}

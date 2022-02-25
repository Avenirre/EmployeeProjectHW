package com.skypro.calculator_exceptions.rest;

import com.skypro.calculator_exceptions.model.Employee;
import com.skypro.calculator_exceptions.services.DepartmentService;
import com.skypro.calculator_exceptions.services.impl.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMaxSalaryByDepartmentId(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMinSalaryByDepartmentId(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> findEmployeesByDepartmentId(@RequestParam int departmentId){
        return departmentService.findEmployeesByDepartmentId(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId(){
        return departmentService.findAllEmployeesByDepartmentId();
    }
}

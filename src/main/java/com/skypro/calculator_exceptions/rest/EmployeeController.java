package com.skypro.calculator_exceptions.rest;

import com.skypro.calculator_exceptions.model.Employee;
import com.skypro.calculator_exceptions.services.EmployeeCollectionsService;
import com.skypro.calculator_exceptions.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeCollectionsService employeeService;

    public EmployeeController(EmployeeCollectionsService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String greetEmployee(){
        return "Hello employees!";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){
        Employee addedEmployee = employeeService.addEmployee(firstName, lastName);
        return addedEmployee;
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){
        Employee removedEmployee = employeeService.removeEmployee(firstName, lastName);
        return removedEmployee;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){
        Employee foundEmployee = employeeService.findEmployee(firstName, lastName);
        return foundEmployee;
    }

    @GetMapping("/getAllEmployees")
    public Set<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}

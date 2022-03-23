package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.service.EmployeeGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee/{id}")
public class EmployeeGetController {

    @Autowired
    EmployeeGetService employeeGetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return employeeGetService.getEmployee(id);
    }

}

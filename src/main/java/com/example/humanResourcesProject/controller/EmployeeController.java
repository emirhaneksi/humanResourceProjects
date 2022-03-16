package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee/{id}")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok().body(employeeService.getEmployee(id));

    }
}

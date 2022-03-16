package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.service.EmployeeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/employee/create")
public class EmployeeCreateController {
    @Autowired
    EmployeeCreateService employeeCreateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeCreateService.createNewEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdEmployee);
    }
}

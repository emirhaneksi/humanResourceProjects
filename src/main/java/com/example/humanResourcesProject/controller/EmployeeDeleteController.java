package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.service.EmployeeDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/delete/{id}")
public class EmployeeDeleteController {
    @Autowired
    EmployeeDeleteService employeeDeleteService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable  int id){
        employeeDeleteService.deleteEmployee(id);
    }
}

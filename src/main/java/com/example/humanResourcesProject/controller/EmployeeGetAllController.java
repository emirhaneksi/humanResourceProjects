package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.service.EmployeeGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/api/v1/employee/getall/")
public class EmployeeGetAllController {

    @Autowired
    EmployeeGetAllService employeeGetAllService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> listAllEmployees(){
        return ResponseEntity.ok().body(employeeGetAllService.listAllEmployees());
    }
}

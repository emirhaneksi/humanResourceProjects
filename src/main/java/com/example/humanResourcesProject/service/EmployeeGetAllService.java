package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeGetAllService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

}

package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreateService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}


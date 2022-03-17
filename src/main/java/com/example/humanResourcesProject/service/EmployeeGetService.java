package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.exception.EmployeeNotFoundException;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeGetService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(int id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException(id);
        } else {
            return employeeRepository.findById(id);
        }

    }
}

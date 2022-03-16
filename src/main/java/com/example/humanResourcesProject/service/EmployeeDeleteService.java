package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDeleteService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}

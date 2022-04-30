package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.exception.EmployeeNotFoundException;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(int id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return employeeRepository.findById(id);
    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employeeRepository.deleteById(id);
    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}

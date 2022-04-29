package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.exception.EmployeeNotFoundException;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployee(int id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException(id);
        } else {
            return employeeRepository.findById(id);
        }

    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException(id);
        } else {
            employeeRepository.deleteById(id);
        }

    }

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}

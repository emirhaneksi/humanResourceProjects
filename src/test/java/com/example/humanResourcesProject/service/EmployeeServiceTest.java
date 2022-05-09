package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach void setUp() {
        this.employeeService = new EmployeeService(this.employeeRepository);
    }

    @Test
    void getEmployeeById() {
        final int id = 5;
        final Employee employee = new Employee(id,"Emirhan","Eksi","Software", LocalDate.now());
        given(employeeRepository.findById(id)).willReturn(Optional.of(employee));
        final Optional<Employee> expected = employeeService.getEmployeeById(id);
        assertThat(expected).isNotNull();
    }

    @Test
    void listAllEmployees() {
        employeeService.listAllEmployees();
        verify(employeeRepository,times(1)).findAll();
    }

    @Test
    void deleteEmployee() {

        Employee employee = new Employee(32,"Emirhan","Eksi","Software", LocalDate.now());
        given(employeeRepository.findById(32)).willReturn(Optional.of(employee));
        employeeService.deleteEmployee(employee.getId());

        verify(employeeRepository).deleteById(32);
    }


    @Test
    void createNewEmployee() {
        Employee employee = new Employee(32,"Emirhan","Eksi","Software", LocalDate.now());
        employeeService.createNewEmployee(employee);
        verify(employeeRepository).save(employee);

    }
}
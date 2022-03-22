package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.exception.EmployeeNotFoundException;
import com.example.humanResourcesProject.exception.PermissionAlreadyExistsException;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import com.example.humanResourcesProject.service.PermissionCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/permission/create/{id}")
public class PermissionCreateController {
    @Autowired
    PermissionCreateService permissionCreateService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeGetAllController employeeGetAllController;

    public int calculateYearDifferenceForPermission(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        LocalDate today = LocalDate.now();
        Period differenceYear = Period.between(employee.get().getStartDate(), today);
        return differenceYear.getYears();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Permission createPermission(Permission permission, @PathVariable int id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        List<Integer> employeeIdList = new ArrayList<Integer>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/humanresources" , "root" , "root53");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeid FROM permissions");
            System.out.println("Connection successful");
            while(resultSet.next()) {
                employeeIdList.add(Integer.valueOf(resultSet.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < employeeIdList.size() ; i++) {
            if(employeeIdList.get(i) == id) {
                throw new PermissionAlreadyExistsException();
            }
        }

        try {

            if (calculateYearDifferenceForPermission(id) < 3) {
                permission.setEmployeeId(id);
                permission.setTotalDay(10);
                permission.setStartDate(LocalDate.now());
                permission.setFinishDate(LocalDate.now().plusDays(10));
            } else if (calculateYearDifferenceForPermission(id) >= 3 && calculateYearDifferenceForPermission(id) < 5) {
                permission.setEmployeeId(id);
                permission.setTotalDay(15);
                permission.setStartDate(LocalDate.now());
                permission.setFinishDate(LocalDate.now().plusDays(15));
            } else {
                permission.setEmployeeId(id);
                permission.setTotalDay(20);
                permission.setStartDate(LocalDate.now());
                permission.setFinishDate(LocalDate.now().plusDays(20));
            }

        } catch(Exception exception) {

            if (!employee.isPresent()) {
                throw new EmployeeNotFoundException(id);
            }
        }

        return permissionCreateService.createNewPermission(permission);
    }

}

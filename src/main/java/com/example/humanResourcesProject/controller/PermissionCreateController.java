package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Employee;
import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.repository.EmployeeRepository;
import com.example.humanResourcesProject.service.PermissionCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/permission/create/{id}")
public class PermissionCreateController {
    @Autowired
    PermissionCreateService permissionCreateService;
    @Autowired
    EmployeeRepository employeeRepository;

    public int calculateYearDifferenceForPermission(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        LocalDate today = LocalDate.now();
        Period differenceYear = Period.between(employee.get().getStartDate(), today);
        return differenceYear.getYears();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Permission createPermission(Permission permission, @PathVariable int id) {

        if (calculateYearDifferenceForPermission(id) < 3) {
            permission.setEmployeeId(id);
            permission.setTotalDay(10);
            permission.setStartDate(LocalDate.now());
            permission.setFinishDate(LocalDate.now().plusDays(10));

        } else if (calculateYearDifferenceForPermission(id) > 3 && calculateYearDifferenceForPermission(id) < 5) {
            permission.setEmployeeId(id);
            permission.setTotalDay(15);
            permission.setStartDate(LocalDate.now());
            permission.setFinishDate(LocalDate.now().plusDays(15));

        } else  {
            permission.setEmployeeId(id);
            permission.setTotalDay(20);
            permission.setStartDate(LocalDate.now());
            permission.setFinishDate(LocalDate.now().plusDays(20));
        }

        return permissionCreateService.createNewPermission(permission);
    }

}

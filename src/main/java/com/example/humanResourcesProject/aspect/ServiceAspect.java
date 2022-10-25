package com.example.humanResourcesProject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.example.humanResourcesProject.service.EmployeeService.listAllEmployees())")
    public void beforeListAllEmployees(JoinPoint joinPoint) {
        System.out.println("Before method");

    }

    @After("execution(* com.example.humanResourcesProject.service.EmployeeService.listAllEmployees())")
    public void afterListAllEmployees(JoinPoint joinPoint) {
        System.out.println("After method");
    }
}

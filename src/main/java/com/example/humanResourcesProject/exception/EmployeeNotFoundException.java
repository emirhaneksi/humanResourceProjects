package com.example.humanResourcesProject.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id){
        super("ID nosu : " + id + " olan çalışan bulunamadı.");
    }
}

package com.example.humanResourcesProject.exception;

public class PermissionNotFoundException extends RuntimeException {
    public PermissionNotFoundException(int id) {
        super("ID numarası " + id + " olan izin bulunamadı");
    }
}

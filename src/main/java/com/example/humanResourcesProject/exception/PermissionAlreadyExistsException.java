package com.example.humanResourcesProject.exception;

public class PermissionAlreadyExistsException extends RuntimeException {

    public PermissionAlreadyExistsException() {
        super("Bu kullanıcının zaten izni var.");
    }

}

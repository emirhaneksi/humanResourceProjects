package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.service.PermissionDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/permission/delete/{id}")
public class PermissionDeleteController {
    @Autowired
    PermissionDeleteService permissionDeleteService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePermission(@PathVariable int id) {
        permissionDeleteService.deletePermission(id);
    }
}

package com.example.humanResourcesProject.controller;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.service.PermissionCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/permission/create")
public class PermissionCreateController {
    @Autowired
    PermissionCreateService permissionCreateService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Permission createPermission(Permission permission){
        return permissionCreateService.createNewPermission(permission);
    }

}

package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionCreateService {

    @Autowired
    PermissionRepository permissionRepository;

    public Permission createNewPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

}

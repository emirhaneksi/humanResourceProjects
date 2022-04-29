package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.exception.PermissionNotFoundException;
import com.example.humanResourcesProject.repository.PermissionRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission createNewPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermission(int id) {
        Optional<Permission> permission = permissionRepository.findById(id);

        if (!permission.isPresent()) {
            throw new PermissionNotFoundException(id);
        } else {
            permissionRepository.deleteById(id);
        }



    }
}

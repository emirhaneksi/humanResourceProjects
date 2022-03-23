package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.exception.PermissionNotFoundException;
import com.example.humanResourcesProject.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PermissionDeleteService {

    @Autowired
    PermissionRepository permissionRepository;

    public void deletePermission(int id) {
        Optional<Permission> permission = permissionRepository.findById(id);

        if (!permission.isPresent()) {
            throw new PermissionNotFoundException(id);
        } else {
            permissionRepository.deleteById(id);
        }

    }

}

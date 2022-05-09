package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.exception.PermissionNotFoundException;
import com.example.humanResourcesProject.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public Permission createNewPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermission(int id) {
        permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException(id));

        permissionRepository.deleteById(id);
    }
}

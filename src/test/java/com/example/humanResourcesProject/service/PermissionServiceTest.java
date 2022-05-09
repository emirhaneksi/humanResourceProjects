package com.example.humanResourcesProject.service;

import com.example.humanResourcesProject.entity.Permission;
import com.example.humanResourcesProject.repository.PermissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PermissionServiceTest {

    @Mock
    private PermissionRepository permissionRepository;
    @InjectMocks
    private PermissionService permissionService;

    @BeforeEach
    void setUp() {
        this.permissionService = new PermissionService(this.permissionRepository);
    }

    @Test
    void createNewPermission() {
        Permission permission = new Permission(1,5, LocalDate.now(),LocalDate.now().plusDays(10),10);
        permissionService.createNewPermission(permission);
        Mockito.verify(permissionRepository, Mockito.times(1)).save(permission);
    }

    @Test
    void deletePermission() {
        Permission permission = new Permission(1,5, LocalDate.now(),LocalDate.now().plusDays(10),10);
        given(permissionRepository.findById(1)).willReturn(Optional.of(permission));
        permissionService.deletePermission(1);
        Mockito.verify(permissionRepository,Mockito.times(1)).deleteById(1);
    }
}
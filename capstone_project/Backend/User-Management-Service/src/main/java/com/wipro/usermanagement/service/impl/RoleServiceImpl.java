package com.wipro.usermanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wipro.usermanagement.dto.RoleDTO;
import com.wipro.usermanagement.entity.Role;
import com.wipro.usermanagement.repository.RoleRepository;
import com.wipro.usermanagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = mapToEntity(roleDTO);
        Role savedRole = roleRepository.save(role);
        return mapToDTO(savedRole);
    }

    @Override
    public RoleDTO updateRole(Integer id, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        existingRole.setRname(roleDTO.getRname());

        Role updatedRole = roleRepository.save(existingRole);
        return mapToDTO(updatedRole);
    }

    @Override
    public void deleteRole(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        roleRepository.delete(role);
    }

    @Override
    public RoleDTO getRoleById(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return mapToDTO(role);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private RoleDTO mapToDTO(Role role) {
        return new RoleDTO(role.getRid(), role.getRname());
    }

    private Role mapToEntity(RoleDTO roleDTO) {
        return new Role(roleDTO.getRid(), roleDTO.getRname());
    }
}

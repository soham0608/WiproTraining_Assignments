package com.wipro.usermanagement.service;

import java.util.List;
import com.wipro.usermanagement.dto.RoleDTO;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(Integer id, RoleDTO roleDTO);

    void deleteRole(Integer id);

    RoleDTO getRoleById(Integer id);

    List<RoleDTO> getAllRoles();
}

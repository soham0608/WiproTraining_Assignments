package com.wipro.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.usermanagement.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}

package com.iqmsoft.gwt.spring.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.gwt.spring.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}



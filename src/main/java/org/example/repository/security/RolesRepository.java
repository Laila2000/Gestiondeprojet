package org.example.repository.security;

import org.example.Entity.security.ERole;
import org.example.Entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface  RolesRepository  extends JpaRepository<Role ,Long> {
    Optional<Role>findByIName(ERole name)
;}

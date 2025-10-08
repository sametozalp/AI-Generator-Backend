package com.ozalp.AI.Generator.Backend.dataAccess;

import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}

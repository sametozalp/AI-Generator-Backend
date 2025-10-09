package com.ozalp.AI.Generator.Backend.dataAccess;

import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String username);

    Optional<User> findByEmail(String email);
}

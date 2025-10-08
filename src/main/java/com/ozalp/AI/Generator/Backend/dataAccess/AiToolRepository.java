package com.ozalp.AI.Generator.Backend.dataAccess;

import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AiToolRepository extends JpaRepository<AiTool, UUID> {

    boolean existsByName(String name);

}

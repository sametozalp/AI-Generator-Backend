package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;

import java.util.UUID;

public interface BaseService<T extends BaseEntity> {

    Result delete(UUID id);

    T getById(UUID id);

}
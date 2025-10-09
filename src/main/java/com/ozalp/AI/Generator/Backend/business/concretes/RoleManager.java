package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.RoleService;
import com.ozalp.AI.Generator.Backend.business.mappers.RoleMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.dataAccess.RoleRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {

    private final RoleMapper mapper;
    private final RoleRepository repository;

//    @Transactional
//    @Override
//    public DataResult<RoleResponse> create(CreateRoleRequest request) {
//        Role reqRole = mapper.toEntity(request);
//        Role saved = save(reqRole);
//        return new SuccessDataResult<>(mapper.toResponse(saved));
//    }

    @Override
    public Result delete(UUID id) {
        return null;
    }

    @Override
    public Role getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Messages.ROLE_NOT_FOUND));
    }
//
//    @Override
//    public Role save(Role entity) {
//        return repository.save(entity);
//    }

    @Override
    public Role getByName(RoleType roleType) {
        return repository.findByName(roleType);
    }

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }
}

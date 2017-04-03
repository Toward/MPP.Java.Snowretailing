package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.contracts.services.IRoleService;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRoleRepository;

@Service
public class RoleService extends BaseService<IRoleModel, IRoleEntity> implements IRoleService {
    private final IRoleRepository roleRepository;
    private final IMapper<IRoleEntity, IRoleModel> mapper;

    @Autowired
    public RoleService(@Qualifier("roleRepository")  IRoleRepository roleRepository,
                       @Qualifier("roleModelToEntityMapper") IMapper<IRoleModel, IRoleEntity> roleModelToEntityMapper,
                       @Qualifier("roleEntityToModelMapper") IMapper<IRoleEntity, IRoleModel> roleEntityToModelMapper) {
        super(roleRepository, roleModelToEntityMapper, roleEntityToModelMapper);
        this.roleRepository = roleRepository;
        mapper = roleEntityToModelMapper;
    }

    @Override
    public IRoleModel getByRoleName(String roleName) {
        if(roleName == null || roleName.isEmpty())
            throw new IllegalArgumentException(roleName);

        return  mapper.Map(roleRepository.getByRoleName(roleName));
    }
}

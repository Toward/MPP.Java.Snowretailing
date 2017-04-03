package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.contracts.services.IUserService;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;

@Service
public class UserService extends BaseService<IUserModel, IUserEntity> implements IUserService {
    private final IUserRepository userRepository;
    private final IMapper<IUserEntity, IUserModel> mapper;

    @Autowired
    public UserService(@Qualifier("userRepository") IUserRepository userRepository,
                       @Qualifier("userModelToEntityMapper") IMapper<IUserModel, IUserEntity> userModelToEntityMapper,
                       @Qualifier("userEntityToModelMapper") IMapper<IUserEntity, IUserModel> userEntityToModelMapper) {
        super(userRepository, userModelToEntityMapper, userEntityToModelMapper);
        this.userRepository = userRepository;
        mapper = userEntityToModelMapper;
    }

    @Override
    public IUserModel getByLogin(String login) {
        if(login == null || login.isEmpty())
            throw new IllegalArgumentException("login is empty");

        return mapper.Map(userRepository.getByLogin(login));
    }
}

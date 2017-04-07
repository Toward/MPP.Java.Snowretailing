package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserWriteModel;
import shlackAndCo.snowretailing.core.contracts.services.IUserService;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IMapper<IUserEntity, IUserReadModel> userEntityToUserReadModelMapper;
    private final IMapper<IUserWriteModel, IUserEntity> userWriteModelToEntityMapper;

    @Autowired
    public UserService(@Qualifier("userRepository") IUserRepository userRepository,
                       @Qualifier("userWriteModelToEntityMapper") IMapper<IUserWriteModel, IUserEntity> userWriteModelToEntityMapper,
                       @Qualifier("userEntityToUserReadModelMapper") IMapper<IUserEntity, IUserReadModel> userEntityToUserReadModelMapper) {
        this.userRepository = userRepository;
        this.userEntityToUserReadModelMapper = userEntityToUserReadModelMapper;
        this.userWriteModelToEntityMapper = userWriteModelToEntityMapper;
    }

    @Override
    public Collection<IUserReadModel> getUsers() {
        Collection<IUserEntity> entities = userRepository.getAll();
        return entities.stream().map(userEntityToUserReadModelMapper::Map).collect(Collectors.toList());
    }

    @Override
    public IUserReadModel getById(int userId) {
        if (userId <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IUserEntity entity = userRepository.getById(userId);
        return entity == null ? null : userEntityToUserReadModelMapper.Map(entity);
    }

    @Override
    public IUserReadModel getByLogin(String login) {
        if(login == null || login.isEmpty())
            throw new IllegalArgumentException("login is empty");

        return userEntityToUserReadModelMapper.Map(userRepository.getByLogin(login));
    }

    @Override
    public int create(IUserWriteModel model) {
        if (model == null)
            throw new IllegalArgumentException("model is null");

        return userRepository.create(userWriteModelToEntityMapper.Map(model));
    }

    @Override
    public void edit(IUserWriteModel model) {
        if (model == null)
            throw new IllegalArgumentException("model is null");
        if (getById(model.getId()) == null)
            throw new IllegalArgumentException("model with id: "+model.getId()+" not exist");

        IUserEntity entity = userWriteModelToEntityMapper.Map(model);
        userRepository.update(entity);
    }

    @Override
    public void delete(int userId) {
        if (userId <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(userId) == null)
            throw new IllegalArgumentException("model with id: "+userId+" not exist");

        userRepository.delete(userId);
    }
}

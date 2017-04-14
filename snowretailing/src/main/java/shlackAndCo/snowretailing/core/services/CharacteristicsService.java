package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.core.contracts.services.ICharacteristicsService;
import shlackAndCo.snowretailing.core.models.CharacteristicsModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICharacteristicsRepository;
import shlackAndCo.snowretailing.dal.entities.CharacteristicsEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CharacteristicsService implements ICharacteristicsService {
    private final ICharacteristicsRepository repository;

    @Autowired
    public CharacteristicsService(@Qualifier("characteristicsRepository") ICharacteristicsRepository repository) throws IllegalArgumentException {
        if (repository == null)
            throw new IllegalArgumentException("Repository is null");

        this.repository = repository;
    }

    @Override
    public Collection<ICharacteristicsModel> getAll() {
        Collection<ICharacteristicsEntity> brandEntities = repository.getAll();
        return brandEntities.stream().map(CharacteristicsModel::new).collect(Collectors.toList());
    }

    @Override
    public ICharacteristicsModel getById(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        ICharacteristicsEntity entity = repository.getById(id);
        return entity == null ? null : new CharacteristicsModel(entity);
    }

    @Override
    public int create(ICharacteristicsModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("Model is null");

        return repository.create(Map(model));
    }

    public void edit(ICharacteristicsModel model) throws IllegalArgumentException {
        if (model.getId() <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (model == null)
            throw new IllegalArgumentException("Model is null");
        if (getById(model.getId()) == null)
            throw new IllegalArgumentException("Model with id: "+model.getId()+" not exist");

        ICharacteristicsEntity entity = Map(model);
        entity.setId(model.getId());
        repository.update(entity);
    }

    public void delete(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(id) == null)
            throw new IllegalArgumentException("Model with id: "+id+" not exist");

        repository.delete(id);
    }

    private ICharacteristicsEntity Map(ICharacteristicsModel model){
        ICharacteristicsEntity result = new CharacteristicsEntity();
        result.setId(model.getId());
        result.setName(model.getName());
        result.setMeasurment(model.getMeasurment());
        return result;
    }
}

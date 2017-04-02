package shlackAndCo.snowretailing.core.services;

import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IBaseModel;
import shlackAndCo.snowretailing.core.contracts.services.IBaseService;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBaseRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class BaseService<TModel extends IBaseModel, TEntity> implements IBaseService<TModel, TEntity> {
    private final IBaseRepository<TEntity> repository;
    private final IMapper<TModel,TEntity> modelToEntityMapper;
    private final IMapper<TEntity,TModel> entityToModelMapper;

    public BaseService(IBaseRepository<TEntity> repository,
                       IMapper<TModel,TEntity> modelToEntityMapper, IMapper<TEntity,TModel> entityToModelMapper){
        if(repository == null)
            throw new IllegalArgumentException("repository is null");
        if(modelToEntityMapper == null)
            throw new IllegalArgumentException("modelToEntityMapper is null");
        if(entityToModelMapper == null)
            throw new IllegalArgumentException("entityToModelMapper is null");

        this.repository = repository;
        this.modelToEntityMapper = modelToEntityMapper;
        this.entityToModelMapper = entityToModelMapper;
    }

    @Override
    public Collection<TModel> getAll() {
        Collection<TEntity> entities = repository.getAll();
        return entities.stream().map(entityToModelMapper::Map).collect(Collectors.toList());
    }

    @Override
    public TModel getById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        TEntity entity = repository.getById(id);
        return entity == null ? null : entityToModelMapper.Map(entity);
    }

    @Override
    public int create(TModel model) {
        if (model == null)
            throw new IllegalArgumentException("model is null");

        return repository.create(modelToEntityMapper.Map(model));
    }

    @Override
    public void edit(TModel model) {
        if (model == null)
            throw new IllegalArgumentException("brandModel is null");
        if (getById(model.getId()) == null)
            throw new IllegalArgumentException("model with id: "+model.getId()+" not exist");

        TEntity entity = modelToEntityMapper.Map(model);
        repository.update(entity);
    }

    @Override
    public void delete(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(id) == null)
            throw new IllegalArgumentException("model with id: "+id+" not exist");

        repository.delete(id);
    }
}

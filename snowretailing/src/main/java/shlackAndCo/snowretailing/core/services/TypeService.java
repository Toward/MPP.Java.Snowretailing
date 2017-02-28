package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.core.contracts.services.ITypeService;
import shlackAndCo.snowretailing.core.models.BrandModel;
import shlackAndCo.snowretailing.core.models.TypeModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.ITypeRepository;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TypeService implements ITypeService {
    private final ITypeRepository typeRepository;

    @Autowired
    public TypeService(@Qualifier("typeRepository") ITypeRepository typeRepository) throws IllegalArgumentException {
        if (typeRepository == null)
            throw new IllegalArgumentException("typeRepository is null");

        this.typeRepository = typeRepository;
    }
    @Override
    public Collection<ITypeModel> getAll() {
        Collection<ITypeEntity> typeEntities = typeRepository.getAll();
        return typeEntities.stream().map(x -> new TypeModel(x)).collect(Collectors.toList());
    }

    @Override
    public ITypeModel getById(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        ITypeEntity typeEntity = typeRepository.getById(id);
        return typeEntity == null ? null : new TypeModel(typeEntity);

    }

    @Override
    public int create(ITypeModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("typeModel is null");

        return typeRepository.create(Map(model));
    }

    @Override
    public void edit(int id, ITypeModel model) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (model == null)
            throw new IllegalArgumentException("typeModel is null");
        if (getById(id) == null)
            throw new IllegalArgumentException("typeModel with id: "+id+" not exist");

        ITypeEntity entity = Map(model);
        entity.setId(id);
        typeRepository.update(entity);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(id) == null)
            throw new IllegalArgumentException("typeModel with id: "+id+" not exist");

        typeRepository.delete(id);
    }
    private ITypeEntity Map(ITypeModel model){
        ITypeEntity result = new TypeEntity();
        result.setId(model.getId());
        result.setName(model.getName());
        result.setCost(model.getCost());
        return result;
    }
}

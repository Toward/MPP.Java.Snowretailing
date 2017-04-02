package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentService;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.ITypeRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

import java.util.Collection;
import java.util.stream.Collectors;

public class EquipmentService implements IEquipmentService {
    private final IEquipmentRepository equipmentRepository;
    private final IBrandRepository brandRepository;
    private final ITypeRepository typeRepository;

    @Autowired
    public EquipmentService(@Qualifier("equipmentRepository") IEquipmentRepository equipmentRepository,
                            @Qualifier("brandRepository") IBrandRepository brandRepository,
                            @Qualifier("typeRepository") ITypeRepository typeRepository)
            throws IllegalArgumentException {
        if (equipmentRepository == null)
            throw new IllegalArgumentException("equipmentRepository is null");
        if (brandRepository == null)
            throw new IllegalArgumentException("brandRepository is null");
        if (typeRepository == null)
            throw new IllegalArgumentException("typeRepository is null");

        this.equipmentRepository = equipmentRepository;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public Collection<IEquipmentModel> getAll() {
        Collection<IEquipmentEntity> equipmentEntities = equipmentRepository.getAll();
        return equipmentEntities.stream().map(x -> new EquipmentModel(x)).collect(Collectors.toList());
    }

    @Override
    public IEquipmentModel getById(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IEquipmentEntity equipmentEntity = equipmentRepository.getById(id);
        return equipmentEntity == null ? null : new EquipmentModel(equipmentEntity);
    }

    @Override
    public int create(IEquipmentModel model) throws IllegalArgumentException {
        if (model == null)
            throw new IllegalArgumentException("equipmentModel is null");

        return equipmentRepository.create(Map(model));
    }

    @Override
    public void edit(IEquipmentModel model) throws IllegalArgumentException {
        if (model.getId() <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (model == null)
            throw new IllegalArgumentException("equipmentModel is null");
        if (getById(model.getId()) == null)
            throw new IllegalArgumentException("equipmentModel with id: "+model.getId()+" not exist");

        IEquipmentEntity entity = Map(model);
        entity.setId(model.getId());
        equipmentRepository.update(entity);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");
        if (getById(id) == null)
            throw new IllegalArgumentException("equipmentModel with id: "+id+" not exist");

        equipmentRepository.delete(id);
    }
    private IEquipmentEntity Map(IEquipmentModel model){
        IEquipmentEntity result = new EquipmentEntity();
        result.setId(model.getId());
        result.setModel(model.getModel());
        result.setPhoto(model.getPhoto());
        result.setDeleted(model.getDeleted());
        result.setTypeByTypeId(getTypeEntityByName(model.getName()));
        result.setBrandByBrandId(getBrandEntityByName(model.getBrandName()));
        return result;
    }
    private TypeEntity getTypeEntityByName(EquipmentTypes name){
        Collection<ITypeEntity> typeEntities = typeRepository.getAll();
        for (ITypeEntity typeEntity:typeEntities) {
            if (typeEntity.getName() == name){
                return (TypeEntity)typeEntity;
            }
        }
        return null;
    }
    private BrandEntity getBrandEntityByName(String name){
        Collection<IBrandEntity> brandEntities = brandRepository.getAll();
        for (IBrandEntity brandEntity:brandEntities) {
            if (brandEntity.getBrandName() == name){
                return (BrandEntity)brandEntity;
            }
        }
        return null;
    }
}

package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentWriteModel;
import shlackAndCo.snowretailing.core.contracts.services.IRentService;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentItemRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RentService implements IRentService {
    private final IRentRepository rentRepository;
    private final IEquipmentItemRepository equipmentItemRepository;
    private final IMapper<IRentWriteModel, IRentEntity> rentModelToEntityMapper;
    private final IMapper<IRentEntity, IRentReadModel> rentEntityToModelMapper;

    @Autowired
    public RentService(@Qualifier("rentRepository") IRentRepository rentRepository,
                       @Qualifier("equipmentItemRepository") IEquipmentItemRepository equipmentItemRepository,
                        @Qualifier("rentWriteModelToEntityMapper") IMapper<IRentWriteModel, IRentEntity> rentWriteModelToEntityMapper,
                        @Qualifier("rentEntityToReadModelMapper") IMapper<IRentEntity, IRentReadModel> rentEntityToReadModelMapper) {
        this.rentRepository = rentRepository;
        this.rentModelToEntityMapper = rentWriteModelToEntityMapper;
        this.rentEntityToModelMapper = rentEntityToReadModelMapper;
        this.equipmentItemRepository = equipmentItemRepository;
    }

    @Override
    public Collection<IRentReadModel> getAll() {
        Collection<IRentEntity> entities = rentRepository.getAll();
        return entities.stream().map(rentEntityToModelMapper::Map).collect(Collectors.toList());
    }

    @Override
    public IRentReadModel getById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IRentEntity entity = rentRepository.getById(id);
        return entity == null ? null : rentEntityToModelMapper.Map(entity);
    }

    @Override
    public int create(IRentWriteModel model) {
        if (model == null)
            throw new IllegalArgumentException("model is null");

        return rentRepository.create(rentModelToEntityMapper.Map(model));
    }

    @Override
    public void edit(IRentWriteModel model) {
        if (model == null)
            throw new IllegalArgumentException("model is null");

        IRentEntity entity = rentModelToEntityMapper.Map(model);
        rentRepository.update(entity);
        int equipmentItemId = model.getEquipmentItemId();
        if (equipmentItemId <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        IEquipmentItemEntity equipmentItemEntity = equipmentItemRepository.getById(equipmentItemId);
        equipmentItemEntity.setState((byte) 1);
        equipmentItemRepository.update(equipmentItemEntity);
    }

    @Override
    public void delete(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("id must be greater than zero");

        rentRepository.delete(id);
    }
}

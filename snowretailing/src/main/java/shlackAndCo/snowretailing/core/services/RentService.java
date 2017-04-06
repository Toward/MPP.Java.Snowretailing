package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.core.contracts.services.IRentService;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRentRepository;

@Service
public class RentService extends BaseService<IRentModel, IRentEntity> implements IRentService {
    private final IRentRepository rentRepository;
    private final IMapper<IRentEntity, IRentModel> mapper;

    @Autowired
    public RentService(@Qualifier("rentRepository") IRentRepository rentRepository,
                        @Qualifier("rentModelToEntityMapper") IMapper<IRentModel, IRentEntity> rentModelToEntityMapper,
                        @Qualifier("rentEntityToModelMapper") IMapper<IRentEntity, IRentModel> rentEntityToModelMapper) {
        super(rentRepository, rentModelToEntityMapper, rentEntityToModelMapper);
        this.rentRepository = rentRepository;
        mapper = rentEntityToModelMapper;
    }

    @Override
    public void setDateFactReturn(IRentModel model) {

    }

    @Override
    public void setPassport(IRentModel model) {

    }
}

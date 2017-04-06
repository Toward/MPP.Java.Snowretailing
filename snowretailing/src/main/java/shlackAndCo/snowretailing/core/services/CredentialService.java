package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.services.ICredentialService;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICredentialRepository;

@Service
public class CredentialService extends BaseService<ICredentialModel,ICredentialEntity> implements ICredentialService {

    @Autowired
    public CredentialService(@Qualifier("credentialRepository") ICredentialRepository repository,
                             @Qualifier("credentialModelToEntityMapper") IMapper<ICredentialModel, ICredentialEntity> credentialModelToEntityMapper,
                             @Qualifier("credentialEntityToModelMapper")IMapper<ICredentialEntity, ICredentialModel> credentialEntityToModelMapper) {
        super(repository, credentialModelToEntityMapper, credentialEntityToModelMapper);
    }
}

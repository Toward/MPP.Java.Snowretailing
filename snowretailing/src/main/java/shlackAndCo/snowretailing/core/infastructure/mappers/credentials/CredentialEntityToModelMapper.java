package shlackAndCo.snowretailing.core.infastructure.mappers.credentials;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.models.CredentialModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;

@Component
@Scope("singleton")
public class CredentialEntityToModelMapper implements IMapper<ICredentialEntity, ICredentialModel> {
    @Override
    public ICredentialModel Map(ICredentialEntity sourceValue) {
        return new CredentialModel(sourceValue);
    }
}

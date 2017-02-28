package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;

@Component
public interface ICredentialRepository extends IBaseRepository<ICredentialEntity> {
}

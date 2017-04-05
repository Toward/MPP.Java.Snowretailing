package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICredentialRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;

@Repository
public class CredentialRepository extends BaseRepository<ICredentialEntity> implements ICredentialRepository {

    public CredentialRepository() {
        super(CredentialEntity.class);
    }
}

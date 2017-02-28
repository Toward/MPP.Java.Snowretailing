package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IPermissionsEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IPermissionsRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.PermissionsEntity;

@Repository
public class PermissionsRepository extends BaseRepository<IPermissionsEntity> implements IPermissionsRepository {

    public PermissionsRepository() {
        super(PermissionsEntity.class);
    }
}

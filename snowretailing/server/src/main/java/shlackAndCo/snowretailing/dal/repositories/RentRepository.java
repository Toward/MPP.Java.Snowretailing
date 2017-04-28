package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRentRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

@Repository
public class RentRepository extends BaseRepository<IRentEntity> implements IRentRepository {

    public RentRepository() {
        super(RentEntity.class);
    }
}

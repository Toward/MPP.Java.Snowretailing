package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;

@Repository
public class BrandRepository extends BaseRepository<IBrandEntity> implements IBrandRepository {

    public BrandRepository() {
        super(BrandEntity.class);
    }
}

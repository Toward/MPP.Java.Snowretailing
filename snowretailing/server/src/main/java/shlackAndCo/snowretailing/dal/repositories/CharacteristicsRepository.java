package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICharacteristicsRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.CharacteristicsEntity;

@Repository
public class CharacteristicsRepository extends BaseRepository<ICharacteristicsEntity> implements ICharacteristicsRepository {

    public CharacteristicsRepository() {
        super(CharacteristicsEntity.class);
    }
}

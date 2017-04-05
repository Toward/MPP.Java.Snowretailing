package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
        import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;

@Component
public interface IBrandRepository extends IBaseRepository<IBrandEntity> {
        IBrandEntity getByName(String brandName);
}

package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IReviewEntity;


@Component
public interface IReviewRepository extends IBaseRepository<IReviewEntity> {
}

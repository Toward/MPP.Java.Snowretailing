package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;


@Component
public interface IEquipmentItemRepository extends IBaseRepository<IEquipmentItemEntity> {
}

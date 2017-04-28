package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;


@Component
public interface ITypeRepository extends IBaseRepository<ITypeEntity> {
    ITypeEntity getByName(EquipmentTypes name);
}

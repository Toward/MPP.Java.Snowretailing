package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.models.EquipmentItemModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentEntity;

public interface IEquipmentService extends IBaseService<IEquipmentModel> {
    EquipmentItemModel getAvailableEquipmentItem(int equipmentId);
}

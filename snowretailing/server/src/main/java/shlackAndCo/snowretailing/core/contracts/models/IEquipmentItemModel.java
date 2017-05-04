package shlackAndCo.snowretailing.core.contracts.models;

public interface IEquipmentItemModel extends IBaseModel {
    void setEquipmentModel(IEquipmentModel equipmentModel);
    IEquipmentModel getEquipmentModel();
}

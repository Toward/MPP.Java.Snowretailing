package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

/**
 * Created by Владелец on 28/02/2017.
 */
public interface ITypeModel extends IBaseModel {

    public EquipmentTypes getName();

    public void setName(EquipmentTypes name);

    public int getCost();

    public void setCost(int cost);
}

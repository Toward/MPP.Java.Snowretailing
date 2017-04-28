package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

import javax.persistence.*;
import java.util.Collection;

public interface ITypeEntity {

    public int getId();

    public void setId(int id);

    public EquipmentTypes getName();

    public void setName(EquipmentTypes name);

    public int getCost();

    public void setCost(int cost);

    public Collection<EquipmentEntity> getEquipmentsById();

    public void setEquipmentsById(Collection<EquipmentEntity> equipmentsById);
}

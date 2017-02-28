package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;

import javax.persistence.*;
import java.util.Collection;

public interface ITypeEntity {

    public int getId();

    public void setId(int id);

    public Enum getName();

    public void setName(Enum name);

    public int getCost();

    public void setCost(int cost);

    public Collection<EquipmentEntity> getEquipmentsById();

    public void setEquipmentsById(Collection<EquipmentEntity> equipmentsById);
}

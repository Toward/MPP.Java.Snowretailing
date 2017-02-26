package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "brand", schema = "snowretailing_db")
public interface IBrandEntity {
    int getId();

    void setId(int id);

    String getBrandName();

    void setBrandName(String brandName) ;

    Collection<EquipmentEntity> getEquipmentsById();

    void setEquipmentsById(Collection<EquipmentEntity> equipmentsById);
}

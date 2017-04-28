package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

public interface IEquipmentEntity {
    public int getId();

    public void setId(int id);

    public String getModel();

    public void setModel(String model);

    public byte[] getPhoto();

    public void setPhoto(byte[] photo);

    public byte getDeleted();

    public void setDeleted(byte deleted);

    public BrandEntity getBrandByBrandId();

    public void setBrandByBrandId(BrandEntity brandByBrandId);

    public TypeEntity getTypeByTypeId();

    public void setTypeByTypeId(TypeEntity typeByTypeId);

    public Collection<EquipmentFeatureEntity> getEquipmentFeaturesById();

    public void setEquipmentFeaturesById(Collection<EquipmentFeatureEntity> equipmentFeaturesById);

    public Collection<EquipmentItemEntity> getEquipmentItemsById();

    public void setEquipmentItemsById(Collection<EquipmentItemEntity> equipmentItemsById);
}

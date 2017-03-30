package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.utils.CharacteristicsValue;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentFeatureEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

import java.util.ArrayList;
import java.util.Collection;

public class EquipmentModel implements IEquipmentModel {
    private int id;
    private String model;
    private byte[] photo;
    private byte deleted;
    private int quantity;
    private EquipmentTypes type;
    private String brand;
    private int cost;
    private Collection<CharacteristicsValue> characteristicsValues;

    public EquipmentModel(){
        id = 0;
    }

    public EquipmentModel(IEquipmentEntity equipmentEntity){
        id = 0;
        model = equipmentEntity.getModel();
        photo = equipmentEntity.getPhoto();
        deleted = equipmentEntity.getDeleted();
        type = equipmentEntity.getTypeByTypeId().getName();
        brand = equipmentEntity.getBrandByBrandId().getBrandName();
        cost = equipmentEntity.getTypeByTypeId().getCost();
        quantity = equipmentEntity.getEquipmentItemsById().size();
        characteristicsValues = getCharacteristicsValues(equipmentEntity);
    }

    private Collection<CharacteristicsValue> getCharacteristicsValues(IEquipmentEntity equipmentEntity){
        Collection<EquipmentFeatureEntity> equipmentFeatureEntities = equipmentEntity.getEquipmentFeaturesById();
        Collection<CharacteristicsValue> result = new ArrayList<CharacteristicsValue>();
        for (EquipmentFeatureEntity equipmentFeature:equipmentFeatureEntities) {
            CharacteristicsValue characteristicsValue = new CharacteristicsValue();
            ICharacteristicsEntity characteristicsEntity = equipmentFeature.getCharacteristicsByIdCharacteristics();
            characteristicsValue.setName(characteristicsEntity.getName());
            characteristicsValue.setMeasurments(characteristicsEntity.getMeasurment());
            characteristicsValue.setValue(equipmentFeature.getValue());
            result.add(characteristicsValue);
        }
        return result;
    }
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public byte[] getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public byte getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public Collection<CharacteristicsValue> getCharacteristicsValues() {
        return characteristicsValues;
    }

    @Override
    public EquipmentTypes getName() {
        return type;
    }

    @Override
    public void setName(EquipmentTypes name) {
        this.type = name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brand = brandName;
    }
}

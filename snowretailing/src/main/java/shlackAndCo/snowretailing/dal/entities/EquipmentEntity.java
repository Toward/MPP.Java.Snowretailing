package shlackAndCo.snowretailing.dal.entities;

import org.hibernate.annotations.GenericGenerator;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "equipment", schema = "snowretailing_db")
public class EquipmentEntity implements IEquipmentEntity {
    private int id;
    private String model;
    private byte[] photo;
    private byte deleted;
    private BrandEntity brandByBrandId;
    private TypeEntity typeByTypeId;
    private Collection<EquipmentFeatureEntity> equipmentFeaturesById;
    private Collection<EquipmentItemEntity> equipmentItemsById;

    @Id
    @Column(name = "ID", nullable = false)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MODEL", nullable = true, length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "PHOTO", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "DELETED", nullable = false)
    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentEntity that = (EquipmentEntity) o;

        if (id != that.id) return false;
        if (deleted != that.deleted) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (int) deleted;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID", nullable = false)
    public BrandEntity getBrandByBrandId() {
        return brandByBrandId;
    }

    public void setBrandByBrandId(BrandEntity brandByBrandId) {
        this.brandByBrandId = brandByBrandId;
    }

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID", nullable = false)
    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @OneToMany(mappedBy = "equipmentByIdEquipment")
    public Collection<EquipmentFeatureEntity> getEquipmentFeaturesById() {
        return equipmentFeaturesById;
    }

    public void setEquipmentFeaturesById(Collection<EquipmentFeatureEntity> equipmentFeaturesById) {
        this.equipmentFeaturesById = equipmentFeaturesById;
    }

    @OneToMany(mappedBy = "equipmentByEquipmentId")
    public Collection<EquipmentItemEntity> getEquipmentItemsById() {
        return equipmentItemsById;
    }

    public void setEquipmentItemsById(Collection<EquipmentItemEntity> equipmentItemsById) {
        this.equipmentItemsById = equipmentItemsById;
    }
}

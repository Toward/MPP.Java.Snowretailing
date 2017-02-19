package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "brand", schema = "snowretailing_db")
public class BrandEntity {
    private int id;
    private String brandName;
    private Collection<EquipmentEntity> equipmentsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand_name", nullable = false, length = 50)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandEntity that = (BrandEntity) o;

        if (id != that.id) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "brandByBrandId")
    public Collection<EquipmentEntity> getEquipmentsById() {
        return equipmentsById;
    }

    public void setEquipmentsById(Collection<EquipmentEntity> equipmentsById) {
        this.equipmentsById = equipmentsById;
    }
}

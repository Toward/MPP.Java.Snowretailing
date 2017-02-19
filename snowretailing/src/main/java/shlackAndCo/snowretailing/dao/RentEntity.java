package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rent", schema = "snowretailing_db")
public class RentEntity {
    private Timestamp dateExpectedReturn;
    private Timestamp dateFactReturn;
    private Timestamp dateGet;
    private int id;
    private CredentialEntity credentialByCredentialId;
    private EquipmentItemEntity equipmentItemByEquipmentItemId;

    @Basic
    @Column(name = "DATE_EXPECTED_RETURN", nullable = false)
    public Timestamp getDateExpectedReturn() {
        return dateExpectedReturn;
    }

    public void setDateExpectedReturn(Timestamp dateExpectedReturn) {
        this.dateExpectedReturn = dateExpectedReturn;
    }

    @Basic
    @Column(name = "DATE_FACT_RETURN", nullable = true)
    public Timestamp getDateFactReturn() {
        return dateFactReturn;
    }

    public void setDateFactReturn(Timestamp dateFactReturn) {
        this.dateFactReturn = dateFactReturn;
    }

    @Basic
    @Column(name = "DATE_GET", nullable = true)
    public Timestamp getDateGet() {
        return dateGet;
    }

    public void setDateGet(Timestamp dateGet) {
        this.dateGet = dateGet;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentEntity that = (RentEntity) o;

        if (id != that.id) return false;
        if (dateExpectedReturn != null ? !dateExpectedReturn.equals(that.dateExpectedReturn) : that.dateExpectedReturn != null)
            return false;
        if (dateFactReturn != null ? !dateFactReturn.equals(that.dateFactReturn) : that.dateFactReturn != null)
            return false;
        if (dateGet != null ? !dateGet.equals(that.dateGet) : that.dateGet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateExpectedReturn != null ? dateExpectedReturn.hashCode() : 0;
        result = 31 * result + (dateFactReturn != null ? dateFactReturn.hashCode() : 0);
        result = 31 * result + (dateGet != null ? dateGet.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CREDENTIAL_ID", referencedColumnName = "ID", nullable = false)
    public CredentialEntity getCredentialByCredentialId() {
        return credentialByCredentialId;
    }

    public void setCredentialByCredentialId(CredentialEntity credentialByCredentialId) {
        this.credentialByCredentialId = credentialByCredentialId;
    }

    @ManyToOne
    @JoinColumn(name = "EQUIPMENT_ITEM_ID", referencedColumnName = "ID", nullable = false)
    public EquipmentItemEntity getEquipmentItemByEquipmentItemId() {
        return equipmentItemByEquipmentItemId;
    }

    public void setEquipmentItemByEquipmentItemId(EquipmentItemEntity equipmentItemByEquipmentItemId) {
        this.equipmentItemByEquipmentItemId = equipmentItemByEquipmentItemId;
    }
}

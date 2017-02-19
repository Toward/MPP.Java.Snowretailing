package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order", schema = "snowretailing_db")
public class OrderEntity {
    private int id;
    private Timestamp dateOrderExpire;
    private Timestamp dateOrder;
    private int sumPay;
    private UserEntity userByUserId;
    private EquipmentItemEntity equipmentItemByItemId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATE_ORDER_EXPIRE", nullable = false)
    public Timestamp getDateOrderExpire() {
        return dateOrderExpire;
    }

    public void setDateOrderExpire(Timestamp dateOrderExpire) {
        this.dateOrderExpire = dateOrderExpire;
    }

    @Basic
    @Column(name = "DATE_ORDER", nullable = false)
    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Basic
    @Column(name = "SUM_PAY", nullable = false)
    public int getSumPay() {
        return sumPay;
    }

    public void setSumPay(int sumPay) {
        this.sumPay = sumPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (sumPay != that.sumPay) return false;
        if (dateOrderExpire != null ? !dateOrderExpire.equals(that.dateOrderExpire) : that.dateOrderExpire != null)
            return false;
        if (dateOrder != null ? !dateOrder.equals(that.dateOrder) : that.dateOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateOrderExpire != null ? dateOrderExpire.hashCode() : 0);
        result = 31 * result + (dateOrder != null ? dateOrder.hashCode() : 0);
        result = 31 * result + sumPay;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", nullable = false)
    public EquipmentItemEntity getEquipmentItemByItemId() {
        return equipmentItemByItemId;
    }

    public void setEquipmentItemByItemId(EquipmentItemEntity equipmentItemByItemId) {
        this.equipmentItemByItemId = equipmentItemByItemId;
    }
}

package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "permissions", schema = "snowretailing_db")
public class PermissionsEntity {
    private int id;
    private String description;
    private Collection<PToREntity> pToRSById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionsEntity that = (PermissionsEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "permissionsByPermissionId")
    public Collection<PToREntity> getpToRSById() {
        return pToRSById;
    }

    public void setpToRSById(Collection<PToREntity> pToRSById) {
        this.pToRSById = pToRSById;
    }
}

package shlackAndCo.snowretailing.dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "contact data", schema = "snowretailing_db")
public class ContactDataEntity {
    private int id;
    private String phoneNumber;
    private CredentialEntity credentialByCredentialId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = false, length = 13)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDataEntity that = (ContactDataEntity) o;

        if (id != that.id) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Credential_ID", referencedColumnName = "ID", nullable = false)
    public CredentialEntity getCredentialByCredentialId() {
        return credentialByCredentialId;
    }

    public void setCredentialByCredentialId(CredentialEntity credentialByCredentialId) {
        this.credentialByCredentialId = credentialByCredentialId;
    }
}

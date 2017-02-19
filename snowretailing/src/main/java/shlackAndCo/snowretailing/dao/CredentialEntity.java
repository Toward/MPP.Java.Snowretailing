package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "credential", schema = "snowretailing_db")
public class CredentialEntity {
    private String name;
    private String surname;
    private String patronymyc;
    private int number;
    private String series;
    private String agency;
    private Timestamp date;
    private int id;
    private Date birthday;
    private String identifier;
    private String type;
    private Collection<ContactDataEntity> contactDatasById;
    private UserEntity userByUserId;
    private Collection<RentEntity> rentsById;

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "PATRONYMYC", nullable = false, length = 50)
    public String getPatronymyc() {
        return patronymyc;
    }

    public void setPatronymyc(String patronymyc) {
        this.patronymyc = patronymyc;
    }

    @Basic
    @Column(name = "NUMBER", nullable = false, precision = 0)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "SERIES", nullable = false, length = 50)
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Basic
    @Column(name = "AGENCY", nullable = false, length = 50)
    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Basic
    @Column(name = "DATE", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BIRTHDAY", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "IDENTIFIER", nullable = false, length = 50)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @Column(name = "TYPE", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CredentialEntity that = (CredentialEntity) o;

        if (number != that.number) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronymyc != null ? !patronymyc.equals(that.patronymyc) : that.patronymyc != null) return false;
        if (series != null ? !series.equals(that.series) : that.series != null) return false;
        if (agency != null ? !agency.equals(that.agency) : that.agency != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymyc != null ? patronymyc.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (agency != null ? agency.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "credentialByCredentialId")
    public Collection<ContactDataEntity> getContactDatasById() {
        return contactDatasById;
    }

    public void setContactDatasById(Collection<ContactDataEntity> contactDatasById) {
        this.contactDatasById = contactDatasById;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "credentialByCredentialId")
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }
}

package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Владелец on 03/03/2017.
 */
public class CredentialModel implements ICredentialModel {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String patronymyc;
    @NotNull
    private int number;
    @NotEmpty
    private String series;
    @NotEmpty
    private String agency;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private Timestamp date;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private Date birthday;
    @NotEmpty
    private String identifier;
    @NotEmpty
    private String type;



    public CredentialModel() {}

    public CredentialModel(ICredentialEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.surname = entity.getSurname();
        this.patronymyc = entity.getPatronymyc();
        this.number = entity.getNumber();
        this.series = entity.getSeries();
        this.agency = entity.getAgency();
        this.date = entity.getDate();
        this.birthday = entity.getBirthday();
        this.identifier = entity.getIdentifier();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getPatronymyc() {
        return patronymyc;
    }

    @Override
    public void setPatronymyc(String patronymyc) {
        this.patronymyc = patronymyc;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getSeries() {
        return series;
    }

    @Override
    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String getAgency() {
        return agency;
    }

    @Override
    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public Timestamp getDate() {
        return date;
    }

    @Override
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}

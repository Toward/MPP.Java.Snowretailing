package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.PToREntity;

import javax.persistence.*;
import java.util.Collection;

public interface IPermissionsEntity {

    public int getId();
    public void setId(int id);

    public String getDescription();

    public void setDescription(String description);

    public Collection<PToREntity> getpToRSById();

    public void setpToRSById(Collection<PToREntity> pToRSById);
}

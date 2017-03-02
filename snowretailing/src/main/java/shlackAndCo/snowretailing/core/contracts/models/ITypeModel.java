package shlackAndCo.snowretailing.core.contracts.models;

/**
 * Created by Владелец on 28/02/2017.
 */
public interface ITypeModel extends IBaseModel {

    public Enum getName();

    public void setName(Enum name);

    public int getCost();

    public void setCost(int cost);
}

package shlackAndCo.snowretailing.dal.contracts.repositories;

import java.util.Collection;

public interface IBaseRepository <T> {
    Collection<T> getAll();

    T getById(int id);

    int create(T entity);

    void update(T entity);

    void delete(int brandId);
}

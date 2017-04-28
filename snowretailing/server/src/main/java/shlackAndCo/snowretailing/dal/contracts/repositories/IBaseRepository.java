package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.hibernate.HibernateException;

import java.util.Collection;

public interface IBaseRepository <T> {
    Collection<T> getAll() throws HibernateException;

    T getById(int id) throws HibernateException, IllegalArgumentException;

    int create(T entity) throws HibernateException, IllegalArgumentException;

    void update(T entity) throws HibernateException, IllegalArgumentException;

    void delete(int id) throws HibernateException, IllegalArgumentException;
}

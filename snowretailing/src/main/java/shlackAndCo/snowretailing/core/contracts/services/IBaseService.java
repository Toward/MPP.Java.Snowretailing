package shlackAndCo.snowretailing.core.contracts.services;

import java.util.Collection;

public interface IBaseService<T> {
        Collection<T> getAll();

        T getById(int id) throws IllegalArgumentException;

        int create(T model) throws IllegalArgumentException;

        void edit(int id, T model) throws IllegalArgumentException;

        void delete(int id) throws IllegalArgumentException;
}

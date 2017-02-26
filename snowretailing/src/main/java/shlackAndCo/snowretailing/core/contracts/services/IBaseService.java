package shlackAndCo.snowretailing.core.contracts.services;

import java.util.Collection;

public interface IBaseService<T> {
        Collection<T> getAll();

        T getById(int id);

        int create(T model);

        void edit(int brandId, T model);

        void delete(int model);
}

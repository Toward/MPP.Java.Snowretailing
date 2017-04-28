package shlackAndCo.snowretailing.core.contracts.services;

import java.util.Collection;

public interface IBaseService<TModel> {
        Collection<TModel> getAll();

        TModel getById(int id);

        int create(TModel model);

        void edit(TModel model);

        void delete(int id);
}

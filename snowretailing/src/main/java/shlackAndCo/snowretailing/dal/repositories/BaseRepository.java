package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBaseRepository;
import shlackAndCo.snowretailing.dal.utils.HibernateSessionFactory;

import java.util.Collection;

public class BaseRepository <T> implements IBaseRepository<T> {
    protected final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private final Class entityType;

    public BaseRepository(Class entityType) throws IllegalArgumentException {
        if (entityType == null)
            throw new IllegalArgumentException("entityType is null");

        this.entityType = entityType;
    }

    public Collection<T> getAll() throws HibernateException {
        Collection<T> result;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            result = session.createCriteria(entityType).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            transaction.commit();
        }catch (HibernateException e){
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
        return result;
    }

    public T getById(int id) throws HibernateException, IllegalArgumentException {
        if (id <= 0 )
            throw new IllegalArgumentException("id must be greater than zero");

        T result;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            result = (T)session.get(entityType,id);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
        return result;
    }

    public int create(T entity) throws HibernateException, IllegalArgumentException {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        Transaction transaction = null;
        int newBrandId;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            newBrandId = (int) session.save(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
        return newBrandId;
    }

    public void update(T entity) throws HibernateException, IllegalArgumentException {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
    }

    public void delete(int id) throws HibernateException, IllegalArgumentException {
        if (id <= 0 )
            throw new IllegalArgumentException("id must be greater than zero");
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            T entity = (T)session.get(entityType,id);
            session.delete(entity);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
    }
}

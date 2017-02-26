package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBaseRepository;
import shlackAndCo.snowretailing.dal.utils.HibernateSessionFactory;

import java.util.Collection;

public class BaseRepository <T> implements IBaseRepository<T> {
    protected final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private final Class entityType;

    public BaseRepository(Class entityType){
        this.entityType = entityType;
    }

    public Collection<T> getAll() {
        Collection<T> result;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            result = session.createCriteria(entityType).list();
            transaction.commit();
        }catch (HibernateException e){
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
        return result;
    }

    public T getById(int id) {
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

    public int create(T entity) {
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

    public void update(T entity) {
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

    public void delete(int brandId) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            T entity = (T)session.get(entityType,brandId);
            session.delete(entity);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
    }
}

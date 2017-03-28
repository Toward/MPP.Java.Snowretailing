package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IUserRepository;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

@Repository
public class UserRepository extends BaseRepository<IUserEntity> implements IUserRepository {

    public UserRepository() {
        super(UserEntity.class);
    }

    @Override
    public IUserEntity getByLogin(String login) {
        if (login == null || login.isEmpty()){
            throw new IllegalArgumentException("login is empty");
        }

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            IUserEntity result = (IUserEntity)session.createCriteria(UserEntity.class)
                    .add(Restrictions.eq("login",login))
                    .uniqueResult();
            transaction.commit();
            return result;
        }catch (HibernateException e){
            if (transaction == null)
                transaction.rollback();
            throw e;
        }
    }
}

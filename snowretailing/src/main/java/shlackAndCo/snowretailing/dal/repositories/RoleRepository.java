package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IRoleRepository;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

@Repository
public class RoleRepository extends BaseRepository<IRoleEntity> implements IRoleRepository {

    public RoleRepository() {
        super(RoleEntity.class);
    }

    @Override
    public IRoleEntity getByRoleName(String roleName) {
        if (roleName == null || roleName.isEmpty()){
            throw new IllegalArgumentException("Role name is empty");
        }

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            IRoleEntity result = (IRoleEntity)session.createCriteria(RoleEntity.class)
                    .add(Restrictions.eq("roleName",roleName))
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

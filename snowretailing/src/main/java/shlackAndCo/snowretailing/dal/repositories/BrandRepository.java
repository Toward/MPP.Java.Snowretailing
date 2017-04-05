package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;

@Repository
public class BrandRepository extends BaseRepository<IBrandEntity> implements IBrandRepository {

    public BrandRepository() {
        super(BrandEntity.class);
    }

    @Override
    public IBrandEntity getByName(String brandName) {
        if (brandName == null || brandName.isEmpty()){
            throw new IllegalArgumentException("brandName is empty");
        }

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            IBrandEntity result = (IBrandEntity)session.createCriteria(BrandEntity.class)
                    .add(Restrictions.eq("brandName",brandName))
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

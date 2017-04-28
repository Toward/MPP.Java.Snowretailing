package shlackAndCo.snowretailing.dal.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.ITypeRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

@Repository
public class TypeRepository extends BaseRepository<ITypeEntity> implements ITypeRepository {

    public TypeRepository() {
        super(TypeEntity.class);
    }

    @Override
    public ITypeEntity getByName(EquipmentTypes name) {
        if (name == null){
            throw new IllegalArgumentException("name is empty");
        }

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            ITypeEntity result = (ITypeEntity)session.createCriteria(TypeEntity.class)
                    .add(Restrictions.eq("name",name))
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

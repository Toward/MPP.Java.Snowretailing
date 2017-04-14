package factories;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.dal.contracts.repositories.IContactDataRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.TypeEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;


import java.util.List;

import static org.mockito.Mockito.*;

public class TestsFactory extends BaseFactory {
    @Override
    public SessionFactory createMockSessionFactory(Session session) {
        SessionFactory result = createSessionFactory();
        when(result.openSession()).thenReturn(session);
        return result;
    }

    @Override
    public Session createMockSession(){
        Session result = Mockito.mock(Session.class);
        when(result.beginTransaction()).thenReturn(Mockito.mock(Transaction.class));
        return result;
    }

    @Override
    public Session createMockSessionWithException() {
        Session session = createMockSession();
        doThrow(HibernateException.class).when(session).get(any(Class.class),anyInt());
        doThrow(HibernateException.class).when(session).save(any(Object.class));
        doThrow(HibernateException.class).when(session).update(any(Object.class));
        doThrow(HibernateException.class).when(session).delete(any(Object.class));
        doThrow(HibernateException.class).when(session).createCriteria(any(Class.class));
        return session;
    }

    @Override
    public Session createMockSessionWithGetAll(List expectedObjects, Class entityType) {
        Session session = createMockSession();
        Criteria mockCriteria = Mockito.mock(Criteria.class);
        when(mockCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)).thenReturn(mockCriteria);
        when(mockCriteria.list()).thenReturn(expectedObjects);
        when(session.createCriteria(entityType)).thenReturn(mockCriteria);
        return session;
    }

    @Override
    public Session createMockSessionWithGet(Object returnedObject) {
        Session session = createMockSession();
        when(session.get(any(Class.class),anyInt())).thenReturn(returnedObject);
        return session;
    }

    @Override
    public Session createMockSessionWithSave(int returnedId) {
        Session session = createMockSession();
        when(session.save(any(Object.class))).thenReturn(returnedId);
        return session;
    }

    @Override
    public Session createMockSessionWithGetByName(Object deletedObject, String name) {
        Session session = createMockSession();
        Criteria mockCriteria = Mockito.mock(Criteria.class);
        when(mockCriteria.add(Restrictions.eq(name, anyString()))).thenReturn(mockCriteria);
        when(mockCriteria.uniqueResult()).thenReturn(deletedObject);
        when(session.createCriteria(BrandEntity.class)).thenReturn(mockCriteria);
        when(session.createCriteria(TypeEntity.class)).thenReturn(mockCriteria);
        when(session.createCriteria(RoleEntity.class)).thenReturn(mockCriteria);
        when(session.createCriteria(UserEntity.class)).thenReturn(mockCriteria);
        return session;
    }

    @Override
    public IContactDataRepository createMockContactDataRepository() {
        return Mockito.mock(IContactDataRepository.class);
    }

    private SessionFactory createSessionFactory(){
        return Mockito.mock(SessionFactory.class);
    }
}

package dao;

import factory.DbSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.*;

public class EventDao {

    private Session session;
    private Transaction transaction;

    public void save(Object event){
        connect();
        session.save(event);
        close();
    }

    public void update(Object event){
        connect();
        session.update(event);
        close();
    }

    public void delete(Object event){
        connect();
        session.delete(event);
        close();
    }

    private void connect(){
        session = DbSessionFactory.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void close(){
        transaction.commit();
        session.close();
    }
}

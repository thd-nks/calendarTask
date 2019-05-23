package dao;

import factory.DbSessionFactory;
import model.event.Birthday;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BirthdayDao {

    private Session session;
    private Transaction transaction;

    public void save(Birthday birthday){
        connect();
        session.save(birthday);
        close();
    }

    public void update(Birthday birthday){
        connect();
        session.update(birthday);
        close();
    }

    public void delete(Birthday birthday){
        connect();
        session.delete(birthday);
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

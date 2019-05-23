package dao;

import factory.DbSessionFactory;
import model.event.Meeting;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MeetingDao{

    private Session session;
    private Transaction transaction;

    public void save(Meeting meeting){
        connect();
        session.save(meeting);
        close();
    }

    public void update(Meeting meeting){
        connect();
        session.update(meeting);
        close();
    }

    public void delete(Meeting meeting){
        connect();
        session.delete(meeting);
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

package factory;

import model.event.Birthday;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class DbSessionFactory {
    private static SessionFactory sessionFactory;

    private DbSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                File f = new File("D:\\Java Projects\\calendarTask\\src\\main\\resources\\hibernate.cfg.xml");
                Configuration configuration = new Configuration().configure(f);
                configuration.addAnnotatedClass(dao.MeetingEntity.class);
                configuration.addAnnotatedClass(dao.BirthdayEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}

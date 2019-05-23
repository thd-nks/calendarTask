package services;

import dao.EventDao;
import model.event.Birthday;
import model.event.Event;

public class TableService {

    private EventDao eventDao = new EventDao();

    public TableService() {
    }

    public void save(Object event) {
        eventDao.save(event);
    }
    public void delete(Object event) {
        eventDao.delete(event);
    }

    public void update(Object event) {
        eventDao.update(event);
    }
}

package dao;

import model.event.Birthday;

public interface Dao {

    void save(Birthday birthday);

    void update(Birthday birthday);

    void delete(Birthday birthday);
}

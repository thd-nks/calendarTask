package model.event;

import java.io.Serializable;

public class Meeting extends Event implements Serializable {

    public Meeting(String name, String description) {
        super(name,description);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "У вас встреча c "
                + name
                + ". Описание: "
                + description;
    }
}

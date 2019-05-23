package model.event;

import java.io.Serializable;

public abstract class Event implements Serializable {

    protected String name;
    protected String description;

    Event(String name, String description){
        this.name = name;
        this.description = description;
    }

    abstract void setName(String name);
    abstract String getName();
    abstract void setDescription(String description);
    abstract String getDescription();
}

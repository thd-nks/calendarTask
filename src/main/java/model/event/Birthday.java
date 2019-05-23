package model.event;

import java.io.Serializable;

public class Birthday extends Event implements Serializable {

    private String present;

    public Birthday(String name,  String description, String present) {
        super(name, description);
        this.present = present;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
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
    public String toString() {
        return "У "
                + name
                + " день рождения. Подарок: "
                + present
                + ". Описание: "
                + description
                +".";
    }
}

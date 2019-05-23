package model.containers;

import model.event.Event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Day implements Serializable {

    private Map<Integer, Event> events;

    public Day(){
        events = new HashMap<>();
    }

    public Map<Integer,Event> getEvents(){
        return events;
    }

    public Event getEvent(int hour) {
        return events.get(hour);
    }

    public boolean isEmpty(){
        return events.isEmpty();
    }

    public void setEvent(int hour, Event event){
         events.put(hour, event);
    }
}

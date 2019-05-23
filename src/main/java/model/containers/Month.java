package model.containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Month  implements Serializable {

    private Map<Integer,Day> days;

    public Month(){
        days = new HashMap<>();
    }

    public Day getDay(int day){
        return days.get(day);
    }

    public Day getOrSetDay(int day){
        if (!days.containsKey(day))
            days.put(day,new Day());
        return days.get(day);
    }

    public Map<Integer, Day> getDays(){
        return days;
    }

    public boolean isEmpty(){
        return days.isEmpty();
    }

    public void deleteDay(int day){
        days.remove(day);
    }

    public void setDay(int day){
        days.put(day,new Day());
    }

}

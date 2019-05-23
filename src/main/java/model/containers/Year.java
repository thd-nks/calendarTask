package model.containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Year implements Serializable {

    private Map<Integer,Month> months;

    public Year() {
        months = new HashMap<>();
    }

    public Month getMonth(int month){
        return months.get(month);
    }

    public Month getOrSetMonth(int month){
        if (!months.containsKey(month))
            months.put(month,new Month());
        return months.get(month);
    }
    public Map<Integer,Month> getMonths(){
        return months;
    }

    public boolean isEmpty(){
        return months.isEmpty();
    }

    public void deleteMonth(int month){
        months.remove(month);
    }

    public void setMonth(int month){
        months.put(month,new Month());
    }

}

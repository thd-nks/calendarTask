package model.containers;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Century implements Serializable {

    private Map<Integer,Year> years;

    public Century(){
        years = new HashMap<>();
    }

    public Year getYear(int year){
        return years.get(year);
    }

    public Year getOrSetYear(int year){
        if (!years.containsKey(year))
            years.put(year,new Year());
        return years.get(year);
    }

    public boolean isEmpty(){
        return years.isEmpty();
    }

    public void deleteYear(int year){
        years.remove(year);
    }

    public void setYear(int year){
        years.put(year,new Year());
    }

    public Map<Integer,Year> getYears(){
        return years;
    }

}

package services;

import model.containers.Century;
import model.event.Birthday;
import model.containers.Year;
import model.containers.Month;
import model.event.Event;
import model.containers.Day;

import java.text.SimpleDateFormat;
import java.util.*;

public class Service {

    public void setEvent(Century century, int year, int month, int day, int hour, Event event) {
        Year t_year = century.getOrSetYear(year);
        Month t_month = t_year.getOrSetMonth(month);
        Day t_day = t_month.getOrSetDay(day);
        t_day.setEvent(hour,event);
    }

    public Event getEvent(Century century, int year, int month, int day, int hour) {
        Event event = new Birthday(null,null,null);
        Day t_day = checkDay(century, year, month, day);
        if (t_day != null)
            event = t_day.getEvent(hour);
        return event;
    }

    public void deleteEvent(Century century, int year, int month, int day, int hour) {
        Day t_day = checkDay(century, year, month, day);
        if( t_day != null)
            t_day.setEvent(hour,null);
        clearCalendar(century, year, month, day);
    }

    public List<Event> periodEvents(Century century, int year1, int year2){
        List<Event> events = new ArrayList<>();
        for (int i = year1; i < year2; i++){
            Year year = century.getYear(i);
            for(Month month : year.getMonths().values())
                for(Day day: month.getDays().values())
                    events.addAll(day.getEvents().values());
        }
        return events;
    }

    private Day checkDay(Century century, int year, int month, int day){
         Year t_year = century.getYear(year);
         if (t_year == null)
             return null;
         Month t_month = t_year.getMonth(month);
         if( t_month == null)
             return null;
         Day t_day = t_month.getDay(day);
         return t_day;
    }

    private void clearCalendar(Century century, int year, int month, int day){
        Year t_year = century.getYear(year);
        Month t_month = t_year.getMonth(month);
        Day t_day = t_month.getDay(day);
        if(t_day.isEmpty())
            t_month.deleteDay(day);
        if(t_month.isEmpty())
            t_year.deleteMonth(month);
        if(t_year.isEmpty())
            century.deleteYear(year);
    }
}

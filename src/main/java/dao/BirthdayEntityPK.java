package dao;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BirthdayEntityPK implements Serializable {
    private int year;
    private int month;
    private int day;
    private int hour;

    @Column(name = "Year", nullable = false)
    @Id
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "Month", nullable = false)
    @Id
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Column(name = "Day", nullable = false)
    @Id
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Column(name = "Hour", nullable = false)
    @Id
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthdayEntityPK that = (BirthdayEntityPK) o;

        if (year != that.year) return false;
        if (month != that.month) return false;
        if (day != that.day) return false;
        if (hour != that.hour) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        result = 31 * result + hour;
        return result;
    }
}

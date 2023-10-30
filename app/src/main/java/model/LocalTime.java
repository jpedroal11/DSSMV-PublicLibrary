package model;

import org.jetbrains.annotations.NotNull;

public class LocalTime {

    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer nano;

    public LocalTime(Integer hour, Integer minute, Integer second, Integer nano) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.nano = nano;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getNano() {
        return nano;
    }

    public void setNano(Integer nano) {
        this.nano = nano;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("LocalTime[hour=%d, minute=%d, nano=%d, second=%d]", hour, minute, second, nano);
    }

}

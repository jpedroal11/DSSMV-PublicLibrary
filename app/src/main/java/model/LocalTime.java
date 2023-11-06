package model;

import org.jetbrains.annotations.NotNull;

public class LocalTime {

    private int hour;
    private int minute;
    private int second;
    private int nano;

    public LocalTime(int hour, int minute, int second, int nano) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.nano = nano;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getNano() {
        return nano;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("LocalTime[hour=%d, minute=%d, nano=%d, second=%d]", hour, minute, second, nano);
    }

}

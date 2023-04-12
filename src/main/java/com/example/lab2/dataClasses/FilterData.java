package com.example.lab2.dataClasses;

import java.time.LocalDate;

public class FilterData {
    private LocalDate date;
    private Priority priority;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public FilterData(LocalDate date, Priority priority) {
        this.date = date;
        this.priority = priority;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FilterData{");
        sb.append("date=").append(date);
        sb.append(", priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }
}

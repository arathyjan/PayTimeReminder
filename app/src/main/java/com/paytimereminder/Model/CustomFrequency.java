package com.paytimereminder.Model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class CustomFrequency extends RealmObject{
    @PrimaryKey
    private int id;

    private int weekFrequency;

    @Ignore
    private List<DaysOfWeek> daysOfWeekList;

    private RealmList<RealmString> savedDaysOfWeekList;

    private RealmDateTime untilDate;

    private int noOfEvents;

    private boolean forever;

    public CustomFrequency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekFrequency() {
        return weekFrequency;
    }

    public void setWeekFrequency(int weekFrequency) {
        this.weekFrequency = weekFrequency;
    }

    public List<DaysOfWeek> getDaysOfWeekList() {
        return daysOfWeekList;
    }

    public void setDaysOfWeekList(List<DaysOfWeek> daysOfWeekList) {
        this.daysOfWeekList = daysOfWeekList;
    }

    public RealmDateTime getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(RealmDateTime untilDate) {
        this.untilDate = untilDate;
    }

    public int getNoOfEvents() {
        return noOfEvents;
    }

    public void setNoOfEvents(int noOfEvents) {
        this.noOfEvents = noOfEvents;
    }

    public boolean isForever() {
        return forever;
    }

    public void setForever(boolean forever) {
        this.forever = forever;
    }

    public RealmList<RealmString> getSavedDaysOfWeekList() {
        savedDaysOfWeekList = new RealmList<>();
        for (DaysOfWeek day : daysOfWeekList) {
            savedDaysOfWeekList.add(new RealmString(day.name()));
        }

        return savedDaysOfWeekList;
    }

    public void setSavedDaysOfWeekList(RealmList<RealmString> savedDaysOfWeekList) {
        this.savedDaysOfWeekList = savedDaysOfWeekList;

        for (RealmString day : savedDaysOfWeekList) {
            daysOfWeekList.add(DaysOfWeek.valueOf(day.getVal()));
        }

    }
}
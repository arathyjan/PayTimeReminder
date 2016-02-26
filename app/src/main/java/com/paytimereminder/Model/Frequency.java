package com.paytimereminder.Model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Frequency extends RealmObject{

    @PrimaryKey
    private int id;

    private Date startDate;

    private Date endDate;

    private CustomFrequency customFrequency;

    private String savedFrequencyPeriod;

    @Ignore
    private FrequencyPeriod FREQUENCYPERIOD;

    private RealmList<RealmDateTime> alarmFrequency;

    public Frequency() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CustomFrequency getCustomFrequency() {
        return customFrequency;
    }

    public void setCustomFrequency(CustomFrequency customFrequency) {
        this.customFrequency = customFrequency;
    }

    public FrequencyPeriod getFREQUENCYPERIOD() {
        return FREQUENCYPERIOD;
    }

    public void setFREQUENCYPERIOD(FrequencyPeriod FREQUENCYPERIOD) {
        this.FREQUENCYPERIOD = FREQUENCYPERIOD;
    }

    public RealmList<RealmDateTime> getAlarmFrequency() {
        return alarmFrequency;
    }

    public void setAlarmFrequency(RealmList<RealmDateTime> alarmFrequency) {
        this.alarmFrequency = alarmFrequency;
    }

    public String getSavedFrequencyPeriod() {
        if(FREQUENCYPERIOD != null)
            savedFrequencyPeriod = FREQUENCYPERIOD.name();
        return savedFrequencyPeriod;
    }

    public void setSavedFrequencyPeriod(String savedFrequencyPeriod) {
        this.savedFrequencyPeriod = savedFrequencyPeriod;
        if(FREQUENCYPERIOD != null)
            FREQUENCYPERIOD = FrequencyPeriod.valueOf(savedFrequencyPeriod);
    }
}
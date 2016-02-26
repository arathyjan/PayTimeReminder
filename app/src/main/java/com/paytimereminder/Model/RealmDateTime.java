package com.paytimereminder.Model;

import java.util.Date;

import io.realm.RealmObject;

public class RealmDateTime extends RealmObject {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

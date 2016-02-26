package com.paytimereminder.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PayItemDetails extends RealmObject {
    @PrimaryKey
    private int id;

    private String name;

    public PayItemDetails() {
    }

    public PayItemDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PayItemDetails(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

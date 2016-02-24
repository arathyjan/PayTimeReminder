package com.paytimereminder.Model;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PayItem extends RealmObject {

    @PrimaryKey

    private int id;

    @NonNull
    private String name;

    public PayItem() {
    }

    public PayItem(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public PayItem(@NonNull String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}

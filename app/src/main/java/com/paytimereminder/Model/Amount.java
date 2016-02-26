package com.paytimereminder.Model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Amount extends RealmObject {
    @PrimaryKey
    private int id;

    private double emi;

    private double totalToBePaid;

    private double totalPaid;

    @Ignore
    private double totalLeft;

    public Amount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public double getTotalToBePaid() {
        return totalToBePaid;
    }

    public void setTotalToBePaid(double totalToBePaid) {
        this.totalToBePaid = totalToBePaid;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalLeft() {
        return totalLeft;
    }

    public void setTotalLeft(double totalLeft) {
        this.totalLeft = totalLeft;
    }
}

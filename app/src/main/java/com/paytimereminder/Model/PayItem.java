package com.paytimereminder.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PayItem extends RealmObject {

    @PrimaryKey
    private int id;

    private PayItemDetails payItemDetails;

    private Frequency frequency;

    private Amount amount;

    public PayItem() {
    }

    public PayItem(PayItemDetails payItemDetails, Frequency frequency, Amount amount) {
        this.payItemDetails = payItemDetails;
        this.frequency = frequency;
        this.amount = amount;
    }

    public PayItem(int id, PayItemDetails payItemDetails, Frequency frequency, Amount amount) {
        this.id = id;
        this.payItemDetails = payItemDetails;
        this.frequency = frequency;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PayItemDetails getPayItemDetails() {
        return payItemDetails;
    }

    public void setPayItemDetails(PayItemDetails payItemDetails) {
        this.payItemDetails = payItemDetails;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}

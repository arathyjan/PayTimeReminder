package com.paytimereminder.DAO;

import android.content.Context;

import com.paytimereminder.Model.PayItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class PayItemDao {
    private Realm realm;

    public PayItemDao(Context context) {
        realm = Realm.getInstance(context);
    }

    public List<PayItem> getAll() {
        realm.beginTransaction();
        RealmResults<PayItem> payItems = realm.allObjects(PayItem.class);
        realm.commitTransaction();
        return payItems;
    }

    public void create(PayItem payItem) {
        realm.beginTransaction();
        realm.copyToRealm(payItem);
//        PayItem item = realm.createObject(PayItem.class);
//        item.setPayItemDetails(payItem.getPayItemDetails());
//        item.setFrequency(payItem.getFrequency());
//        item.setAmount(payItem.getAmount());
//        item.setId(getNextKey());
        realm.commitTransaction();
    }

    public int getNextKey()
    {
        return realm.where(PayItem.class).max("id").intValue() + 1;
    }

    public PayItem find(int payItemId) {
        return realm.where(PayItem.class).equalTo("id", payItemId).findFirst();
    }
}

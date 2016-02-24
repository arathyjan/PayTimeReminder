package com.paytimereminder.Service;

import android.content.Context;

import com.paytimereminder.DAO.PayItemDao;
import com.paytimereminder.Model.PayItem;

import java.util.List;

public class PayItemService {
    private PayItemDao dao;

    public PayItemService(Context context) {
        dao = new PayItemDao(context);
    }

    public List<PayItem> getAllPayItems() {
        return dao.getAll();
    }

    public void create(PayItem payItem) {
        dao.create(payItem);
    }

    public PayItem getDetails(int payItemId) {
        return new PayItem(payItemId, "dummyname");
    }
}

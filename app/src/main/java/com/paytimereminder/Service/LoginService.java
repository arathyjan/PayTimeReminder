package com.paytimereminder.Service;

import android.content.Context;
import android.text.Editable;

import com.paytimereminder.DAO.UserDAO;

public class LoginService {
    private Context context;

    public LoginService() {
    }

    public LoginService(Context context) {
        this.context = context;
    }

    public boolean login(String username, String password) {
        return new UserDAO(context).Login(username, password);
    }
}

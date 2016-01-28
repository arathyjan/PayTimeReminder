package com.paytimereminder.Service;

import android.text.Editable;

import com.paytimereminder.DAO.UserDAO;

public class LoginService {
    public boolean login(String username, String password) {
        return new UserDAO().Login(username, password);
    }
}

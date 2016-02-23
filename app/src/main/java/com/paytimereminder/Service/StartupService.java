package com.paytimereminder.Service;

import android.content.Context;

import com.paytimereminder.DAO.UserDAO;
import com.paytimereminder.Model.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class StartupService {
    private Realm realm;
    private Context context;

    public StartupService(Context context) {
        this.context = context;
    }

    public boolean StartupActivity() {
        CreateUser();
        return true;
    }

    private void CreateUser() {
        UserDAO userDAO = new UserDAO(context);
        RealmResults<User> users = userDAO.getUsers();
        if(users.size() == 0){
            userDAO.CreateUser("test", "test");
        }
    }
}

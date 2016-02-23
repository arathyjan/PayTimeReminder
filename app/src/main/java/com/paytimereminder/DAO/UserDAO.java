package com.paytimereminder.DAO;

import android.content.Context;

import com.paytimereminder.Model.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserDAO {

    private Realm realm;

    public UserDAO() {
    }

    public UserDAO(Context context) {
        realm = Realm.getInstance(context);
    }

    public boolean Login(String username, String password)
    {
        boolean isValidLogin = false;
        RealmResults<User> users = realm.where(User.class).equalTo("username", username).equalTo("password", password).findAll();
        if(users.size() == 1)
            isValidLogin = true;
        realm.close();
        return isValidLogin;
    }

    public void CreateUser(String username, String password) {
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setUsername(username);
        user.setPassword(password);
        realm.commitTransaction();
    }

    public RealmResults<User> getUsers() {
        return realm.allObjects(User.class);
    }
}

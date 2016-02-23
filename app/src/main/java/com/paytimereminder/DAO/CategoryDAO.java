package com.paytimereminder.DAO;

import android.content.Context;

import com.paytimereminder.Model.Category;

import java.util.List;

import io.realm.Realm;

public class CategoryDAO {
    private final Realm realm;

    public CategoryDAO(Context context) {
        realm = Realm.getInstance(context);
    }

    public void addNewCategory(Category category) {
        realm.beginTransaction();
        Category realmCategory = realm.createObject(Category.class);
        realmCategory.setCategoryType(category.getCategoryType());
        realmCategory.setName(category.getName());
        realm.commitTransaction();
    }

    public List<Category> GetAllCategory() {
        return realm.allObjects(Category.class);
    }
}

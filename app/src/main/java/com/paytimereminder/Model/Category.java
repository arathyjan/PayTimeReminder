package com.paytimereminder.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Category extends RealmObject {
    @PrimaryKey
    private int categoryId;
    private String name;
    private String categoryType;

    public Category() {
    }

    public Category(int categoryId, String name, String categoryType) {
        this.categoryId = categoryId;
        this.name = name;
        this.categoryType = categoryType;
    }

    public Category(String name, String categoryType) {
        this.name = name;
        this.categoryType = categoryType;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}

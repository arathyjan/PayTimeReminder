package com.paytimereminder.Service;

import android.content.Context;

import com.paytimereminder.DAO.CategoryDAO;
import com.paytimereminder.Model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO dao;

    public CategoryService() {
    }

    public CategoryService(Context context) {
        dao = new CategoryDAO(context);
    }

    public void CreateCategory(String categoryType, String categoryName) {
        Category category = new Category(categoryName, categoryType);
        dao.addNewCategory(category);
    }

    public List<Category> GetAllCategory() {
        return dao.GetAllCategory();
    }
}

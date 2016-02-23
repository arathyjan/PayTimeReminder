package com.paytimereminder.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paytimereminder.Model.Category;
import com.paytimereminder.Model.CategoryType;
import com.paytimereminder.R;

import java.lang.reflect.Field;

public class CategoryItemListFragment extends Fragment {

    private static Category categoryItem;

    public static CategoryItemListFragment newInstance(Category category) {
        categoryItem = category;
        return new CategoryItemListFragment();
    }

    public CategoryItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CategoryType categoryType = CategoryType.valueOf(categoryItem.getCategoryType());
        Class<R.layout> aClass = R.layout.class;
        String testString = "fragment_category_item_list";
        int id = 1;
        try {
            Field field = aClass.getField(testString);
            id = field.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return inflater.inflate(R.layout.fragment_category_item_list, container, false);
    }
}

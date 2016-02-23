package com.paytimereminder.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class CategoryListAdapter extends ArrayAdapter {
    public CategoryListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }
}

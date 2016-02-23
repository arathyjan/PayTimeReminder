package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.paytimereminder.Adapter.CategoryListAdapter;
import com.paytimereminder.Model.Category;
import com.paytimereminder.R;
import com.paytimereminder.Service.CategoryService;

import java.util.List;

public class CategoryListFragment extends Fragment {

    private FloatingActionButton addNewFloatingButton;
    private List<Category> categoryDetails;

    public static Fragment newInstance() {
        return new CategoryListFragment();
    }

    public CategoryListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView categoryList = (ListView) view.findViewById(R.id.CategoryList);
        categoryDetails = new CategoryService(getContext()).GetAllCategory();
        categoryList.setAdapter(new CategoryListAdapter(getContext(), android.R.layout.simple_list_item_1, categoryDetails));
        categoryList.setOnItemClickListener(categoryListClickListener);

        addNewFloatingButton = (FloatingActionButton) view.findViewById(R.id.addNew);
        addNewFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            LoadCreateNewCategoryFragment();
            }
        });
    }

    private void LoadCreateNewCategoryFragment() {
        Fragment fragment = AddNewCategoryFragment.newInstance();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainContainer, fragment)
                .commit();
    }


    AdapterView.OnItemClickListener categoryListClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment = CategoryItemListFragment.newInstance(categoryDetails.get(position));
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainContainer, fragment)
                    .commit();
        }
    };
}

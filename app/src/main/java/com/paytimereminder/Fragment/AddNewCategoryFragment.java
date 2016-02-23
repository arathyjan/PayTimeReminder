package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.paytimereminder.Adapter.CategoryAdapter;
import com.paytimereminder.Model.CategoryType;
import com.paytimereminder.R;
import com.paytimereminder.Service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class AddNewCategoryFragment extends Fragment {

    private AdapterView.OnItemClickListener itemClickListener;
    private TextView selectedCategory;
    private EditText categoryName;

    public static Fragment newInstance() {
        return new AddNewCategoryFragment();
    }

    public AddNewCategoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) view.findViewById(R.id.list);
        selectedCategory = (TextView) view.findViewById(R.id.Selectedcategory);
        categoryName = (EditText) view.findViewById(R.id.NewCategory);
        List<String> typeList = new ArrayList<>();
        for(CategoryType type : CategoryType.values()){
            typeList.add(type.toString());
        }
        listView.setAdapter(new CategoryAdapter(getContext(), android.R.layout.simple_list_item_1, typeList));
        listView.setOnItemClickListener(onItemClickListener);

        Button createNewcategoryButton = (Button) view.findViewById(R.id.NewCategoryAddButton);
        createNewcategoryButton.setOnClickListener(newCategoryButtonClick);
    }

    View.OnClickListener newCategoryButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new CategoryService(getContext()).CreateCategory(selectedCategory.getText().toString(), categoryName.getText().toString());
            Fragment fragment = CategoryListFragment.newInstance();
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainContainer, fragment)
                    .commit();
        }
    };

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectedCategory.setText(((AppCompatTextView) view).getText());
        }
    };
}
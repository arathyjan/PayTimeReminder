package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.paytimereminder.Model.PayItem;
import com.paytimereminder.R;
import com.paytimereminder.Service.PayItemService;

import java.util.List;

public class PayItemListFragment extends Fragment {

    private List<PayItem> payItems;

    public static PayItemListFragment newInstance() {
        return new PayItemListFragment();
    }

    public PayItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_item_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createPayItemList(view);
        createAddNewPayItemButton(view);
    }

    private void createAddNewPayItemButton(View view) {
        FloatingActionButton addNewFloatingButton = (FloatingActionButton) view.findViewById(R.id.addNewPayItem);
        addNewFloatingButton.setOnClickListener(floatingButtonClickAction);
    }

    private void createPayItemList(View view) {
        ListView payItemList = (ListView) view.findViewById(R.id.listView);
        payItems = new PayItemService(getContext()).getAllPayItems();
        payItemList.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, payItems));
        payItemList.setOnItemClickListener(categoryListClickListener);
    }

    View.OnClickListener floatingButtonClickAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = AddNewPayItem.newInstance();
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    };

    AdapterView.OnItemClickListener categoryListClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment = PayItemDetails.newInstance();
            Bundle args = new Bundle();
            args.putInt(PayItemDetails.ID, payItems.get(position).getId());
            fragment.setArguments(args);
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MainContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    };

}

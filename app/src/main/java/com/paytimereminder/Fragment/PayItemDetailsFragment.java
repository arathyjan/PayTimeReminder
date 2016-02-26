package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paytimereminder.Model.PayItem;
import com.paytimereminder.R;
import com.paytimereminder.Service.PayItemService;

public class PayItemDetailsFragment extends Fragment {

    public static String ID = "id";
    private int payItemId;

    public static PayItemDetailsFragment newInstance() {
        return new PayItemDetailsFragment();
    }

    public PayItemDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_item_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PayItem item = new PayItemService(getContext()).getDetails(payItemId);

        TextView detailsIdTextView = (TextView) view.findViewById(R.id.detailsId);
        detailsIdTextView.setText(String.valueOf(item.getId()));

        TextView detailsNameTextView = (TextView) view.findViewById(R.id.detailsName);
        detailsNameTextView.setText(item.getPayItemDetails().getName());
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) payItemId = args.getInt(ID);
    }
}

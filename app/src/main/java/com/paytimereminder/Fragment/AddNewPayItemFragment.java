package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.paytimereminder.Model.Amount;
import com.paytimereminder.Model.Frequency;
import com.paytimereminder.Model.PayItem;
import com.paytimereminder.Model.PayItemDetails;
import com.paytimereminder.R;
import com.paytimereminder.Service.PayItemService;

public class AddNewPayItemFragment extends Fragment {

    EditText name;

    public static AddNewPayItemFragment newInstance() {
        return new AddNewPayItemFragment();
    }

    public AddNewPayItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_pay_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button saveButton = (Button) view.findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(savePayItem);

        name = (EditText) view.findViewById(R.id.name);
    }

    private View.OnClickListener savePayItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            PayItemDetails payItemDetails = new PayItemDetails(name.getText().toString());
            Frequency frequency = new Frequency();
            Amount amount = new Amount();
            new PayItemService(getContext()).create(new PayItem(payItemDetails, frequency, amount));
            getFragmentManager().popBackStack();
        }
    };
}
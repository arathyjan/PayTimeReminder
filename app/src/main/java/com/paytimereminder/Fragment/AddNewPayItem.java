package com.paytimereminder.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.paytimereminder.Model.PayItem;
import com.paytimereminder.R;
import com.paytimereminder.Service.PayItemService;

public class AddNewPayItem extends Fragment {

    EditText name;

    public static AddNewPayItem newInstance() {
        return new AddNewPayItem();
    }

    public AddNewPayItem() {
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

            new PayItemService(getContext()).create(new PayItem(name.getText().toString()));
            getFragmentManager().popBackStack();
        }
    };
}
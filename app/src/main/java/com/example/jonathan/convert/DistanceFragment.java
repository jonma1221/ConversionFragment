package com.example.jonathan.convert;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DistanceFragment extends Fragment {
    private EditText feet;
    private EditText meters;

    public DistanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distance, container, false);
        feet = (EditText)view.findViewById(R.id.editDistanceSI);
        feet.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        feet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (feet.hasFocus()) {
                    if (feet.getText().toString().length() == 0) {
                        meters.setText("");
                        return;
                    }
                    double units = Double.parseDouble(feet.getText().toString());
                        meters.setText("" + units / 3.2808);
                    }
                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        meters = (EditText)view.findViewById(R.id.editDistanceMetric);
        meters.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(meters.hasFocus()) {
                    if(meters.getText().toString().length() == 0) {
                        feet.setText("");
                        return;
                    }
                    double units = Double.parseDouble(meters.getText().toString());


                        feet.setText("" + units * 3.2808);
                    }
                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

}

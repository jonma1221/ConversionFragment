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
public class WeightFragment extends Fragment {
    private EditText lb;
    private EditText kg;

    public WeightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_weight, container, false);
            lb = (EditText)view.findViewById(R.id.editWeightSI);
            lb.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            lb.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (lb.hasFocus()) {
                        if (lb.getText().toString().length() == 0) {
                            kg.setText("");
                            return;
                        }
                        double units = Double.parseDouble(lb.getText().toString());

                        kg.setText("" + units / 2.2046);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            kg = (EditText)view.findViewById(R.id.editWeightMetric);
            kg.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (kg.hasFocus()) {
                        if (kg.getText().toString().length() == 0) {
                            lb.setText("");
                            return;
                        }
                        double units = Double.parseDouble(kg.getText().toString());

                        lb.setText("" + units * 2.2046);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        return view;
    }

}

package com.example.fragmentprojectpractise;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add extends Fragment {

    public DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        myDB = new DatabaseHelper(this.getActivity());
        View  v = inflater.inflate(R.layout.fragment_add, container, false);

        EditText PRODUCT_ID, PRODUCT_NAME, PRODUCT_EXPIRATION, PRODUCT_MANUFACTURER, PRODUCT_QUANTITY, PRODUCT_PRICE, PRODUCT_COST, PRODUCT_DESCRIPTION;

        Button BtnAdds = (Button)v.findViewById(R.id.BtnAdds);

        PRODUCT_ID = (EditText) v.findViewById(R.id.ProId);
        PRODUCT_NAME = (EditText) v.findViewById(R.id.ProName);
        PRODUCT_EXPIRATION = (EditText) v.findViewById(R.id.ProType);
        PRODUCT_MANUFACTURER = (EditText) v.findViewById(R.id.ProMan);
        PRODUCT_QUANTITY = (EditText) v.findViewById(R.id.ProPua);
        PRODUCT_PRICE = (EditText) v.findViewById(R.id.ProPrice);
        PRODUCT_COST = (EditText) v.findViewById(R.id.ProCost);
        PRODUCT_DESCRIPTION = (EditText) v.findViewById(R.id.ProDisc);



        BtnAdds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = myDB.insertData(
                        PRODUCT_ID.getText().toString(),
                        PRODUCT_NAME.getText().toString(),
                        PRODUCT_EXPIRATION.getText().toString(),
                        PRODUCT_MANUFACTURER.getText().toString(),
                        PRODUCT_QUANTITY.getText().toString(),
                        PRODUCT_PRICE.getText().toString(),
                        PRODUCT_COST.getText().toString(),
                        PRODUCT_DESCRIPTION.getText().toString());

                if (inserted = true) {
                    Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}

package com.example.fragmentprojectpractise;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Mod extends Fragment {

    public DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mod, container, false);

        Button btnSearch = (Button)v.findViewById(R.id.btnSearch);
        EditText Search_PRODUCT_ID = (EditText) v.findViewById(R.id.SearchID);

        EditText PRODUCT_ID, PRODUCT_NAME , PRODUCT_EXPIRE , PRODUCT_MANUFACTURER , PRODUCT_QUANTITY , PRODUCT_PRICE , PRODUCT_COST , PRODUCT_DESCRIPTION;


        Button btnMod = (Button)v.findViewById(R.id.btnModi);
        PRODUCT_ID = (EditText) v.findViewById(R.id.ProId);
        PRODUCT_NAME = (EditText) v.findViewById(R.id.ProName);
        PRODUCT_EXPIRE = (EditText) v.findViewById(R.id.ProType);
        PRODUCT_MANUFACTURER = (EditText) v.findViewById(R.id.ProMan);
        PRODUCT_QUANTITY = (EditText) v.findViewById(R.id.ProPua);
        PRODUCT_PRICE = (EditText) v.findViewById(R.id.ProPrice);
        PRODUCT_COST = (EditText) v.findViewById(R.id.ProCost);
        PRODUCT_DESCRIPTION = (EditText) v.findViewById(R.id.ProDisc);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB = new DatabaseHelper(getActivity());
                Cursor res = myDB.detAllData();

                while (res.moveToNext()){
                    // Toast.makeText(getApplicationContext(),"ID" + res.getString(0).toString() +" - " + ID.getText().toString() ,Toast.LENGTH_SHORT).show();
                    if (res.getString(1).toString().equalsIgnoreCase(Search_PRODUCT_ID.getText().toString()))
                    {
                        // Toast.makeText(getApplicationContext(),"if test" ,Toast.LENGTH_SHORT).show();
                        PRODUCT_ID.setText(res.getString(1));
                        PRODUCT_NAME.setText(res.getString(2));
                        PRODUCT_EXPIRE.setText(res.getString(3));
                        PRODUCT_MANUFACTURER.setText(res.getString(4));
                        PRODUCT_QUANTITY.setText(res.getString(5));
                        PRODUCT_PRICE.setText(res.getString(6));
                        PRODUCT_COST.setText(res.getString(7));
                        PRODUCT_DESCRIPTION.setText(res.getString(8));
                    }
                }
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB = new DatabaseHelper(getActivity());
                boolean isUpdate = myDB.updateData(PRODUCT_ID.getText().toString(),
                        PRODUCT_NAME.getText().toString(),
                        PRODUCT_EXPIRE.getText().toString(),
                        PRODUCT_MANUFACTURER.getText().toString(),
                        PRODUCT_QUANTITY.getText().toString(),
                        PRODUCT_PRICE.getText().toString(),
                        PRODUCT_COST.getText().toString(),
                        PRODUCT_DESCRIPTION.getText().toString());

                if (isUpdate = true){
                    Toast.makeText(getActivity(),"Data updated",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Data not updated",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;

    }
}

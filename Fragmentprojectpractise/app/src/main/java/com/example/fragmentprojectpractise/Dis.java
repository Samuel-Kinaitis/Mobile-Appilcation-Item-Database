package com.example.fragmentprojectpractise;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Dis extends Fragment {
    public DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        ListView l;

        View v = inflater.inflate(R.layout.fragment_dis, container, false);
        l = (ListView) v.findViewById(R.id.lDis);

        // Inflate the layout for this fragment
        myDB = new DatabaseHelper(this.getActivity());


//        String[] values = new String[] { "Tennis","Volleyball","Snooker"};

        Cursor res = myDB.detAllData();

        List<String> mStrings = new ArrayList<String>();
        mStrings.add( " ID " + " - " + "Name " + " - " + "Expiration" + " - " +  "Manufacturer" + " - " +  "Quantity" + " - " +  "Price" + " - " +  "Cost" + " - " +  "Description"+ "\n");

        while (res.moveToNext()){
            mStrings.add( res.getString(0) + " - " +
                    res.getString(1) + " - " +
                    res.getString(2) + " - " +
                    res.getString(3) + " - " +
                    res.getString(4) + " - " +
                    res.getString(5) + " - " +
                    res.getString(6) + " - " +
                    res.getString(7) + " - " +
                    res.getString(8) + "\n");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, mStrings);
        l.setAdapter(adapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                String message = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}

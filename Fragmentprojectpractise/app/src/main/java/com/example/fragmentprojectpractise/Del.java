package com.example.fragmentprojectpractise;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Del extends Fragment {

    public DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_del, container, false);
        myDB = new DatabaseHelper(this.getActivity());
        EditText DelID;
        Button BtnDelete;

        DelID = (EditText)v.findViewById(R.id.DelID);
        BtnDelete = (Button)v.findViewById(R.id.BtnDelete);

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB = new DatabaseHelper(getActivity());
                int deleted =  myDB.deleteData(DelID.getText().toString());
                if (deleted > 0){
                    Toast.makeText(getActivity(),"Data deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Data not deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }
}

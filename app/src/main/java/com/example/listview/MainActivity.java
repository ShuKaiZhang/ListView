package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button addButton;
    EditText addEditText;
    List<HashMap<String, String>> unitListArray;
    SimpleAdapter myListAdapter;
    ListView unitList;
    HashMap<String, String> map = new HashMap<String, String>();
    String[] colHEAD = new String[]{"CODE", "UNITS", "SEMESTER"};
    int[] dataCell = new int[]{R.id.UnitCode, R.id.UnitName, R.id.Semester};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = this.findViewById(R.id.addButton);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String newUnit = addEditText.getText().toString();
                if (!newUnit.equals("")) {
                    String[] unitsArray = newUnit.split(",");
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("CODE", unitsArray[0] + " ");
                    map.put("UNITS", unitsArray[1] + " ");
                    map.put("SEMESTER", unitsArray[2] + " ");
                    addMap(map);
                } else {
                    Toast.makeText(getApplicationContext(), "ENTER TEXT FIRST", Toast.LENGTH_LONG).show();
                }

            }
        });
        addEditText = this.findViewById(R.id.addEditText);
        unitList = this.findViewById(R.id.list_view);
        unitListArray = new ArrayList<HashMap<String, String>>();
        map.put("CODE", "FIT5046 ");
        map.put("UNITS", "Mobile and distributed Computing ");
        map.put("SEMESTER", "Sem1 2019 ");
        unitListArray.add(map);
        map.put("CODE", "FIT5032 ");
        map.put("UNITS", "Web App ");
        map.put("SEMESTER", "Sem2 2019 ");
        unitListArray.add(map);

        myListAdapter = new SimpleAdapter(this, unitListArray, R.layout.list_view, colHEAD, dataCell);
        unitList.setAdapter(myListAdapter);
    }

    protected void addMap(HashMap map) {
        unitListArray.add(map);
        myListAdapter = new SimpleAdapter(this, unitListArray, R.layout.list_view, colHEAD, dataCell);
        unitList.setAdapter(myListAdapter);
    }
}

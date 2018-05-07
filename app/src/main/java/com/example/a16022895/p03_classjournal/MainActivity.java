package com.example.a16022895.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(new Modules("Android Programming II" , "C357"));

        // Create the ArrayAdapter object.
        moduleAdapter adapter = new moduleAdapter(this, R.layout.list_item, modulesList);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);


    }
}

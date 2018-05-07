package com.example.a16022895.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Modules> modulesList = new ArrayList<>();
        modulesList.add(new Modules("Android Programming II" , "C357"));

        // Create the ArrayAdapter object.
        moduleAdapter adapter = new moduleAdapter(this, R.layout.list_item, modulesList);
        final ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = lv.getPositionForView(view);
                Modules module = new Modules(modulesList.get(pos).getModuleName(), modulesList.get(pos).getModuleCode());
                Intent i = new Intent(MainActivity.this, DG.class);
                i.putExtra("module", module);
                startActivity(i);
            }
        });

    }
}

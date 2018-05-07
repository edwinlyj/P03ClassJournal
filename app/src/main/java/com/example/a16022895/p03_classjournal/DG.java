package com.example.a16022895.p03_classjournal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DG extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> dailyGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dg);

        dailyGrades = new ArrayList<DailyGrade>();
        lv = (ListView) this.findViewById(R.id.dg);
        aa = new DGAdapter(this, R.layout.row, dailyGrades);
        lv.setAdapter(aa);
        
    }
}

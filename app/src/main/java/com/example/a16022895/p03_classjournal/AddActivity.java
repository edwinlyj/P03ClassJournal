package com.example.a16022895.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView week;
    RadioGroup rgGrade;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        week = findViewById(R.id.tvWeek);
        rgGrade = findViewById(R.id.rgGrades);
        btnSubmit = findViewById(R.id.btnSubmit);
        Intent i = getIntent();
        final int weeks = i.getIntExtra("count",-1);
        int finalWk = weeks + 1;
        week.setText("Week " + finalWk);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                int selectedRB = rgGrade.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedRB);
                i.putExtra("grade", rb.getText().toString());
                i.putExtra("week", weeks + 1);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}

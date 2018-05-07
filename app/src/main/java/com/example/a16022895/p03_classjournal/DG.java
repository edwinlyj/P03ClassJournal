package com.example.a16022895.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DG extends AppCompatActivity {

    Button btnAdd;
    int requestcodeforadd = 1;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyGrade> dailyGrades;
    Button btnRP;
    Button btnEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dg);


        btnRP = (Button) findViewById(R.id.buttonInfo);
        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmails = (Button) findViewById(R.id.buttonEmail);
        btnEmails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");

                String message = "Hi Faci,\nI am ...\nPlease see my remarks so far, Thank you!\n\n";
                for (int i = 0; i < dailyGrades.size(); i++){
                    message += "Week " + dailyGrades.get(i).getWeek() + ": DG:" + dailyGrades.get(i).getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
        dailyGrades = new ArrayList<DailyGrade>();
        dailyGrades.add(new DailyGrade("1" , "A"));
        lv = (ListView) this.findViewById(R.id.dg);
        aa = new DGAdapter(this, R.layout.row, dailyGrades);
        lv.setAdapter(aa);



        btnAdd = findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DG.this, AddActivity.class);
                i.putExtra("count", dailyGrades.size());
                startActivityForResult(i, requestcodeforadd);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                String grade = data.getStringExtra("grade");
                int week = data.getIntExtra("week", -1);
                if(requestCode == requestcodeforadd){
                    DailyGrade item = new DailyGrade(week + "", grade);
                    dailyGrades.add(item);
                    lv.setAdapter(aa);
                }
            }
        }

    }
}

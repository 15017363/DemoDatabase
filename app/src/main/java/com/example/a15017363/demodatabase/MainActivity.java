package com.example.a15017363.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    Button btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayList<Task> taskArrayList;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnGetTasks = (Button)findViewById(R.id.btnGetTasks);
        tvResults = (TextView)findViewById(R.id.tvResults);
        lv = (ListView)findViewById(R.id.lv);




        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the
                //activity's context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                ArrayList<Task> data1 = db.getTasks();
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);
                aa = new TaskAdaptor(MainActivity.this, R.layout.row, data1);
                lv.setAdapter(aa);

            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the
                //activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                db.insertTask("Submit RJ","25 Apr 2016");
                db.close();
            }
        });


    }
}

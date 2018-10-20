package com.example.listviewidan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    double num, d, sum=0.0;
    double numbers[] = new double[20];
    String st2[] = new String[20];
    ListView lv;
    int tt2;
    TextView tv1, tv2, tv3, tv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        lv = (ListView) findViewById(R.id.lv);

        Intent kabala = getIntent();
        tt2 = kabala.getIntExtra("tt2", 9999);
        num = kabala.getDoubleExtra("num", 99999);
        d = kabala.getDoubleExtra("D", 9999);

        numbers[0] = num;
        st2[0] = "" + num;
        if (tt2 == 1) {
            for (int j = 1; j < 20; j++) {
                numbers[j] = d + numbers[j - 1];
                st2[j] = "" + numbers[j];
            }
        }
        else {
            for (int j = 1; j < 20; j++) {
                numbers[j] = d * numbers[j - 1];
                st2[j] = "" + numbers[j];
            }
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, st2);
        lv.setAdapter(adp);



    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        sum=0.0;
        for (int j = 0; j < position; j++){
            sum = sum + numbers[j];
        }

        tv1.setText("" + num);
        tv2.setText("" +d);
        tv3.setText("" + position);
        tv4.setText("" + sum);


    }
}
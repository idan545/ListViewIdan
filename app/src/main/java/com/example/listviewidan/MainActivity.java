package com.example.listviewidan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int f1;
    EditText et1,et2;
    RadioButton rb1,rb2;
    Intent l1;
    String st1;
    Button btn;
    Double num, n2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn = (Button) findViewById(R.id.btn);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
    }

    public void Move(View view) {
        st1 = et1.getText().toString();
        num = Double.parseDouble(st1);
        st1 = et2.getText().toString();
        n2 = Double.parseDouble(st1);
        if(rb1.isChecked()){
            f1=1;
        }
        if(rb2.isChecked()){
            f1=2;
        }
        l1 = new Intent(this, Main2Activity.class);
        l1.putExtra("f1" , f1);
        l1.putExtra("num", num);
        l1.putExtra("n2", n2);
        startActivity(l1);

    }
}
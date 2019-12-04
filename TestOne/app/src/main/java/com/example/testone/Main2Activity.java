package com.example.testone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText ed1,ed2,ed3,ed4;
    Spinner sp;
    RadioGroup rg1;
    RadioButton rb1,rb2;
    CheckBox cb1,cb2;
    Button btn;
    TextView wel;
    ArrayList<String> selcourse = new ArrayList<>();
    String course="";
    int [] fee = {1300, 1500, 1350, 1400, 1000};
    int [] hours = {6,5,5,7,4};
double fee1;
int hours1;
 int   totHrs;
int singleHrs;
  int  totFee;
  int  singleFee;
  int tv_totCrsFee;
  int tv_totCrsHrs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String  name =  getIntent().getStringExtra("studentName");
        wel=findViewById(R.id.welview);
        wel.setText("Welcome "+name);

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        ed3 = findViewById(R.id.tottaledit);
ed4 = findViewById(R.id.editText3);

        sp = findViewById(R.id.spinner);
        rg1 = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.grad);
        rb2 = findViewById(R.id.undergrad);
        cb1 = findViewById(R.id.acccb);
        cb2 = findViewById(R.id.medcb);
        btn = findViewById(R.id.addbt);


        List<String> course = new ArrayList<>();
        course.add("Java");
        course.add("Swift");
        course.add("iOS");
        course.add("Android");
        course.add("Database");

        ArrayAdapter<String> proAdapter= new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,course);
        proAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(proAdapter);
        sp.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        fee1 = new Double(fee[i]);
        ed1.setText(String.valueOf(fee1));

        hours1 = new Integer(hours[i]);
        ed2.setText(String.valueOf(hours1));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    @Override
    public void onClick(View view)
    {

        if(selcourse.contains(course)){
            Toast.makeText(Main2Activity.this, "Already ADDED", Toast.LENGTH_SHORT).show();
            return;
        }
        if(rb1.isChecked()){
            int total =  totHrs + singleHrs;
            if(total > 21){
                Toast.makeText(Main2Activity.this, "Cannot select more", Toast.LENGTH_SHORT).show();
                return;
            }
        }else{
            int total =  totHrs + singleHrs;
            if(total > 19){
                Toast.makeText(Main2Activity.this, "Cannot select more", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        selcourse.add(course);
        totFee = totFee + singleFee;
        totHrs = totHrs + singleHrs;

        ed3.setText(totFee +"");
        ed4.setText(totHrs+"");

    }



}

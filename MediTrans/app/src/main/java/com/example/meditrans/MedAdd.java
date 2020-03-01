package com.example.meditrans;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public class MedAdd extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5;
    RadioGroup rg;
    RadioButton rba,rbb;
    Button b ;
    SharedPreferences sharedPreferences;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_add);
        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        userid = sharedPreferences.getString("USER",null);
        et1=findViewById(R.id.mename);
        et2=findViewById(R.id.mecode);
        et3=findViewById(R.id.mecost);
        et4=findViewById(R.id.meshop);
        et4.setText(userid);
        et4.setEnabled(false);
        et5=findViewById(R.id.medes);
        rg=findViewById(R.id.radioGroup);
        rba=findViewById(R.id.rbuttonc);
        rbb=findViewById(R.id.rbuttond);
        b=findViewById(R.id.bj);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String medname = et1.getText().toString();
                String medcode = et2.getText().toString();
                String medcost = et3.getText().toString();
                String medshop=et4.getText().toString();
                String meddes=et5.getText().toString();

                if(medname.equals("")&&medcode.equals("")&&medcost.equals("")&&medshop.equals("")&&meddes.equals("")){
                    et1.setError("Not Empty");
                    et2.setError("Not Empty");
                    et3.setError("Not Empty");
                    et4.setError("Not Empty");
                    et5.setError("Not Empty");

                }else{
                    int selectedId=rg.getCheckedRadioButtonId();
                    rba=(RadioButton)findViewById(selectedId);
                    //            supload();
                }
            }


        });
    }

}

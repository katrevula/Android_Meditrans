package com.example.meditrans;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class MedReg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    RadioGroup r1;
    RadioButton rb1,rb2;
    Button b1;
    TextView t1;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_reg);
        e1=findViewById(R.id.sn);
        e2=findViewById(R.id.ui);
        e3=findViewById(R.id.p);
        e4=findViewById(R.id.son);
        e5=findViewById(R.id.mn);
        e6=findViewById(R.id.sa);
        e7=findViewById(R.id.lc);
        e8=findViewById(R.id.t);
        e9=findViewById(R.id.e);
        r1=findViewById(R.id.rg);
        rb1=findViewById(R.id.rba);
        rb2=findViewById(R.id.rbb);
        b1=findViewById(R.id.bi);
        t1=findViewById(R.id.btb);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.sn,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.ui,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), Medico.class);
                startActivity(a);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(getApplicationContext(), Medico.class);
                startActivity(a);



            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_dots, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.shome:
                Intent i =new Intent(getApplicationContext(),MediTrans.class);
                startActivity(i);
                return true;
            case R.id.about:
                i =new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.contact:
                i =new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void submitform()
    {
        if(awesomeValidation.validate())
        {
            supload();
        }
    }
    private void supload() {
        try {
        } catch (Exception e) {
            Log.e("ERROR", " Enter valid details");
        }
    }
    public static boolean hasPermissions(Context context, String... permissions)
    {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null)
        {
            for (String permission : permissions)
            {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.example.meditrans;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Medico extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    TextView t1;
    SharedPreferences sharedPreferences;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);
        firebaseAuth = FirebaseAuth.getInstance();

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.INTERNET,Manifest.permission.CALL_PHONE,Manifest.permission.ACCESS_NETWORK_STATE};

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        e1 = findViewById(R.id.uid);
        e2 = findViewById(R.id.pass);
        b1 = findViewById(R.id.bc);
        t1 = findViewById(R.id.rega);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MedReg.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(e1.getText().toString(), e2.getText().toString()).addOnCompleteListener(Medico.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {

                            Toast.makeText(Medico.this, "Failed to login", Toast.LENGTH_SHORT).show();
                        } else {

                            startActivity(new Intent(Medico.this, MedHome.class));
                        }

                    }
                });

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
        // Handle item selection
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent i0 =new Intent(getApplicationContext(),MediTrans.class);
                startActivity(i0);
                return true;
            case R.id.shome:
                Intent i =new Intent(getApplicationContext(),MediTrans.class);
                startActivity(i);
                return true;
            case R.id.about:
                Intent i1  =new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i1);
                return true;
            case R.id.contact:
                Intent i2  =new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;

    }



}

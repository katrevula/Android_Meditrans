package com.example.meditrans;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MedReg extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9;
    RadioGroup r1;
    RadioButton rb1, rb2;
    Button b1;
    TextView t1;

    private AwesomeValidation awesomeValidation;

    FirebaseAuth mFirebaseAuth;
    DatabaseReference databaseReference;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_reg);
        e1 = findViewById(R.id.shopName);
        e2 = findViewById(R.id.userName);
        e3 = findViewById(R.id.password);
        e4 = findViewById(R.id.ownerName);
        e5 = findViewById(R.id.phone);
        e6 = findViewById(R.id.shopAddress);
        e7 = findViewById(R.id.location);
        e8 = findViewById(R.id.time);
        e9 = findViewById(R.id.email);
        r1 = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rba);
        rb2 = findViewById(R.id.rbb);
        b1 = findViewById(R.id.bi);
        t1 = findViewById(R.id.btb);
        mFirebaseAuth = FirebaseAuth.getInstance();
        database.getReference("messages/users");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.shopName,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);


        awesomeValidation.addValidation(this, R.id.userName,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.ownerName,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        awesomeValidation.addValidation(this, R.id.phone,
                "^[6-9]{1}[0-9]{9}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.location,
                "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        awesomeValidation.addValidation(this, R.id.email,
                Patterns.EMAIL_ADDRESS, R.string.nameerror);

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

                String uName = e9.getText().toString();
                String pwd = e3.getText().toString();
                mFirebaseAuth.createUserWithEmailAndPassword(uName, pwd)
                        .addOnCompleteListener(MedReg.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(MedReg.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                } else {
                                    String shopName = e1.getText().toString();
                                    String userName = e2.getText().toString();
                                    String password = e3.getText().toString();
                                    String ownerName = e4.getText().toString();
                                    String phone = e5.getText().toString();
                                    String email = e6.getText().toString();
                                    String shopAddress = e7.getText().toString();
                                    String location = e8.getText().toString();
                                    String time = e9.getText().toString();
                                    String doorDelivery = e2.getText().toString();


                                    //getting the user-id which is same as current user
                                    String user_id = mFirebaseAuth.getCurrentUser().getUid();
                                    //connecting the database reference
                                    databaseReference = databaseReference.child(user_id);
                                    SignupDetails userData = new SignupDetails(shopName, userName, password, ownerName, phone, email, shopAddress, location, time);
                                    databaseReference.setValue(userData);
                                    Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();

                                    FirebaseAuth auth = FirebaseAuth.getInstance();
                                    FirebaseUser user = auth.getCurrentUser();

                                    user.sendEmailVerification()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Log.d("", "Email sent.");
                                                    }
                                                }
                                            });
                                    Intent a = new Intent(getApplicationContext(), Medico.class);
                                    startActivity(a);
                                    submitform();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.shome:
                Intent i = new Intent(getApplicationContext(), MediTrans.class);
                startActivity(i);
                return true;
            case R.id.about:
                i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.contact:
                i = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void submitform() {
        if (awesomeValidation.validate()) {
            supload();
        }
    }

    private void supload() {
        try {
        } catch (Exception e) {
            Log.e("ERROR", " Enter valid details");
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

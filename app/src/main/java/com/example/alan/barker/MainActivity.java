package com.example.alan.barker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText inputName, inputBreed, inputAge, inputGender;
    private Button btnEnter,btnSwitchActivity;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        inputName = (EditText) findViewById(R.id.name);
        inputBreed = (EditText) findViewById(R.id.breed);
        inputAge = (EditText) findViewById(R.id.age);
        inputGender = (EditText) findViewById(R.id.gender);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnEnter = (Button) findViewById(R.id.btn_enter_dog);
        btnSwitchActivity = (Button) findViewById(R.id.btn_switch_activity);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = inputName.getText().toString().trim();
                String breed = inputBreed.getText().toString().trim();
                String age = inputAge.getText().toString().trim();
                String gender = inputGender.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Name of Dog!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(breed)) {
                    Toast.makeText(getApplicationContext(), "Enter breed!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(age)) {
                    Toast.makeText(getApplicationContext(), "Enter Age of Dog!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(getApplicationContext(), "Enter Gender!", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                FirebaseUser dog =  auth.getCurrentUser();
                String dogId = dog.getUid();
                Dog newDog = new Dog(name,breed, age, gender, dogId);
                DatabaseReference mRef =  database.getReference().child("Dogs").child(dogId);
                mRef.setValue(newDog);

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);




                    }
        });

        btnSwitchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchDog.class);
                startActivity(intent);

            }
        });
    }
}


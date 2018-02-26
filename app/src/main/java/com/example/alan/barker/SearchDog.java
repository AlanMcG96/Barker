package com.example.alan.barker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchDog extends AppCompatActivity {

    private EditText inputBreed;
    private Button btnSearch;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dog);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        inputBreed = (EditText) findViewById(R.id.breedForSearch);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSearch = (Button) findViewById(R.id.btn_search_dog);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchBreed = inputBreed.getText().toString().trim();



                if (TextUtils.isEmpty(searchBreed)) {
                    Toast.makeText(getApplicationContext(), "Enter breed!", Toast.LENGTH_SHORT).show();
                    return;
                }

                DatabaseReference database =  FirebaseDatabase.getInstance().getReference();
                database.child("Dogs").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);




            }
        });
    }
}


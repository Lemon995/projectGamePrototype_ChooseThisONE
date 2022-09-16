package com.example.first_project_evasheshukova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class endOfTheGame_Activity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor edit;
    String results;
    TextView tv_sp, tv_ending;
    String ending ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_the_game);

        tv_ending = findViewById(R.id.tv_ending);
        tv_sp = findViewById(R.id.tv_sp);

        sp = getSharedPreferences("sp", MODE_PRIVATE);

        Intent it = getIntent();
        results = it.getStringExtra("Result");

        if (results.length() > 0){
            tv_ending.setText("You escaped!");
            edit = sp.edit();
            edit.putString("results", results);
            edit.commit();
        }

        if (results.length() == 0){
            tv_ending.setText("You decided to stay in the house. After several weeks you died. The police found your body yet couldnt find the reason of your death");
            edit = sp.edit();
            edit.putString("results", results);
            edit.commit();

        }

        ending = sp.getString("results", "results");

        if (ending.equals("")) {
            tv_sp.setText("Last time you: Escaped!" );
        }

        else {
            tv_sp.setText("Last time you: Died!" );

        }
    }
}
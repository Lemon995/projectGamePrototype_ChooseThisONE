package com.example.first_project_evasheshukova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class endOfTheGame_Activity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor edit;

    String results;
    TextView tv_sp, tv_ending;
    String ending ="";
    ListView lv_listOfEndings;
    ArrayList<Endings> endingsAll4;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_the_game);

        tv_ending = findViewById(R.id.tv_ending);
        tv_sp = findViewById(R.id.tv_sp);

        //list//
        lv_listOfEndings = findViewById(R.id.lv_listOfEndings);
        //list//

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

        Endings firstEnding = new Endings("The true ending");
        Endings secondEnding = new Endings("The false ending");
        Endings secretEnding = new Endings("The secret ending");
        endingsAll4 = new ArrayList<>();
        endingsAll4.add(firstEnding);
        endingsAll4.add(secondEnding);
        endingsAll4.add(secondEnding);


        adapter = new Adapter(this,0,0, endingsAll4);
        lv_listOfEndings.setAdapter(adapter);

    }
}
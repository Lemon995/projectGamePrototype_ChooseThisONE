package com.example.first_project_evasheshukova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class third_room_activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton iv_closet, iv_crossbar;
    ConstraintLayout layout;
    String item = "no";
    Button bt_goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_room);

        iv_closet = findViewById(R.id.iv_closet);
        iv_closet.setOnClickListener(this);

        iv_crossbar = findViewById(R.id.iv_crossbar);
        iv_crossbar.setOnClickListener(this);
        iv_crossbar.setVisibility(View.INVISIBLE);
        iv_crossbar.setEnabled(false);
        layout = findViewById(R.id.layout);

        bt_goBack = findViewById(R.id.bt_goBack);
        bt_goBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if (iv_closet == view){
            layout.setBackgroundResource(R.drawable.closetupclose);
            iv_closet.setEnabled(false);
            iv_closet.setVisibility(View.INVISIBLE);
            iv_crossbar.setVisibility(View.VISIBLE);
            iv_crossbar.setEnabled(true);
        }

        if (iv_crossbar == view){
            iv_crossbar.setEnabled(false);
            iv_crossbar.setVisibility(View.INVISIBLE);
            Toast toast = Toast.makeText(getApplicationContext(), "I GOT THE CROSSBAR NOW I CAN ESCAPE! QUICK NO TIME TO TURN BACK!!", Toast.LENGTH_LONG);
            toast.show();
            item = "crossbar";

        }

        if (view == bt_goBack){
            Intent from3to2 = new Intent(this, second_room_activity.class);
            from3to2.putExtra("item", item);
            startActivity(from3to2);
        }


    }
}
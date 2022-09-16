package com.example.first_project_evasheshukova;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnFirstRug, door;
    int timesClickedRug = 0;
    int timesClickedDoor = 0;
    String keyItem = "";

    private int sec = 0;
    private boolean is_running;
    private boolean was_running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirstRug = (ImageButton) findViewById(R.id.btnFirstRug);
        btnFirstRug.setOnClickListener(this);
        door = (ImageButton) findViewById(R.id.door);
        door.setOnClickListener(this);

        Intent newIntent = getIntent();
        String ok2 = newIntent.getStringExtra("back");

        if("back".equals(ok2)){
            btnFirstRug.setBackgroundResource(R.drawable.secondrug);
            door.setBackgroundResource(R.drawable.fristdoorsecondphase);
            btnFirstRug.setEnabled(false);
            keyItem = "key";
            timesClickedDoor = 1;
        }

    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, second_room_activity.class);

        if (view == btnFirstRug) {
               btnFirstRug.setBackgroundResource(R.drawable.secondrugwithkey);
               timesClickedRug += 1;
                 is_running = true;
        }

        if (timesClickedRug == 2){
            btnFirstRug.setEnabled(false);
            btnFirstRug.setBackgroundResource(R.drawable.secondrug);
            Toast toast = Toast.makeText(getApplicationContext(),"you picked the key!",Toast.LENGTH_SHORT);
            toast.show();
            timesClickedRug = -999;
            keyItem = "key";
        }

        if (view == door && keyItem == "key"){
            door.setBackgroundResource(R.drawable.fristdoorsecondphase);
            timesClickedDoor++;
        }

        if (timesClickedDoor == 2){
            startActivity(it);
        }
    }
}
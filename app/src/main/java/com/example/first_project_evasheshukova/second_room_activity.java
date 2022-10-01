package com.example.first_project_evasheshukova;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

public class second_room_activity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_deadge;
    ImageButton ib_door_two, ib_window;
    Button bt_goBack;
    String cantGoBack = "";
    String isCrossbar;
    String endOfTheGameResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_room);

        iv_deadge = findViewById(R.id.iv_deadge);
        iv_deadge.setOnClickListener(this);

        ib_door_two = findViewById(R.id.ib_door_two);
        ib_door_two.setOnClickListener(this);

        bt_goBack = findViewById(R.id.bt_goBack);
        bt_goBack.setOnClickListener(this);

        Intent newIntent = getIntent();
        isCrossbar = newIntent.getStringExtra("item");
        if(isCrossbar != null && isCrossbar.equals("crossbar")){

            ib_door_two.setEnabled(false);
            bt_goBack.setEnabled(false);
            cantGoBack = "no time for searching";
        }

        ib_window = findViewById(R.id.ib_window);
        ib_window.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        Intent from2To3 = new Intent(this, third_room_activity.class);
        Toast iNeedItem = Toast.makeText(getApplicationContext(),"I need to find something to break this window", Toast.LENGTH_SHORT);

        if (iv_deadge == view){
            Toast toast = Toast.makeText(getApplicationContext(),"IS THAT A DEAD BODY???!!!", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (ib_door_two == view && !cantGoBack.equals("no time for searching")){
            startActivity(from2To3);
        }


        if (view == bt_goBack && !cantGoBack.equals("no time for searching")){
            Intent from2To1 = new Intent(this, MainActivity.class);
            from2To1.putExtra("back", "back");
            startActivity(from2To1);
        }

        if (isCrossbar!=null && ib_window == view && isCrossbar.equals("crossbar")){
            ib_window.setBackgroundResource(R.drawable.brokenwindow);
            dialog.setTitle("Escape?");
            dialog.setMessage("Are you sure you want to escape?");

            Intent end = new Intent(this, endOfTheGame_Activity.class);

            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    endOfTheGameResult = "You escaped";
                    end.putExtra("Result",endOfTheGameResult);
                    startActivity(end);
                }
            });

            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    end.putExtra("Result",endOfTheGameResult);
                    startActivity(end);

                }
            });

            AlertDialog alert = dialog.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(200, 0, 0)));

            alert.show();
            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.black));
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.black));
        }

        else {
            if (view != ib_door_two && view != iv_deadge && view != bt_goBack)
            iNeedItem.show();
        }

    }
}
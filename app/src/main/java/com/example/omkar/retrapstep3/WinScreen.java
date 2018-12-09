package com.example.omkar.retrapstep3;


import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;


public class WinScreen extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
    }


    public void winner(View view) {
        int p=get1();
        int q=get2();
        Log.e("after: ", Integer.toString(p) + " and " + Integer.toString(q));
        String texty = "PLAYER 1 !!!";
       if(p < q) texty = "PLAYER 2 !!!!";
       else if (p == q) texty = "Match tied! Good game.";
            textView1.setText(getString(R.string.years, texty));
            Toast toast = Toast.makeText(getApplicationContext(), texty, Toast.LENGTH_LONG);
            toast.show();

    }
    public void backwego(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinScreen.this, Menu.class));
            }
        });}
}
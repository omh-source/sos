// not here either lmao. you know what I mean...
package com.example.omkar.retrapstep3;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    TextView textView1;

    public void startgame(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, MainActivity.class));
            }
        });
    }

    public void showrules(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Ruleset.class));
            }
        });
    }

    public void challenge(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, smsexp.class));
            }
        });
    }

}

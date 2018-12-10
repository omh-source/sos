package com.example.omkar.retrapstep3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ruleset extends WelcomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleset);
    }
    TextView textView1;
    public void returntomenu(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ruleset.this, WelcomeActivity.class));
            }
        });}
        //this returns you to the 4 intro slides doubling as the rules

    public void reallyreturn(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ruleset.this, Menu.class));
            }
        });}
        //this returns you to the main menu
}

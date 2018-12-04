package com.example.omkar.retrapstep3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ruleset extends AppCompatActivity {

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
                startActivity(new Intent(Ruleset.this, Menu.class));
            }
        });}
}

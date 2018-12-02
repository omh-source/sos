package com.example.omkar.retrapstep3;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int score;
    public int s;
    public static char symb;
    public static String sym;
    String output;
    // globally
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //in your OnCreate() method
        textView1 = (TextView) findViewById(R.id.button03);
        //textView1.setText(sym);
        textView1.setText(getString(R.string.days, sym));
    }

    public void sendMessage(View view) {
        CharSequence text = "You selected 'S'!";
        symb = 'S';
        sym = "S";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();

        System.out.println("I TRIED :(");
        // Do something in response to button click
    }

    public void sendMessage2(View view) {
        CharSequence text = "You selected 'O'!";
        symb = 'O';
        sym = "O";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
        // Do something in response to button click
    }




    public void placesymbol(View view) {
        int duration = Toast.LENGTH_LONG;
        if (symb != 'O' && symb != 'S') {

            Toast toast = Toast.makeText(getApplicationContext(), "select s or o first.", duration);
            toast.show();
        } else {
            textView1 = (TextView) findViewById(view.getId());
            //textView1.setText(sym);
            if (!textView1.getText().equals("S") && !textView1.getText().equals("O")) {
                textView1.setText(getString(R.string.days, sym));
                Toast toast = Toast.makeText(getApplicationContext(), "success in placing..", duration);
                toast.show();
            } else {
                Toast toasty = Toast.makeText(getApplicationContext(), "Tile already full", duration);
                toasty.show();
            }



        }
        symb = 'G';


    }


}

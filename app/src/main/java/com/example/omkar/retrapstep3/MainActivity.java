package com.example.omkar.retrapstep3;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean checking;
    public int s;
    public char[] match = new char[3];
    public int[] match2 = new int[3];
    public int[] xoffset = new int[3];
    public int[] yoffset = new int [3];
    public int[][] database = new int[3][100];
    public int universal;
    public int indices;
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

    public void resetgame(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Menu.class));
            }
        });
    }


    public void showrules(View view) {
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ruleset.class));
            }
        });
    }


    public void checkmatch(View view) {
        checking = true;
        int duration = Toast.LENGTH_LONG;
        symb = 'C';
        String text = "";
        if (indices > 3) {indices=0;}

        Toast toaster = Toast.makeText(getApplicationContext(), "choose a match tile " + (indices + 1), duration);
        toaster.show();

    }



    public void placesymbol(View view) {
        int duration = Toast.LENGTH_LONG;
        String text = "Summarize failure.";
        if (symb == 'C') {if (indices < 3) {

            textView1 = (TextView) findViewById(view.getId());
            match[indices] = textView1.getText().charAt(0);
            String test = "" + match[indices];
            Log.d("buttonid=", textView1.toString());
            Log.d("tag", test);
            match2[indices] = view.getId();
            String holder = ""+ textView1.toString().charAt(textView1.toString().length() - 2);
            String holder2 = ""+ textView1.toString().charAt(textView1.toString().length() - 3);
            int i = Integer.parseInt(holder);
            int j = Integer.parseInt(holder2);
            xoffset[indices] = i;
            yoffset[indices] = j;
Log.e("offset", holder+" "+ holder2);
            database[indices][universal] = view.getId();
            indices++;
        } else {
            indices=0;
            String abs = ""+match[0]+match[1]+match[2];
            Log.d("symbols,", (abs));
            if (match[0] == 'S' && match[2] == 'S' && match[1] == 'O') {
                int already = 0;
                for (int i = 0; i < database[0].length; i++) {
                    if (match2[0] == database[0][i] && match2[1] == database[1][i] && match2[2] == database[2][i]) {
                        already++;
                    }
                }
                int count = 0;
                for (int i = 0; i < 2; i++) {
                    if ((xoffset[i] - 1 != xoffset[i+1] && xoffset[i] + 1 != xoffset[i+1] && xoffset[i] != xoffset[i+1])) {
                        if ((yoffset[i] - 1 != yoffset[i+1] && yoffset[i] + 1 != yoffset[i+1] && yoffset[i] != yoffset[i+1])) {
                           count++;
                        }
                    }
                }
              //  if (count<=1) {text="WORX!"; Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                //    toast.show();}
                    Log.i("count=",Integer.toString(count));
                Log.i("already=",Integer.toString(already));


                if (already == 1 && count == 0) {

                    text = "You just matched!";

                    universal++;
                }
                Log.i("test is ", text);
                indices = 0;

            }
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
        }


        else if (symb != 'O' && symb != 'S') {

            Toast toast = Toast.makeText(getApplicationContext(), "select s or o first.", duration);
            toast.show();
            symb = 'G';
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
            symb = 'G';


        }


    }


}

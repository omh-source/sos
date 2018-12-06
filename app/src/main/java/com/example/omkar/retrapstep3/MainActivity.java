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
    public int sure;
    public char[] match = new char[3];
    public int[] match2 = new int[3];
    public int[] xoffset = new int[3];
    public int[] yoffset = new int[3];
    public int[][] database = new int[3][100];
    public int universal;
    public int score;
    public int p1;
    public int p2;
    public String player = "P1";
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

    public void areyousure(View view) {
        sure++;
        if (sure >= 3) {
            //winscreen here
        } else {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(getApplicationContext(), "press thrice to confirm endgame", duration);
            toast.show();
        }


    }

    public void setscore(View view) {
//add a case to not overwriter players!
        if (player.equals("P1")) {
            //p1+=score;score=0;
            if(Integer.toString(view.getId()).charAt((Integer.toString(view.getId())).length() - 2) == '2') {p2+=score;}

            Log.e("socre", Integer.toString(p1) + " player 1's score");
            textView1 = (TextView) findViewById(view.getId());
            String s = textView1.getText().toString();
            if(textView1.getText().charAt(7) == '1') {
                textView1.setText(getString(R.string.player1, Integer.toString(p1)));
                Toast toast = Toast.makeText(getApplicationContext(), "score updated..", Toast.LENGTH_LONG);
                toast.show();
            }

        }
        if (player.equals("P2")) {
            //p2+=score;score=0;
            if(Integer.toString(view.getId()).charAt((Integer.toString(view.getId())).length() - 2) == '1') {p1+=score;}

                Log.e("socre", Integer.toString(p2) + " player 2's score");
                textView1 = (TextView) findViewById(view.getId());
            String s = textView1.getText().toString();
            Log.i("tryle",textView1.toString());
            if(textView1.getText().charAt(7) == '2') {
                textView1.setText(getString(R.string.player2, Integer.toString(p2)));
                Toast toast = Toast.makeText(getApplicationContext(), "score updated..", Toast.LENGTH_LONG);
                toast.show();
            }

    }}

    public void switchturn(View view) {

        if (player.equals("P1")) {player = "P2"; if(score > 0) {p1+=score; }}
        else {player = "P1";if(score > 0) {p2+=score; }}
        Toast toast = Toast.makeText(getApplicationContext(), "TURN SWITCH.", Toast.LENGTH_LONG);
        toast.show();

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
        if (indices > 3) {
            indices = 0;
        }

        Toast toaster = Toast.makeText(getApplicationContext(), "choose a match tile " + (indices + 1), duration);
        toaster.show();

    }

    public boolean checkhorizontal() {
        boolean ok = false;
        if (xoffset[0] + 1 == xoffset[1] && xoffset[1] + 1 == xoffset[2] && xoffset[0] + 2 == xoffset[2]) {
            ok = true;
        }
        if (!ok) {
            if (xoffset[0] - 1 == xoffset[1] && xoffset[1] - 1 == xoffset[2] && xoffset[0] - 2 == xoffset[2]) {
                ok = true;
            }
        }
        if (!ok) {
            if (xoffset[0] == xoffset[1] && xoffset[1] == xoffset[2]) {
                ok = true;
            }
        }
        return ok;

    }

    public boolean checkvertical() {
        boolean ok = false;
        if (yoffset[0] + 1 == yoffset[1] && yoffset[1] + 1 == yoffset[2] && yoffset[0] + 2 == yoffset[2]) {
            ok = true;
        }
        if (!ok) {
            if (yoffset[0] - 1 == yoffset[1] && yoffset[1] - 1 == yoffset[2] && yoffset[0] - 2 == yoffset[2]) {
                ok = true;
            }
        }
        if (!ok) {
            if (yoffset[0] == yoffset[1] && yoffset[1] == yoffset[2]) {
                ok = true;
            }
        }
        return ok;

    }


    public void placesymbol(View view) {
        int duration = Toast.LENGTH_LONG;
        String text = "Summarize failure.";
        if (symb == 'C') {
            if (indices < 3) {

                textView1 = (TextView) findViewById(view.getId());
                if (textView1 == null || textView1.getText().length() <= 0) {
                    return;
                }
                match[indices] = textView1.getText().charAt(0);
                String test = "" + match[indices];
                Log.d("buttonid=", textView1.toString());
                Log.d("tag", test);
                match2[indices] = view.getId();
                String holder = "" + textView1.toString().charAt(textView1.toString().length() - 2);
                String holder2 = "" + textView1.toString().charAt(textView1.toString().length() - 3);
                int i = Integer.parseInt(holder);
                int j = Integer.parseInt(holder2);
                xoffset[indices] = i;
                yoffset[indices] = j;
                Log.e("offset", holder + " " + holder2);
                database[indices][universal] = view.getId();
                indices++;
            } else {
                indices = 0;
                String abs = "" + match[0] + match[1] + match[2];
                Log.d("symbols,", (abs));
                if (match[0] == 'S' && match[2] == 'S' && match[1] == 'O') {
                    int already = 0;
                    for (int i = 0; i < 50; i++) {
                        if ((match2[0] == database[0][i] || match2[0] == database[2][i])
                                && match2[1] == database[1][i] && (match2[2] == database[2][i]
                                || match2[2] == database[0][i])) {
                            already++;
                        }// have we matched before?
                    }
                    int count = 1;
                    //what you should do here:
                    // you've combined all criterai. break them into
                    // vert, hor and dia. that solves this ;)

                    if (checkhorizontal() && checkvertical()) {
                        count = 0;
                    }

                /*
                for (int i = 0; i < 2; i++) {
                    if ((xoffset[i] - 1 != xoffset[i+1] && xoffset[i] + 1 != xoffset[i+1] && xoffset[i] != xoffset[i+1])) {
                        if ((yoffset[i] - 1 != yoffset[1] && yoffset[i] + 1 != yoffset[1] && yoffset[i] != yoffset[i+1])) {
                           count++;
                        }// are you straight?
                    }
                }//lmao these jokes
                */
                    //  if (count<=1) {text="WORX!"; Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    //    toast.show();}
                    Log.i("count=", Integer.toString(count));
                    Log.i("already=", Integer.toString(already));
                    if (count != 0) {
                        text = "Invalid tile(s) chosen";
                    }
                    if (already != 1) {
                        text = "dont' repeat matches!";
                    }

                    if (already == 1 && count == 0) {

                        text = "You just matched!";
                        if (player.charAt(1) == '1') {
                            p1++;
                        } else p2++;
                        universal++;
                    }
                    Log.i("test is ", text);
                    indices = 0;

                }
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        } else if (symb != 'O' && symb != 'S') {

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

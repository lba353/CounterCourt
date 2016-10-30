package com.example.student.courtcounter;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private TextView goal;
    private int s = 0;
    private int g = 0;
    private AlertDialog gameOver;
    private MediaPlayer soundFX1;
    private MediaPlayer soundFX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = (TextView)findViewById(R.id.points);
        score.setText(String.valueOf(s));

        goal = (TextView)findViewById(R.id.goals);
        goal.setText(String.valueOf(g));

        gameOver = new AlertDialog.Builder(MainActivity.this).create();

        soundFX1 = MediaPlayer.create(this, R.raw.pling);
        soundFX2 = MediaPlayer.create(this, R.raw.blop);
    }

    public void click1(View view) {
        s++;
        score.setText(String.valueOf(s));

        soundFX1.start();
    }

    public void click2(View view) {
        s--;
        score.setText(String.valueOf(s));

        soundFX2.start();
    }

    public void touch1(View view) {
        g++;
        goal.setText(String.valueOf(g));

        soundFX1.start();
    }

    public void touch2(View view) {
        g--;
        goal.setText(String.valueOf(g));

        soundFX2.start();
    }

    public void reset(View view){
        alert();

        g = 0;
        s = 0;

        goal.setText(String.valueOf(g));
        score.setText(String.valueOf(s));
    }

    public void alert() {
        //Lines 54-64 are if statements that state who won the game and show the message in the alert box.
        if(s > g) {
            gameOver.setMessage("Team Red has won the game!");
        }

        if(s < g) {
            gameOver.setMessage("Team Blue has won the game!");
        }

        if(s == g) {
            gameOver.setMessage("Draw! Nobody Wins!");
        }


        //Sets the title for the alert box.
        gameOver.setTitle("Game Over!");

        //The text box has a button that says, "OK" and will close the alert when pressed.
        gameOver.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        //Shows the alert
        gameOver.show();
    }
}

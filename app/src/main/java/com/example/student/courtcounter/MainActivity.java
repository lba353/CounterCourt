package com.example.student.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private TextView goal;
    private int s = 0;
    private int g = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = (TextView)findViewById(R.id.points);
        score.setText(String.valueOf(s));

        goal = (TextView)findViewById(R.id.goals);
        goal.setText(String.valueOf(g));
    }

    public void click1(View view) {
        s++;
        score.setText(String.valueOf(s));
    }

    public void touch1(View view) {
        g++;
        goal.setText(String.valueOf(g));
    }

    public void reset(View view){
        g = 0;
        s = 0;

        goal.setText(String.valueOf(g));
        score.setText(String.valueOf(s));
    }
}

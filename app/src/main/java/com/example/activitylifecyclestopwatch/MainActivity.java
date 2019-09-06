package com.example.activitylifecyclestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private int seconds =0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();
    }
    // Start stopwatch when the Start button is clicked.
    public void onClickStart(View v)
    {
        running = true;

    }
    // Stop stopwatch when the Stop button is clicked.
    public void onClickStop(View v)
    {
        running = false;
    }
    // Reset stopwatch when the Reset button is clicked.
    public void onClickReset(View v)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}


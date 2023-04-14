package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timer ;
    TextView timer2;
    Button start, hold, reset, resume;
    long milliSecondTimer, startTimer, timeBuff, updateTimer = 0L, sec, min, millis, hour ;
    Handler handler;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer2 = findViewById(R.id.millisecond);
        timer = (TextView)findViewById(R.id.time);
        start = (Button)findViewById(R.id.start);
        hold = (Button)findViewById(R.id.hold);
        reset = (Button)findViewById(R.id.stop);
        resume = (Button)findViewById(R.id.resume);
        handler = new Handler() ;

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer = SystemClock.uptimeMillis();
                handler.post(runnable);
                start.setVisibility(View.GONE);
                hold.setVisibility(View.VISIBLE);
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeBuff += milliSecondTimer;
                handler.removeCallbacks(runnable);
                hold.setVisibility(View.GONE);
                reset.setVisibility(View.VISIBLE);
                resume.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milliSecondTimer = 0L ;
                startTimer = 0L ;
                timeBuff = 0L ;
                updateTimer = 0L ;
                timer.setText("0:00:00");
                timer2.setText(".00");
                hold.setVisibility(View.GONE);
                reset.setVisibility(View.GONE);
                resume.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer = SystemClock.uptimeMillis();
                handler.post(runnable);
                hold.setVisibility(View.VISIBLE);
                reset.setVisibility(View.GONE);
                resume.setVisibility(View.GONE);
                start.setVisibility(View.GONE);
            }
        });
    }

    public Runnable runnable = new Runnable() {
        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        public void run() {
            milliSecondTimer = SystemClock.uptimeMillis() - startTimer;
            updateTimer = timeBuff + milliSecondTimer;
            hour = (updateTimer/ 3600000)%24;
            min = (updateTimer/60000)%60;
            sec = (updateTimer/1000)%60;
            millis = (updateTimer%1000);
            timer.setText(hour+":" + String.format("%02d",min) + ":" + String.format("%02d", sec));
            timer2.setText("."+String.format("%02d",millis/10));

            handler.post(this);
        }
    };
}
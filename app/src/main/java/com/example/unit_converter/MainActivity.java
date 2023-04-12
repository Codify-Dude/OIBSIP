package com.example.unit_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button length = (Button)findViewById(R.id.length);
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });

        Button area = (Button)findViewById(R.id.area);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });

        Button volume = (Button) findViewById(R.id.volume);
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity4();
            }
        });

        Button speed = (Button) findViewById(R.id.speed);
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity5();
            }
        });

        Button weight = (Button) findViewById(R.id.weight);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity6();
            }
        });

        Button temprature = (Button) findViewById(R.id.temprature);
        temprature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity7();
            }
        });

        Button power = (Button) findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity8();
            }
        });

        Button pressure = (Button) findViewById(R.id.pressr);
        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity9();
            }
        });
    }

    public void Activity2()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void Activity3()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }

    public void Activity4()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity4.class);
        startActivity(intent);
    }

    public void Activity5()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity5.class);
        startActivity(intent);
    }

    public void Activity6()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity6.class);
        startActivity(intent);
    }

    public void Activity7()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity7.class);
        startActivity(intent);
    }

    public void Activity8()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity8.class);
        startActivity(intent);
    }

    public void Activity9()
    {
        Intent intent = new Intent(MainActivity.this, MainActivity9.class);
        startActivity(intent);
    }
}
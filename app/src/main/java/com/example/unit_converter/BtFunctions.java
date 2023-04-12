package com.example.unit_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BtFunctions extends AppCompatActivity {
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converted_layout);


    }
    protected void buttonFun()
    {
        textView = findViewById(R.id.primaryTextView1);
        textView2 = findViewById(R.id.primaryTextView2);
        Button clickedOne = findViewById(R.id.clickedOne);
        clickedOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("1");
                }
                else {
                    textView.setText(textView.getText().toString()+"1");
                }
            }
        });

        Button clickedTwo = findViewById(R.id.clickedTwo);
        clickedTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("2");
                }
                else {
                    textView.setText(textView.getText().toString()+"2");
                }
            }
        });

        Button clickedThree = findViewById(R.id.clickedThree);
        clickedThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("3");
                }
                else {
                    textView.setText(textView.getText().toString()+"3");
                }
            }
        });

        Button clickedFour = findViewById(R.id.clickedFour);
        clickedFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("4");
                }
                else {
                    textView.setText(textView.getText().toString()+"4");
                }
            }
        });

        Button clickedFive = findViewById(R.id.clickedFive);
        clickedFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("5");
                }
                else {
                    textView.setText(textView.getText().toString()+"5");
                }
            }
        });

        Button clickedSix = findViewById(R.id.clickedSix);
        clickedSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("6");
                }
                else {
                    textView.setText(textView.getText().toString()+"6");
                }
            }
        });

        Button clickedSeven = findViewById(R.id.clickedSeven);
        clickedSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("7");
                }
                else {
                    textView.setText(textView.getText().toString()+"7");
                }
            }
        });

        Button clickedEight = findViewById(R.id.clickedEight);
        clickedEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("8");
                }
                else {
                    textView.setText(textView.getText().toString()+"8");
                }
            }
        });

        Button clickedNine = findViewById(R.id.clickedNine);
        clickedNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!zeroCheck()) {
                    textView.setText("9");
                }
                else {
                    textView.setText(textView.getText().toString()+"9");
                }
            }
        });

        Button clickedZero = findViewById(R.id.clickedZero);
        clickedZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView.setText(textView.getText().toString()+"0");
                }
            }
        });

        Button clickedDoubleZero = findViewById(R.id.clickedDoubleZero);
        clickedDoubleZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView.setText(textView.getText().toString() + "00");
                }
            }
        });

        Button clickedDot = findViewById(R.id.clickedDot);
        clickedDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textView.getText().toString();
                int flag = 0;
                if(txt.length()==0) {
                    textView.setText(textView.getText().toString() + "0.");
                }
                else
                {
                    if(!txt.contains("."))
                    {
                        textView.setText(textView.getText().toString() + ".");
                    }
                }
            }
        });

        Button clickedClear = findViewById(R.id.clear);
        clickedClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textView.getText().toString();
                if (txt.length()==1 && !txt.equals("0"))
                {
                    textView.setText("0");
                }
                else if(txt.length()>0 && !txt.equals("0")) {
                    txt = txt.substring(0, txt.length() - 1);
                    textView.setText(txt);
                }
            }
        });

        Button clickedReset = findViewById(R.id.clickedReset);
        clickedReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("0");
                textView2.setText("0");
            }
        });
    }

    protected boolean zeroCheck()
    {
        textView = findViewById(R.id.primaryTextView1);
        String text = textView.getText().toString();
        BigDecimal bd = new BigDecimal(text+"0");
        if(!text.contains(".")) {
            if (bd.compareTo(BigDecimal.ZERO) == 0) {
                textView.setText("0");
                return false;
            }
        }
        return true;
    }
}

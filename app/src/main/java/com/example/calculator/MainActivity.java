package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, bt00, btDot;
    TextView textView1, textView2;
    String Operator="";
    Button btEqual, btPlus, btMinus, btMultiply, btDivide, btClear, btPercent, btReset;

    Stack<Double> operands = new Stack<Double>();

    Stack<Character> operators = new Stack<Character>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.clickedOne);
        bt2 = findViewById(R.id.clickedTwo);
        bt3 = findViewById(R.id.clickedThree);
        bt4 = findViewById(R.id.clickedFour);
        bt5 = findViewById(R.id.clickedFive);
        bt6 = findViewById(R.id.clickedSix);
        bt7 = findViewById(R.id.clickedSeven);
        bt8 = findViewById(R.id.clickedEight);
        bt9 = findViewById(R.id.clickedNine);
        bt0 = findViewById(R.id.clickedZero);
        bt00 = findViewById(R.id.clickedDoubleZero);
        btDot = findViewById(R.id.clickedDot);
        btEqual = findViewById(R.id.clickedEqual);
        btPlus = findViewById(R.id.clickedAdd);
        btMinus = findViewById(R.id.clickedSubtract);
        btMultiply = findViewById(R.id.clickedMultiply);
        btDivide = findViewById(R.id.clickedDivide);
        btClear = findViewById(R.id.clear);
        btPercent = findViewById(R.id.clickedPercent);
        btReset = findViewById(R.id.clickedReset);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("1");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "1");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("2");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "2");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("3");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "3");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("4");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "4");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("5");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "5");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("6");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "6");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("7");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "7");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("8");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "8");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("9");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "9");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "0");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        bt00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "00");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        btDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView1.getText().toString().contains(".")) {
                    textView1.setText(textView1.getText().toString() + ".");
                    textView2.setText(calculate());
                    textView2.setVisibility(View.GONE);
                }
            }
        });

        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textView2.getText().toString().equals("")) {

                    textView2.setVisibility(View.VISIBLE);
                }
            }
        });

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView1.setText(textView1.getText().toString() + "+");
                    Operator="+";
                }
            }
        });

        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView2.setVisibility(View.GONE);
                    textView1.setText(textView1.getText().toString() + "-");
                    Operator="-";
                }
            }
        });

        btMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView2.setVisibility(View.GONE);
                    textView1.setText(textView1.getText().toString() + "*");
                }
            }
        });

        btDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView2.setVisibility(View.GONE);
                    textView1.setText(textView1.getText().toString() + "/");
                }
            }
        });

        btPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zeroCheck()) {
                    textView1.setText("0");
                }
                else {
                    textView2.setVisibility(View.GONE);
                    textView1.setText(textView1.getText().toString() + "%");
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = textView1.getText().toString();
                if (txt.length()==1 && !txt.equals("0"))
                {
                    textView1.setText("0");
                    textView2.setText("0");
                }
                else if(txt.length()>0 && !txt.equals("0")) {
                    txt = txt.substring(0, txt.length() - 1);
                    textView1.setText(txt);
                    String ch1 = textView1.getText().toString();
                    String ch2 = ch1.substring(ch1.length()-1);
                    textView2.setVisibility(View.GONE);
                    if(!(ch2.equals("+")||ch2.equals("-")||ch2.equals("*")||ch2.equals("/")||ch2.equals("%")))
                        textView2.setText(calculate());
                }
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("0");
                textView2.setText("0");
                textView2.setVisibility(View.GONE);
            }
        });
    }

    protected boolean zeroCheck()
    {
        textView1 = findViewById(R.id.textView1);
        String text = textView1.getText().toString();
        if(text.equals("0"))
        {
            return true;
        }
        return false;
    }


    public double evaluate(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                double num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(num);
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch=='%') {
                while (!operators.empty() && hasPrecedence(ch, operators.peek())) {
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.empty()) {
            operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/' ||op1=='%') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        else {
            return true;
        }
    }

    public double applyOperation(char op, double a, double b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return b / a;
            case '%':
                return (b/100)*a;
        }
        return 0;
    }

    public String calculate() {
        textView2.setVisibility(View.GONE);
        String exp1 = textView1.getText().toString();
        String ans;
        try {
            ans = String.valueOf(evaluate(exp1));
        }
        catch(Exception e)
        {
            textView1.setText("Cannot divide by zero");
            ans="Cannot divide by zero";
        }
        return ans;
    }
}
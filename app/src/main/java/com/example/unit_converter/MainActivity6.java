package com.example.unit_converter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class MainActivity6 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Microgram (µg)","Milligram (mg)","Gram (g)","Kilogram (kg)","Quintal (q)","Ton (t)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdownitem,
                type
        );

        super.buttonFun();
        autoCompleteTextView = findViewById(R.id.convertFrom);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setText(adapter.getItem(0),false);
        autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
            @Override
            public void onDismiss() {
                autoCompleteTextView.clearFocus();
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity6.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        autoCompleteTextView1 = findViewById(R.id.convertTo);
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView1.setText(adapter.getItem(0),false);
        autoCompleteTextView1.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
            @Override
            public void onDismiss() {
                autoCompleteTextView1.clearFocus();
            }
        });
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity6.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateVolume();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        autoCompleteTextView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateVolume();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textView = findViewById(R.id.primaryTextView1);
        textView2 = findViewById(R.id.primaryTextView2);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateVolume();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void calculateVolume()
    {
        convertFrom = autoCompleteTextView.getText().toString();
        convertFromValue = textView.getText().toString();
        convertTo = autoCompleteTextView1.getText().toString();
        if(convertFromValue.length()==15)
        {
            Toast.makeText(MainActivity6.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Microgram (µg)"))
            {
                switch (convertTo) {
                    case "Microgram (µg)":
                        convertToValue = convertFromValue;
                        break;
                    case "Milligram (mg)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Gram (g)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram (kg)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Quintal (q)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("100000000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Ton (t)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Milligram (mg)")) {
                switch (convertTo) {
                    case "Microgram (µg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Milligram (mg)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Gram (g)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram (kg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Quintal (q)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("100000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Ton (t)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Gram (g)"))
            {
                switch (convertTo) {
                    case "Microgram (µg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Milligram (mg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Gram (g)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilogram (kg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Quintal (q)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("100000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Ton (t)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilogram (kg)"))
            {
                switch (convertTo) {
                    case "Microgram (µg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Milligram (mg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Gram (g)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram (kg)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Quintal (q)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("100");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Ton (t)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Quintal (q)"))
            {
                switch (convertTo) {
                    case "Microgram (µg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("100000000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Milligram (mg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("100000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Gram (g)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("100000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram (kg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("100");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Quintal (q)": {

                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Ton (t)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal divisor = new BigDecimal("10");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Ton (t)"))
            {
                switch (convertTo) {
                    case "Microgram (µg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Milligram (mg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Gram (g)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram (kg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Quintal (q)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Ton (t)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
        }
        else
        {
            textView2.setText("");
        }
    }

}


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

public class MainActivity4 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Cubic Millimeter (mm3)","Cubic Centimeter (cm3)","Cubic Decimeter (dm3)","Cubic Meter (m3)","Milliliter (ml)","Liter (l)"};
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
                Toast.makeText(MainActivity4.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity4.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity4.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Cubic Millimeter (mm3)"))
            {
                switch (convertTo) {
                    case "Cubic Millimeter (mm3)":
                        convertToValue = convertFromValue;
                        break;
                    case "Cubic Centimeter (cm3)":
                    case "Milliliter (ml)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Decimeter (dm3)":
                    case "Liter (l)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Meter (m3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Cubic Centimeter (cm3)")||convertFrom.equals("Milliliter (ml)"))
            {
                switch (convertTo) {
                    case "Cubic Millimeter (mm3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Centimeter (cm3)":
                    case "Milliliter (ml)":
                        convertToValue = convertFromValue;
                        break;
                    case "Cubic Decimeter (dm3)":
                    case "Liter (l)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Meter (m3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);

                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Cubic Decimeter (dm3)")||convertFrom.equals("Liter (l)"))
            {
                switch (convertTo) {
                    case "Cubic Millimeter (mm3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Centimeter (cm3)":
                    case "Milliliter (ml)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Decimeter (dm3)":
                    case "Liter (l)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Cubic Meter (m3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal divisor = new BigDecimal("1000");
                        from = from.divide(divisor);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Cubic Meter (m3)"))
            {
                switch (convertTo) {
                    case "Cubic Millimeter (mm3)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Centimeter (cm3)":
                    case "Milliliter (ml)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Decimeter (dm3)":
                    case "Liter (l)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Cubic Meter (m3)": {
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


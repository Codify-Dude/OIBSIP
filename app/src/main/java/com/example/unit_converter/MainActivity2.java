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

public class MainActivity2 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertForm,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Micrometer (μm)","Millimeter (mm)","Centimeter (cm)","Decimeter (dm)","Meter (m)","Kilometer (km)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.dropdownitem,
                type
        );

        super.buttonFun();
        textView = findViewById(R.id.primaryTextView1);
        textView2 = findViewById(R.id.primaryTextView2);
        autoCompleteTextView = findViewById(R.id.convertFrom);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setText(adapter.getItem(0),false);
        autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
            @Override
            public void onDismiss() {
                autoCompleteTextView.clearFocus();
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

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateLength();
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
                calculateLength();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateLength();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void calculateLength()
    {
        textView = findViewById(R.id.primaryTextView1);
        textView2 = findViewById(R.id.primaryTextView2);
        convertForm = autoCompleteTextView.getText().toString();
        convertFromValue = textView.getText().toString();
        convertTo = autoCompleteTextView1.getText().toString();
        if(convertFromValue.length()==15)
        {
            Toast.makeText(MainActivity2.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertForm.equals("Micrometer (μm)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Millimeter (mm)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Centimeter (cm)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Decimeter (dm)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);

                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Meter (m)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Kilometer (km)"))
            {
                if(convertTo.equals("Micrometer (μm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Millimeter (mm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Centimeter (cm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Decimeter (dm)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Meter (m)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Kilometer (km)"))
                {
                    convertToValue = convertFromValue;
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

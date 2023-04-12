package com.example.unit_converter;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.math.BigDecimal;

public class MainActivity3 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertForm,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Square Millimeter (mm2)","Square Centimeter (cm2)","Square Decimeter (dm2)","Square Meter (m2)","Square Kilometer (km2)"};
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
                Toast.makeText(MainActivity3.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity3.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateArea();
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
                calculateArea();
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
                calculateArea();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    public void calculateArea()
    {
        convertForm = autoCompleteTextView.getText().toString();
        convertFromValue = textView.getText().toString();
        convertTo = autoCompleteTextView1.getText().toString();
        if(convertFromValue.length()==15)
        {
            Toast.makeText(MainActivity3.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();
        }
        if(!convertFromValue.equals(""))
        {
            if(convertForm.equals("Square Millimeter (mm2)"))
            {
                if (convertTo.equals("Square Millimeter (mm2)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Square Centimeter (cm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Decimeter (dm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Meter (m2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Kilometer (km2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Square Centimeter (cm2)"))
            {
                if (convertTo.equals("Square Millimeter (mm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Centimeter (cm2)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Square Decimeter (dm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Meter (m2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Kilometer (km2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("10000000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Square Decimeter (dm2)"))
            {
                if (convertTo.equals("Square Millimeter (mm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Centimeter (cm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Decimeter (dm2)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Square Meter (m2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Kilometer (km2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("100000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Square Meter (m2)"))
            {
                if (convertTo.equals("Square Millimeter (mm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Centimeter (cm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Decimeter (dm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Meter (m2)"))
                {
                    convertToValue = convertFromValue;
                }
                else if(convertTo.equals("Square Kilometer (km2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal divisor = new BigDecimal("1000000");
                    from = from.divide(divisor);
                    convertToValue = String.valueOf(from);
                }
                textView2.setText(convertToValue);
            }
            else if(convertForm.equals("Square Kilometer (km2)"))
            {
                if (convertTo.equals("Square Millimeter (mm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Centimeter (cm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("10000000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Decimeter (dm2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("100000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Meter (m2)"))
                {
                    BigDecimal from = new BigDecimal(convertFromValue);
                    BigDecimal mul = new BigDecimal("1000000");
                    from = from.multiply(mul);
                    convertToValue = String.valueOf(from);
                }
                else if(convertTo.equals("Square Kilometer (km2)"))
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



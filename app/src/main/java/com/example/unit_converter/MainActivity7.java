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

public class MainActivity7 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Degree Rankine (°R)","Degree Celsius (°C)","Degree Reaumur (°Re)","Degree Fahrenheit (°F)","Kelvin (K)"};
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
                Toast.makeText(MainActivity7.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity7.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity7.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Degree Rankine (°R)"))
            {
                switch (convertTo) {
                    case "Degree Rankine (°R)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Degree Celsius (°C)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0) {
                            convertToValue="-273.15";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("-272.59444444444443");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Reaumur (°Re)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-218.51999999999998";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("-218.07555555555555");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Fahrenheit (°F)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-459.66999999999996";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("-458.67");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kelvin (K)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.5555555555555429");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Degree Celsius (°C)"))
            {
                switch (convertTo) {
                    case "Degree Rankine (°R)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="491.66999999999996";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("493.46999999999997");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Celsius (°C)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Degree Reaumur (°Re)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("0.8");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Fahrenheit (°F)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="32";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("33.8");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kelvin (K)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="273.15";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("274.15");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Degree Reaumur (°Re)"))
            {
                switch (convertTo) {
                    case "Degree Rankine (°R)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="491.66999999999996";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("493.91999999999996");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Celsius (°C)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1.25");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Reaumur (°Re)":{
                        convertToValue = convertFromValue;
                        break;
                    }

                    case "Degree Fahrenheit (°F)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="32";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("34.25");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kelvin (K)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="273.15";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("274.4");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Degree Fahrenheit (°F)"))
            {
                switch (convertTo) {
                    case "Degree Rankine (°R)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="459.66999999999996";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("460.66999999999996");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Celsius (°C)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-17.77777777777778";
                            break;
                        }

                        BigDecimal mul = new BigDecimal("-17.22222222222222");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Reaumur (°Re)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-14.222222222222223";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("-13.777777777777779");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Fahrenheit (°F)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kelvin (K)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="255.3722222222222";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("255.92777777777775");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kelvin (K)"))
            {
                switch (convertTo) {
                    case "Degree Rankine (°R)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1.8");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Degree Celsius (°C)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-273.15";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("-272.15");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Reaumur (°Re)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-218.51999999999998";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("-217.72");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }

                    case "Degree Fahrenheit (°F)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="-459.66999999999996";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("-457.86999999999995");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kelvin (K)":{
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


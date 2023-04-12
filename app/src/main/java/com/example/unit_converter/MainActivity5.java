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

public class MainActivity5 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Kilometer/second (km/s)","Mile/hour (mph)","Inch/second (in/s)","Meter/second (m/s)","Kilometer/hour (km/h)"};
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
                Toast.makeText(MainActivity5.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity5.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity5.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Kilometer/second (km/s)"))
            {
                switch (convertTo) {
                    case "Kilometer/second (km/s)":
                        convertToValue = convertFromValue;
                        break;
                    case "Mile/hour (mph)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("2236.936");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Inch/second (in/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("39370.079");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Meter/second (m/s)":{
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
                    case "Kilometer/hour (km/h)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("3600");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Mile/hour (mph)"))
            {
                switch (convertTo) {
                    case "Kilometer/second (km/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.00044704005836555");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Mile/hour (mph)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Inch/second (in/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("17.60000241401631437845");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Meter/second (m/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.44704005836555");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilometer/hour (km/h)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1.60934421011598");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Inch/second (in/s)"))
            {
                switch (convertTo) {
                    case "Kilometer/second (km/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.00002539999983236");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Mile/hour (mph)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.05681817402500004896");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Inch/second (in/s)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Meter/second (m/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.02539999983236");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilometer/hour (km/h)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.091439999396496");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Meter/second (m/s)"))
            {
                switch (convertTo) {
                    case "Kilometer/second (km/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.001");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Mile/hour (mph)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("2.236936");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Inch/second (in/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("39.370079");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Meter/second (m/s)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilometer/hour (km/h)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("3.6");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilometer/hour (km/h)"))
            {
                switch (convertTo) {
                    case "Kilometer/second (km/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.000277777777777778");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Mile/hour (mph)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.621371111111111608208");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Inch/second (in/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10.936133055555564304462");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Meter/second (m/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.277777777777778");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilometer/hour (km/h)": {
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


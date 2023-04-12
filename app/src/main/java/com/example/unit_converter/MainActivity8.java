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

public class MainActivity8 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Joule/second (J/s)","British thermal unit/second (Btu/s)","Kilogram-meter/second (kg.m/s)","Kilocalorie/second (kcal/s)","Watt (W)","Kilowatt (kW)"};
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
                Toast.makeText(MainActivity8.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity8.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity8.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Joule/second (J/s)")||convertFrom.equals("Watt (W)"))
            {
                switch (convertTo) {
                    case "Watt (W)":
                    case "Joule/second (J/s)":
                        convertToValue = convertFromValue;
                        break;
                    case "British thermal unit/second (Btu/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0009478171");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram-meter/second (kg.m/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.1019716213");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilocalorie/second (kcal/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.000239");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilowatt (kW)":{
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
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("British thermal unit/second (Btu/s)"))
            {
                switch (convertTo) {
                    case "Watt (W)":
                    case "Joule/second (J/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1055.055875231624329");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "British thermal unit/second (Btu/s)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilogram-meter/second (kg.m/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("107.5857581594592458606546077");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilocalorie/second (kcal/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.252158354180358214631");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilowatt (kW)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1.055055875231624329");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilogram-meter/second (kg.m/s)"))
            {
                switch (convertTo) {
                    case "Watt (W)":
                    case "Joule/second (J/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("9.806649999787735");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "British thermal unit/second (Btu/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0092949105635138116032685");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram-meter/second (kg.m/s)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilocalorie/second (kcal/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.002343789349949268665");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilowatt (kW)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.009806649999787735");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilocalorie/second (kcal/s)"))
            {
                switch (convertTo) {
                    case "Watt (W)":
                    case "Joule/second (J/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("4184.100418410041841");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "British thermal unit/second (Btu/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("3.9657619246861924686152811");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram-meter/second (kg.m/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("426.6595033472803347276068133");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilocalorie/second (kcal/s)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilowatt (kW)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("4.184100418410041841");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilowatt (kW)"))
            {
                switch (convertTo) {
                    case "Watt (W)":
                    case "Joule/second (J/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        BigDecimal mul = new BigDecimal("1000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "British thermal unit/second (Btu/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.9478171");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilogram-meter/second (kg.m/s)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("101.9716213");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilocalorie/second (kcal/s)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.239");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilowatt (kW)":{
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


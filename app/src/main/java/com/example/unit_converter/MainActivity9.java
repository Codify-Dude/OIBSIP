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

public class MainActivity9 extends BtFunctions{
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    String convertFrom,convertTo,convertFromValue,convertToValue;

    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String[] type=new String[]{"Standard Atmospheric Pressure (atm)","Millimeter of Water (mmH2O)","Millimeter of Mercury (mmHg)","Millibar (mbar)","Bar","Kilopascal (kPa)","MegaPascal (MPa)"};
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
                Toast.makeText(MainActivity9.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

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
                Toast.makeText(MainActivity9.this,autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(MainActivity9.this,"Maximum Digits (15) Reached", Toast.LENGTH_SHORT).show();

        }
        if(!convertFromValue.equals(""))
        {
            if(convertFrom.equals("Standard Atmospheric Pressure (atm)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)":
                        convertToValue = convertFromValue;
                        break;
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10332.27516229736261293148");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("760.0002229150602429472351");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1013.250273830886503");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Bar": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1.013250273830886503");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilopascal (kPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("101.3250273830886503");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "MegaPascal (MPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.1013250273830886503");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Millimeter of Water (mmH2O)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.000096784104593827623679");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0735559410659435000741");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.098066520482173");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Bar": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.000098066520482173");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilopascal (kPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0098066520482173");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "MegaPascal (MPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0000098066520482173");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Millimeter of Mercury (mmHg)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.001315789087751047274043");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("13.59509491019205066756");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Millibar (mbar)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("1.333223653467441");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Bar": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.001333223653467441");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilopascal (kPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.1333223653467441");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "MegaPascal (MPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0001333223653467441");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Millibar (mbar)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.000986923");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10.19716");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.7500617");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Bar": {
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
                    case "Kilopascal (kPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.1");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "MegaPascal (MPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.0001");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Bar"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.986923");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10197.16");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("750.0617");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
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
                    case "Bar": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "Kilopascal (kPa)": {
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
                    case "MegaPascal (MPa)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.1");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                }
                textView2.setText(convertToValue);
            }
            else if(convertFrom.equals("Kilopascal (kPa)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.00986923");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("101.9716");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("7.500617");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
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
                    case "Bar": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("0.01");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Kilopascal (kPa)": {
                        convertToValue = convertFromValue;
                        break;
                    }
                    case "MegaPascal (MPa)": {
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
            else if(convertFrom.equals("MegaPascal (MPa)"))
            {
                switch (convertTo) {
                    case "Standard Atmospheric Pressure (atm)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("9.86923");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Water (mmH2O)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("101971.6");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millimeter of Mercury (mmHg)": {
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("7500.617");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Millibar (mbar)":{
                        BigDecimal from = new BigDecimal(convertFromValue);
                        if(from.compareTo(BigDecimal.ZERO)==0){
                            convertToValue="0";
                            break;
                        }
                        BigDecimal mul = new BigDecimal("10000");
                        from = from.multiply(mul);
                        convertToValue = String.valueOf(from);
                        break;
                    }
                    case "Bar": {
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
                    case "Kilopascal (kPa)": {
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
                    case "MegaPascal (MPa)": {
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

package com.mohit.calculatorAssignment.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mohit.calculatorAssignment.R;
import com.mohit.calculatorAssignment.model.CalcEngine;

import static com.mohit.calculatorAssignment.R.string.addition;

public class CalcActivity extends AppCompatActivity {

    CalcEngine calculator;

    TextView numberText;
    TextView detailText;
    String number = "", operator1;
    Character operation = ' ';
    boolean finished = false;
    //enum Opration{add, subtract, multiply, divide, none};
    //Avoid enumerators in Android, High memory overhead

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        numberText = (TextView) findViewById(R.id.numberText);
        detailText = (TextView) findViewById(R.id.detailText);
        calculator = new CalcEngine();
    }

    public void onClickNumber(View view) {
        if(finished) onClickClear(view);
        Button button = (Button) view;
        number = String.valueOf(Long.parseLong(numberText.getText().toString()+button.getText()));
        numberText.setText(number);
    }


    public void onClickEqual(View view) {
        if(operation != ' ') {
            Double op1 = Double.parseDouble(operator1);
            Double op2 = Double.parseDouble(number);
            detailText.setText(operator1 + operation + number + "=");
            switch (operation) {
                case '+':
                    number =  String.valueOf(op1 + op2);
                    break;
                case '-':
                    number =  String.valueOf(op1 - op2);
                    break;
                case '\u00d7':
                    number =  String.valueOf(op1 * op2);
                    break;
                case '\u00f7':
                    if(op2 != 0)
                        number =  String.valueOf(op1 / op2);
                    else {
                        detailText.setText("Cannot divide by Zero");
                    }
            }
            Double n = Double.parseDouble(number);
            numberText.setText( n%1==0 ? String.valueOf(n.intValue()) : number);
            operation = ' ';
        }
    }

    public void onClickOperation(View view) {
        int operation = ((Button) view).getId();
        switch (operation) {

            case R.id.bPlus: // Addition
                break;

            case R.id.bMinus: // Subtraction
                break;

            case R.id.bMut: // Multiply
                break;

            case R.id.bDivision: // Divide
                break;

            case R.id.bSQRT: // Square Root
                break;

            case R.id.bPercent: // Percent
                break;

            case R.id.bEqual: // Equal
                break;

            case R.id.bC: // Clear
                String text = (String) ((Button) view).getText();
                if (text.equals("C")) {
                    ((Button) view).setText("AC");
                } else {
                    ((Button) view).setText("C");
                }
                break;

        }
    }

    public void onClickClear(View view) {
        number="0";
        operation = ' ';
        detailText.setText("");
        numberText.setText("0");
        finished = false;
    }

    public void onClickPercent(View view) {

        if(operation != ' ') {
            Double op1 = Double.parseDouble(operator1);
            detailText.setText(operator1 + operation + number + "%=");
            Double op2 = Double.parseDouble(number)/100.0;
            switch (operation) {
                case '+':
                    number =  String.valueOf(op1 * (1+ op2));
                    break;
                case '-':
                    number =  String.valueOf(op1 * (1- op2));
                    break;
                case '\u00d7':
                    number =  String.valueOf(op1 * op2);
                    break;
                case '\u00f7':
                    if(op2 != 0)
                        number =  String.valueOf(op1/op2);
                    else {
                        detailText.setText("Cannot divide by Zero");
                    }
            }
            Double n = Double.parseDouble(number);
            numberText.setText( n%1==0 ? String.valueOf(n.intValue()) : number);
            operation = ' ';
        }
        else{
            Double n = Double.parseDouble(number)/100.0;
            number = n.toString();
            numberText.setText( n%1==0 ? String.valueOf(n.intValue()) : number);
        }
        finished = true;

    }
}


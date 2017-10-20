package com.mohit.calculatorAssignment.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mohit.calculatorAssignment.R;
import com.mohit.calculatorAssignment.model.CalcEngine;

public class CalcActivity extends AppCompatActivity {

    CalcEngine calculator;

    TextView numberText;
    TextView detailText;
    String number = "", operator1;
    Character operationOld = ' ';
    Integer operation = null;
    boolean isOperationSelected = false;

    boolean isNumberSelectionMode = false;
    boolean isOperationSelectionMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        numberText = (TextView) findViewById(R.id.numberText);
        detailText = (TextView) findViewById(R.id.detailText);
        calculator = new CalcEngine();
    }

    public void onClickNumber(View view) {

        // if user is shifting from operation selection to number selection
        if (isOperationSelectionMode) {
            onClickClear(view);
            calculator.insertOperand(operation);
        }
        isNumberSelectionMode = true;
        isOperationSelectionMode = false;

        Button button = (Button) view;
        number = String.valueOf(Long.parseLong(numberText.getText().toString()+button.getText()));
        numberText.setText(number);

        Log.d("Number", "Result: " + calculator.getResult());
    }


    public void onClickEqual(View view) {
        if (operationOld != ' ') {
            Double op1 = Double.parseDouble(operator1);
            Double op2 = Double.parseDouble(number);
            detailText.setText(operator1 + operationOld + number + "=");
            switch (operationOld) {
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
            operationOld = ' ';
        }
    }


    public void onClickOperation(View view) {

        // if user is shifting from number selection to operation selection
        if (isNumberSelectionMode) {
            calculator.insertNumber(Double.parseDouble(number));
            Double result = calculator.getResult();
            String numberString = result.longValue() == result ? "" + result.longValue() : "" + result;
            numberText.setText(numberString);
        }
        isNumberSelectionMode = false;
        isOperationSelectionMode = true;

        Log.d("Number", "Result: " + calculator.getResult());
        operation = ((Button) view).getId();
        number = (String) numberText.getText();
    }

    public void onClickClear(View view) {
        number="0";
        operationOld = ' ';
        detailText.setText("");
        numberText.setText("0");
    }

    public void onClickPercent(View view) {

        if (operationOld != ' ') {
            Double op1 = Double.parseDouble(operator1);
            detailText.setText(operator1 + operationOld + number + "%=");
            Double op2 = Double.parseDouble(number)/100.0;
            switch (operationOld) {
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
            operationOld = ' ';
        }
        else{
            Double n = Double.parseDouble(number)/100.0;
            number = n.toString();
            numberText.setText( n%1==0 ? String.valueOf(n.intValue()) : number);
        }
        isOperationSelected = true;

    }
}


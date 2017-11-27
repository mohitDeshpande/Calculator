package com.mohit.calculatorAssignment.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mohit.calculatorAssignment.R;
import com.mohit.calculatorAssignment.model.CalcEngine;

public class CalcActivity extends AppCompatActivity {

    TextView numberText;
    TextView detailText;
    String number = "", operator1;
    Character operation = ' ';
    boolean finished = false;

    CalcEngine calc = new CalcEngine();

    //enum Opration{add, subtract, multiply, divide, none};
    //Avoid enumerators in Android, High memory overhead

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        numberText = (TextView) findViewById(R.id.numberText);
        detailText = (TextView) findViewById(R.id.detailText);
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
            number = calc.executeOperation(op1, op2, operation);
            Double n = Double.parseDouble(number);
            numberText.setText( n%1==0 ? String.valueOf(n.intValue()) : number);
            operation = ' ';
        }
    }

    public void onClickOperation(View view) {
        operation = ((Button) view).getText().charAt(0);
        operator1 = number;
        detailText.setText(number + operation);
        numberText.setText("0");
        finished = false;
    }

    public void onClickClear(View view) {
        number="0";
        operation = ' ';
        detailText.setText("");
        numberText.setText("0");
        finished = false;
    }

    public void onClickMPlus(View view) {
        calc.addToMemory(Double.parseDouble(numberText.getText().toString()));
    }

    public void onClickMMinus(View view) {
        calc.subFromMemory(Double.parseDouble(numberText.getText().toString()));
    }

    public void onClickMemoryClear(View view) {
        calc.clearMemory();
    }

    public void onClickRecallMemory(View view) {
        number = calc.recallMemory();
        Double n = Double.parseDouble(number);
        numberText.setText(n % 1 == 0 ? String.valueOf(n.intValue()) : number);
    }

    public void onClickPercent(View view) {
        if(operation != ' ') {
            Double op1 = Double.parseDouble(operator1);
            detailText.setText(operator1 + operation + number + "%=");
            Double op2 = Double.parseDouble(number)/100.0;
            number = calc.executePercent(op1, op2, operation);
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


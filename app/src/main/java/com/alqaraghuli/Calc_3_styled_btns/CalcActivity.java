package com.alqaraghuli.Calc_3_styled_btns;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

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

class LinearLayoutAspectRatio extends LinearLayoutCompat {


    public LinearLayoutAspectRatio(Context context) {
        super(context, null);
    }

    public LinearLayoutAspectRatio(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        double aspectRatio = 4.0/5.0;
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int newWidth = (int) Math.min(w, aspectRatio * h);
        int newHeight = (int) (1.0 * newWidth / aspectRatio);

        super.onMeasure(MeasureSpec.makeMeasureSpec(newWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(newHeight, MeasureSpec.EXACTLY));
    }
}

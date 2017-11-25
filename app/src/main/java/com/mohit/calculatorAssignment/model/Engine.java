package com.mohit.calculatorAssignment.model;

/**
 * Created by mohit on 2017-11-25.
 */

public class Engine {
    String number;


    public String executeOperation(Double op1, Double op2, Character operation) {
        switch (operation) {
            case '+': // addition
                number = String.valueOf(op1 + op2);
                break;
            case '-': // subtraction
                number = String.valueOf(op1 - op2);
                break;
            case '\u00d7': // multiplication
                number = String.valueOf(op1 * op2);
                break;
            case '\u00f7': // division
                if (op2 != 0)
                    number = String.valueOf(op1 / op2);

        }
        return number;
    }

    public String executePercent(Double op1, Double op2, Character operation) {
        switch (operation) {
            case '+':
                number = String.valueOf(op1 * (1 + op2));
                break;
            case '-':
                number = String.valueOf(op1 * (1 - op2));
                break;
            case '\u00d7':
                number = String.valueOf(op1 * op2);
                break;
            case '\u00f7':
                if (op2 != 0)
                    number = String.valueOf(op1 / op2);
        }
        return number;
    }
}

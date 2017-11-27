package com.mohit.calculatorAssignment.model;

/**
 * Created by mohit on 2017-11-25.
 */

public class CalcEngine {
    String number = "0";
    String memory = "0";

    public String addToMemory(Double op1) {
        Double mem = Double.parseDouble(memory) + op1;
        memory = String.valueOf(mem);
        return memory;
    }

    public String subFromMemory(Double op1) {
        Double mem = Double.parseDouble(memory) - op1;
        memory = String.valueOf(mem);
        return memory;
    }

    public String clearMemory() {
        memory = "0";
        return memory;
    }

    public String recallMemory() {
        return memory;
    }

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

    public String getValue() {
        return number;
    }
}

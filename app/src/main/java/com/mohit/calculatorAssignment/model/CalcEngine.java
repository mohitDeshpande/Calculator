package com.mohit.calculatorAssignment.model;

import com.mohit.calculatorAssignment.R;

import java.util.Stack;

/**
 * The Calculator Engine for the application,
 * uses a form of Shunting Yard Algorithm to do the calculations
 *
 * Created by mohit on 2017-10-19.
 */
public class CalcEngine {

    private Double memory;
    private Stack<Double> numberStack;
    private Stack<Integer> operandStack;

    public CalcEngine() {
        memory = 0.0;
        numberStack = new Stack<>();
        operandStack = new Stack<>();
    }

    public void insertNumber(Double number) {
        numberStack.push(number);
        if (numberStack.size() == 2) {
            execute();
        }
    }

    public void insertOperand(Integer operand) {
        if (operandStack.isEmpty()) {
            operandStack.push(operand);
        } else {
            execute();
        }
    }


    private void execute() {
        Double number2 = numberStack.pop();
        Double number1 = 0d;

        if (!numberStack.isEmpty()) {
            number1 = numberStack.pop();
        }

        switch (operandStack.pop()) {
            case R.id.bPlus: // Addition
                numberStack.push(number1 + number2);
                break;

            case R.id.bMinus: // Subtraction
                numberStack.push(number1 - number2);
                break;

            case R.id.bMut: // Multiply
                numberStack.push(number1 * number2);
                break;

            case R.id.bDivision: // Divide
                numberStack.push(number1 / number2);
                break;

            case R.id.bPercent:
                numberStack.push(number1 / 100);
                break;

            case R.id.bSQRT:
                numberStack.push(Math.sqrt(number1));
        }
    }

    public Double getResult() {
        return numberStack.peek();
    }

    public void clear() {
        // FIXME
        numberStack.clear();
        numberStack.push(0d);
        operandStack.clear();
    }

    /**
     * M+ add to memory
     *
     * @param value the value to be added to the memory
     * @return The total
     */
    public Double addToMemory(Double value) {
        return memory += value;
    }

    /**
     * Subtract value from memory
     *
     * @param value to be subtracted
     * @return total
     */
    public Double subtractFromMemory(Double value) {
        return memory -= value;
    }

    /**
     * MC clear memory and set it to 0
     */
    public void clearMemory() {
        memory = 0.0;
    }

    /**
     * MR Recalls the value from the memory
     *
     * @return memory value
     */
    public Double recallMemory() {
        return memory;
    }
}

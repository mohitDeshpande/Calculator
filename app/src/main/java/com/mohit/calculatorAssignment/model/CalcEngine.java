package com.mohit.calculatorAssignment.model;

import java.sql.ResultSet;
import java.util.Stack;

/**
 * The Calculator Engine for the application
 *
 * Created by mohit on 2017-10-19.
 */
public class CalcEngine {

    private Double memory;
    private Double result;
    private Stack<Double> resultStack;


    public CalcEngine() {
        memory = 0.0;
        result = 0.0;
        resultStack = new Stack<>();
    }

    /**
     * Add number to result
     * @param value value to add
     * @return result
     */
    public Double add(Double value) {
        resultStack.push(result += value);
        return result;
    }

    /**
     * Subtract number from the result
     *
     * @param value value to subtract
     * @return result
     */
    public Double subtract(Double value) {
        resultStack.push(result -= value);
        return result;
    }

    /**
     * Multiply number to result
     *
     * @param value value to multiply
     * @return result
     */
    public Double multiply(Double value) {
        resultStack.push(result *= value);
        return result;
    }

    /**
     * Divide number from result
     *
     * @param value value to divide
     * @return result
     */
    public Double divide(Double value) {
        if (value != 0) {
            resultStack.push(result /= value);
        }
        return result;

    }

    /**
     * Convert result to percentage
     *
     * @return result
     */
    public Double percent() {
        resultStack.push(result /= 100);
        return result;
    }

    /**
     * Get root of result
     *
     * @return result
     */
    public Double root() {
        result = Math.sqrt(result);
        resultStack.push(result);
        return result;
    }

    /**
     * Square the result
     *
     * @return result
     */
    public Double square() {
        resultStack.push(result *= result);
        return result;
    }

    /**
     * undo the last result
     *
     * @return the current result before undo
     */
    public Double undo() {
        return resultStack.pop();
    }

    /**
     * set result to 0.0
     */
    public void clearResult() {
        result = 0d;
        resultStack = new Stack<>();
    }

    /**
     * clear result and memory
     */
    public void clearAll() {
        clearResult();
        clearMemory();
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
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

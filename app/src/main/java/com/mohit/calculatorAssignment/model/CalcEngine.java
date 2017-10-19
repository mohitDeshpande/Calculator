package com.mohit.calculatorAssignment.model;

/**
 * The Calculator Engine for the application
 *
 * Created by mohit on 2017-10-19.
 */
public class CalcEngine {

    private Double memory;
    private Double result;


    public CalcEngine() {
        memory = 0.0;
        result = 0.0;
    }

    /**
     * Add number to result
     * @param value value to add
     * @return result
     */
    public Double add(Double value) {
        return result += value;
    }

    /**
     * Subtract number from the result
     *
     * @param value value to subtract
     * @return result
     */
    public Double subtract(Double value) {
        return result -= value;
    }

    /**
     * Multiply number to result
     *
     * @param value value to multiply
     * @return result
     */
    public Double multiply(Double value) {
        return result *= value;
    }

    /**
     * Divide number from result
     *
     * @param value value to divide
     * @return result
     */
    public Double divide(Double value) {
        if (value != 0) {
            return result /= value;
        } else {
            return result;
        }
    }

    /**
     * Convert result to percentage
     *
     * @return result
     */
    public Double percent() {
        return result /= 100;
    }

    /**
     * Get root of result
     *
     * @return result
     */
    public Double root() {
        result = Math.sqrt(result);
        return result;
    }

    public Double square() {
        return result *= result;
    }

    /**
     * set result to 0.0
     */
    public void clearResult() {
        result = 0d;
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

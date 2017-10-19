package com.mohit.calculatorAssignment.model;

import java.util.Stack;

/**
 * Created by mohit on 2017-10-19.
 */
public class CalcEngine {

    private Double memory;
    private Double value;


    public CalcEngine() {
        memory = 0.0;
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

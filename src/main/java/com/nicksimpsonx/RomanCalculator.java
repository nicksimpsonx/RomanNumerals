package com.nicksimpsonx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation for Roman Calculator coding Kata:<br>
 * @https://codingdojo.org/kata/RomanCalculator/
 * Contains functionality to convert a given roman numeral string into its decimal equivalent
 * @author Nick Simpson
 * @implNote I did this Kata on 22nd January 2021 during madetech learn tech afternoon using a TDD approach to allow the
 * tests to drive the development of the algorithm.
 */
public class RomanCalculator {

    private static final List<String> ILLEGAL_COMBINATIONS = new ArrayList<>(Arrays.asList(
            "IIII","XXXX","CCCC","VV","LL","DD"));

    private int total = 0;
    private int lastValue = 0;
    private int currentValue = 0;

    /**
     * Tries to convert the given roman numeral string into its decimal equivalent
     * @param stringToEvaluate - Roman numeral string to convert
     * @return the decimal equivalent
     */
    public int evaluate(String stringToEvaluate) {

        // Check the string first before we try to convert it, exception will get thrown if it's invalid
        checkStringIsValid(stringToEvaluate);
        // Split the given string into tokens
        List<String> numerals = new ArrayList<>(
                Arrays.asList(stringToEvaluate.split("")));

        // Iterate through the numerals
        for(String numeral : numerals) {
            // Convert the current numeral to decimal value
            currentValue = getDecimalValueForNumeral(numeral);
            // If the last value is greater than the current value it should have been subtracted
            if(lastValue < currentValue) {
                total -= (lastValue * 2); // Multiplied by 2 as it was added last iteration
            }
            // Add current value to total and set last value to current value
            total += currentValue;
            lastValue = currentValue;
        }
        return total;
    }

    // Check to make sure the string is not empty / containing illegal combinations
    private void checkStringIsValid(String stringToEvaluate) {

        if(stringToEvaluate == null || stringToEvaluate.isEmpty()) {
            throw new IllegalArgumentException("Cannot evaluate null or empty strings");
        }
        if(containsIllegalCombinations(stringToEvaluate)) {
            throw new IllegalArgumentException("Cannot evaluate due to illegal combination of numerals");
        }
    }

    // As per the rules of roman numbers, some combinations of numerals are illegal, check for these
    private boolean containsIllegalCombinations(String stringToEvaluate) {

        for(String combination : ILLEGAL_COMBINATIONS) {
            if(stringToEvaluate.contains(combination)) {
                return true;
            }
        }
        return false;
    }

    // Return the decimal value for the given roman numeral
    private int getDecimalValueForNumeral(String numeral) {

        switch (numeral) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                // Illegal value!
                throw new IllegalArgumentException("Could not covert " + numeral + " into decimal value");
        }
    }

}

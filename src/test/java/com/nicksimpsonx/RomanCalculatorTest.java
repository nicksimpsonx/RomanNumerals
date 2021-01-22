package com.nicksimpsonx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Roman Numeral Calculator, based on the rules in:
 * https://codingdojo.org/kata/RomanCalculator
 */
public class RomanCalculatorTest {

    RomanCalculator calculator;

    @BeforeEach
    void setupTests() {
        calculator = new RomanCalculator();
    }

    @Test
    void canMakeCalculator() {
        assertNotNull(calculator);
    }

    @Test
    void canEvaluate1() {
        assertEquals(1,calculator.evaluate("I"));
    }

    @Test
    void canEvaluate2() {
        assertEquals(2,calculator.evaluate("II"));
    }

    @Test
    void canEvaluate6() {
        assertEquals(6,calculator.evaluate("VI"));
    }

    @Test
    void canEvaluate16() {
        assertEquals(16,calculator.evaluate("XVI"));
    }

    @Test
    void canEvaluate22() {
        assertEquals(22,calculator.evaluate("XXII"));
    }

    @Test
    void canEvaluate66() {
        assertEquals(66,calculator.evaluate("LXVI"));
    }

    @Test
    void canEvaluate166() {
        assertEquals(166,calculator.evaluate("CLXVI"));
    }

    @Test
    void canEvaluate666() {
        assertEquals(666,calculator.evaluate("DCLXVI"));
    }

    @Test
    void canEvaluate1666() {
        assertEquals(1666,calculator.evaluate("MDCLXVI"));
    }

    @Test
    void canEvaluate900Subtractive() {
        assertEquals(900,calculator.evaluate("CM"));
    }

    @Test
    void canEvaluate904Subtractive() {
        assertEquals(904,calculator.evaluate("CMIV"));
    }

    @Test
    void illegalValuesCauseIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("AX");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("IIII");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("XXXX");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("CCCC");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("VV");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("LL");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("DD");
        });
    }

    @Test
    void nullAndEmptyStringsCauseIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("");
        });
    }

}

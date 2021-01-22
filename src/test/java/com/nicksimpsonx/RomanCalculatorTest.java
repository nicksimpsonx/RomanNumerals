package com.nicksimpsonx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Roman Numeral Calculator, based on the rules in:
 * https://codingdojo.org/kata/RomanCalculator
 */
public class RomanCalculatorTest {

    private static final String ONE = "I";
    private static final String TWO = "II";
    private static final String SIX = "VI";
    private static final String SIXTEEN = "XVI";
    private static final String TWENTY_TWO = "XXII";
    private static final String SIXTY_SIX ="LXVI";
    private static final String ONE_HUNDRED_AND_SIXTY_SIX = "CLXVI";
    private static final String SIX_HUNDRED_AND_SIXTY_SIX = "DCLXVI";
    private static final String ONE_THOUSAND_SIX_HUNDRED_AND_SIXTY_SIX = "MDCLXVI";
    private static final String NINE_HUNDRED = "CM";
    private static final String NINE_HUNDRED_AND_FOUR = "CMIV";

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

        assertEquals(1,calculator.evaluate(ONE));
    }

    @Test
    void canEvaluate2() {

        assertEquals(2,calculator.evaluate(TWO));
    }

    @Test
    void canEvaluate6() {

        assertEquals(6,calculator.evaluate(SIX));
    }

    @Test
    void canEvaluate16() {

        assertEquals(16,calculator.evaluate(SIXTEEN));
    }

    @Test
    void canEvaluate22() {

        assertEquals(22,calculator.evaluate(TWENTY_TWO));
    }

    @Test
    void canEvaluate66() {

        assertEquals(66,calculator.evaluate(SIXTY_SIX));
    }

    @Test
    void canEvaluate166() {

        assertEquals(166,calculator.evaluate(ONE_HUNDRED_AND_SIXTY_SIX));
    }

    @Test
    void canEvaluate666() {

        assertEquals(666,calculator.evaluate(SIX_HUNDRED_AND_SIXTY_SIX));
    }

    @Test
    void canEvaluate1666() {

        assertEquals(1666,calculator.evaluate(ONE_THOUSAND_SIX_HUNDRED_AND_SIXTY_SIX));
    }

    @Test
    void canEvaluate900Subtractive() {

        assertEquals(900,calculator.evaluate(NINE_HUNDRED));
    }

    @Test
    void canEvaluate904Subtractive() {

        assertEquals(904,calculator.evaluate(NINE_HUNDRED_AND_FOUR));
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

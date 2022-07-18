package com.leetcode.etc;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CalculatorTest {

    private static final String[] TESTCASES = new String[]{
            "10 + 4 - 3 - ( 3 - 5 ) * ( 10 + 3 * 5 ) ",
    };

    private static final double[] EXPECTED = new double[]{
            61.0,
    };

    @Test
    void calculate() {
        final Calculator calc = new Calculator();
        for (int i = 0; i < TESTCASES.length; i++) {
            final double actual = calc.calculate(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}
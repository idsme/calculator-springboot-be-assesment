package nl.thk.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
/** Simple test as these are all static final functions which keeps complexity low and thus easy to test **/
class CalculatorUtilTest {

    // Begin addition variants
    @Test
    void addDoubleNegative() {

        // Execute
        double result = CalculatorUtil.add(-11, -7);

        // Verify
        assertEquals(-18, result);
    }

    @Test
    void addNegativePositive() {

        // Execute
        double result = CalculatorUtil.add(-11, 7);

        // Verify
        assertEquals(-4, result);
    }

    @Test
    void addPositiveNegative() {

        // Execute
        double result = CalculatorUtil.add(11, -7);

        // Verify
        assertEquals(4, result);
    }

    @Test
    void addDoublePositive() {

        // Execute
        double result = CalculatorUtil.add(11, 7);

        // Verify
        assertEquals(18, result);
    }


    // Begin substract variants
    @Test
    void subtractDoubleNegative() {
        // Execute
        double result = CalculatorUtil.subtract(-11, -7);

        // Verify
        assertEquals(-4, result);
    }

    @Test
    void subtractPositiveNegative() {
        // Execute
        double result = CalculatorUtil.subtract(11, -7);

        // Verify
        assertEquals(18, result);
    }

    @Test
    void subtractNegativePositive() {
        // Execute
        double result = CalculatorUtil.subtract(-11, 7);

        // Verify
        assertEquals(-18, result);
    }

    @Test
    void subtractDoublePositive() {
        // Execute
        double result = CalculatorUtil.subtract(11, 7);

        // Verify
        assertEquals(4, result);
    }



    // Begin multiply variants
    @Test
    void multiplyDoubleNegative() {
        // Execute
        double result = CalculatorUtil.multiply(-11, -7);

        // Verify
        assertEquals(77.0, result);
    }

    @Test
    void multiplyPositiveNegative() {
        // Execute
        double result = CalculatorUtil.multiply(11, -7);

        // Verify
        assertEquals(-77.0, result);
    }

    @Test
    void multiplyNegativePositive() {
        // Execute
        double result = CalculatorUtil.multiply(-11, 7);

        // Verify
        assertEquals(-77.0, result);
    }

    @Test
    void multiplyDoublePositive() {
        // Execute
        double result = CalculatorUtil.multiply(11, 7);

        // Verify
        assertEquals(77.0, result);
    }

    @Test
    void multiplyMaxDoublePositive() {
        // Execute
        double result = CalculatorUtil.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);

        // Verify
        assertEquals(4.6116860141324206E18, result);
    }


    // Begin divide variants
    @Test
    void divideDoubleNegative() {
        // Execute
        double result = CalculatorUtil.divide(-11, -7);

        // Verify
        assertEquals(1.5714285714285714, result);
    }

    @Test
    void dividePositiveNegative() {
        // Execute
        double result = CalculatorUtil.divide(11, -7);

        // Verify
        assertEquals(-1.5714285714285714, result);
    }

    @Test
    void divideNegativePositive() {
        // Execute
        double result = CalculatorUtil.divide(-11, 7);

        // Verify
        assertEquals(-1.5714285714285714, result);
    }

    @Test
    void divideDoublePositive() {
        // Execute
        double result = CalculatorUtil.divide(11, 7);

        // Verify
        assertEquals(1.5714285714285714, result);
    }

    @Test
    void divideZeroPositive() {
        // Execute
        double result = CalculatorUtil.divide(0, 7);

        // Verify
        assertEquals(0, result);
    }

}
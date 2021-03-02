package nl.thk.api.utils;

/**
 * Pure functions no need for a bean.
 * As their is no state
 */
public class CalculatorUtil {

    public static final double add(int a, int b) {
        // answer can be larger then integer max value thus cast
        return (double)a + (double)b;
    }

    public static final double subtract(int a, int b) {
        // answer can be larger then integer max value thus cast
        return (double)a - (double)b;
    }


    public static final double multiply(int a, int b) {
        // if you don't cast to double... you won't get precision accurate decimal values.
        return (double)a * (double)b;
    }


    public static final double divide(int a, int b) {
        // if you don't cast to double... you won't get precision accurate decimal values.
        return (double)a / (double)b;
    }

}

package shared;

import static java.lang.System.*;

/**
 * Helper.java
 * The Helper class provides utility methods for text formatting, screen
 * manipulation,
 * and visual presentation in the payroll management system. Includes number
 * formatting,
 * cursor control, color application, and section display utilities.
 * 
 * @author Eddie C.
 * @version 1.8
 * @since 2025-10-24
 */

public class Helper {

    /**
     * Formats a decimal number to two decimal places with grouping separators.
     * Returns a string representation of the number formatted according to the
     * default locale's number formatting rules.
     *
     * @param decimal the decimal number to be formatted
     * @return a formatted string representation of the number with two decimal
     *         places and grouping separators (commas for thousands)
     * 
     * 
     * @example
     *          // Returns "1,234.56"
     *          formatTwoDecimals(1234.56789);
     * 
     * @example
     *          // Returns "0.00"
     *          formatTwoDecimals(0.0);
     * 
     * @example
     *          // Returns "999,999.99"
     *          formatTwoDecimals(999999.9994);
     */
    public static String formatTwoDecimals(double decimal) {
        return String.format("%,.2f", decimal);
    }

    /** This javadoc was generate with AI Assistance - Deepseek. 
     * Formats a decimal number as currency with two decimal places, grouping
     * separators, and a dollar sign prefix. The formatting follows the default
     * locale's rules for number formatting.
     *
     * @param decimal the decimal number to be formatted as currency
     * @param spaces  the minimum number of characters for the integer portion,
     *                including grouping separators. If the actual number requires
     *                more space, it will expand beyond this minimum.
     * @return a formatted currency string with dollar sign, grouping separators,
     *         and two decimal places
     * 
     * @example
     *          // Returns "$ 1,234.56" (with 7 spaces for integer portion)
     *          formatCurrency(1234.56789, 7);
     * 
     * @example
     *          // Returns "$ 0.00" (with 8 spaces for integer portion)
     *          formatCurrency(0.0, 8);
     * 
     * @example
     *          // Returns "$ 999,999.99" (with 2 spaces, but expands for larger
     *          number)
     *          formatCurrency(999999.9994, 2);
     * 
     * @example
     *          // Returns "$ -123.45" (with 7 spaces for negative number)
     *          formatCurrency(-123.456, 7);
     */
    public static String formatCurrency(double decimal, int spaces) {
        return String.format("$ %," + spaces + ".2f", decimal);
    }

    /**
     * Clears the console screen using the OS' terminal command.
     * This method works on most Unix-based terminals and Windows Command Prompt
     * with ANSI support enabled.
     */
    public static void clearScreen() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            // Handle any exceptions, such as IOException or InterruptedException
            e.printStackTrace();
            out.print("\033[H\033[2J");
            out.flush();
        }

    }

}

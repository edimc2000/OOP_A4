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
 * @version 1.6
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
        return String.format("$ %,.2f", decimal);
    }

     /**
     * Clears the console screen using ANSI escape codes.
     * This method works on most Unix-based terminals and Windows Command Prompt
     * with ANSI support enabled.
     */
    public static void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

}

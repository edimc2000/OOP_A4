package src;

import static java.lang.System.*;
import shared.Helper;

/**
 * BankAccountDriver.java
 * Test driver for banking system with multiple account types and transactions.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-09
 */

public class BankAccountDriver {
    /** Flag to control screen clearing behavior */
    public static boolean isClearScreen = false;

    /**
     * Main method to run banking system tests.
     * 
     * @param args command line arguments for test selection
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            noArgs();
        }

        if (args.length != 0) {
            out.println("\n" + "_".repeat(100));

            switch (args[0]) {

                case "savings":
                    savingsTest();
                    break;

                case "interest":
                    savingsWithInterest();
                    break;

                case "check":
                    checkTransactions();
                    break;

                case "compare":
                    compareAccounts();
                    break;

                default:
                    out.println("invalid parameter");

            }
        }

    }

    /** Runs sample tests from material. */
    public static void noArgs() {
        clearScreenIfNeeded();
        int bankAccountSampleArrLen = 100;

        // below are from the material - sample output
        BankAccount[] accounts = new BankAccount[bankAccountSampleArrLen];

        accounts[0] = new Savings(1100, .05);
        accounts[0].deposit(100);
        accounts[0].withdraw(200);
        ((Savings) accounts[0]).addInterest();

        accounts[1] = new Checking(-100);
        accounts[1].deposit(50);

        accounts[2] = new Checking(200);
        accounts[2].withdraw(210);
        accounts[2].deposit(100);
        ((Checking) accounts[2]).writeACheck(50);

        out.println("\n\nThis is the sample display output from the material ");
        for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
            accounts[i].display();
        }

    }

    /** Tests savings account with multiple transactions. */
    public static void savingsTest() {
        clearScreenIfNeeded();

        out.println("Test Case: Savings with transactions ");
        Savings account1 = new Savings(100, 0.05);
        account1.setName("Melissa Gibbs");

        account1.addTransaction("opening", "2025-10-01", account1.getBalance());

        account1.addTransaction("deposit", "2025-10-01", 50);
        account1.addTransaction("deposit", "2025-10-02", 300);
        account1.addTransaction("withdrawal", "2025-10-02", 50);
        account1.addTransaction("withdrawal", "2025-10-02", 1000);
        account1.addTransaction("deposit", "2025-10-03", 500);

        account1.display();
        BankAccount.displayTransactions(account1.getTransactions());

    }

    /** Tests savings account with interest calculations. */
    public static void savingsWithInterest() {
        clearScreenIfNeeded();

        out.println("Test Case: Savings with Interest ");
        Savings account1 = new Savings(600, 0.05);
        account1.setName("Janno Gibbs");

        account1.addTransaction("opening", "2025-09-30", account1.getBalance());
        account1.addTransaction("deposit", "2025-10-01", 100);

        account1.addTransaction("interest", "2025-11-02", account1.interestAmount());
        account1.addTransaction("withdrawal", "2025-11-05", 25);

        account1.display();
        BankAccount.displayTransactions(account1.getTransactions());

    }

    /** Tests checking account with check writing functionality. */
    public static void checkTransactions() {
        clearScreenIfNeeded();
        out.println("Test Case: Checking account with transactions  ");
        Checking account1 = new Checking(1000);
        account1.setName("Janno Gibbs");

        account1.addTransaction("opening", "2025-09-30", account1.getBalance());
        account1.addTransaction("deposit", "2025-10-01", 100);

        account1.writeACheck(20, "2025-10-02");
        account1.writeACheck(2000, "2025-10-02");

        // account1.addTransaction("withdrawal", "2025-10-25", 1500);
        account1.addTransaction("deposit", "2025-10-30", 10000);

        account1.writeACheck(20, "2025-10-02");

        account1.display();
        BankAccount.displayTransactions(account1.getTransactions());
    }

    /** Tests equality of two accounts account with check writing functionality. */
    public static void compareAccounts() {
        clearScreenIfNeeded();

        out.println("Test Case: Comparing two accounts for equality  ");
        Checking checking1 = new Checking(1000);
        Checking checking3 = new Checking(800);

        Savings savings1 = new Savings(1000, 0.01);
        Savings savings2 = new Savings(1000, 0.01);
        Savings savings3 = new Savings(999, 0.01);

        compareEquality(savings1, checking1, "Testing for equality - two different account types, same balance");
        compareEquality(savings1, checking3, "Testing for equality - two different account types, different balances");
        compareEquality(savings1, savings2, "Testing for equality - two accounts, same type, same balance amount");
        compareEquality(savings1, savings3, "Testing for equality - two accounts, same type, different balances");
        
    }

    /** Clears screen if enabled by isClearScreen flag. */
    private static void clearScreenIfNeeded() {
        if (isClearScreen) {
            Helper.clearScreen();
        }
    }

    /** Equality testing */
    private static void compareEquality(BankAccount acct1, BankAccount acct2, String testDescription) {
        out.println("\n" + testDescription);
        out.println(String.format(" Account 1 Type : %s \tBalance : %s \n Account 2 Type : %s \tBalance : %s ",
                acct1.getAccountType(),
                Helper.formatCurrency(acct1.getBalance(), 1),
                acct2.getAccountType(),
                Helper.formatCurrency(acct2.getBalance(), 1)));
        out.println(String.format(" Account 1 equals Account 2 ? : %s",
                acct1.equals(acct2)));
        out.println();
    }
}

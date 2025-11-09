package src;

import static java.lang.System.*;
import java.util.Arrays;

import shared.Helper;

public class BankAccountDriver {
    public static void main(String[] args) {
        if (args.length == 0) {
            NoArgs();
        }

        if (args != null && args.length != 0) {
            out.println("DEBUG: args [0] = " + args[0]);
            out.println("DEBUG:  args => " + Arrays.toString(args));

            switch (args[0]) {

                case "savings":
                    savingsTest();
                    break;

                case "interest":
                    savingsWithInterest();
                    break;

                case "check":
                    checkTest();
                    break;

                default:
                    out.println("invalid parameter");

            }
        }

        if (args != null && args.length == 0) {
            out.println("DEBUG: args length = " + args.length + " args => " + Arrays.toString(args));

        }

    }

    public static void NoArgs() {
        // below are from the material - sample out put
        Helper.clearScreen();
        BankAccount[] accounts = new BankAccount[100];

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

    public static void savingsTest() {
        Helper.clearScreen();
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
        account1.displayTransactions();

    }

    public static void savingsWithInterest() {
        Helper.clearScreen();
        out.println("Test Case: Savings with Interest ");
        Savings account1 = new Savings(600, 0.05);
        account1.setName("Janno Gibbs");

        account1.addTransaction("opening", "2025-09-30", account1.getBalance());
        account1.addTransaction("deposit", "2025-10-01", 100);

        account1.addTransaction("interest", "2025-11-02", account1.interestAmount());
        account1.addTransaction("withdrawal", "2025-11-05", 25);

        account1.display();
        account1.displayTransactions();

    }

    public static void checkTest() {
        Helper.clearScreen();
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
        account1.displayTransactions();

    }
}

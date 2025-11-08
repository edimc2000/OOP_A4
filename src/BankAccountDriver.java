package src;

import static java.lang.System.*;
import java.util.Arrays;

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
                default:

            }
        }

        if (args != null && args.length == 0) {
            out.println("DEBUG: args length = " + args.length + " args => " + Arrays.toString(args));

        }

    }

    public static void NoArgs() {
        // below are from the material - sample out put
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
        out.println("case Savings Test with transactions ");
        Savings account1 = new Savings(100, 0.05);
        account1.setName("Eddie Cabangon");

        account1.display();

        account1.addTransaction("deposit", "2025-10-01", 500);
        account1.addTransaction("deposit", "2025-10-02", 300);
        account1.addTransaction("withdrawal", "2025-10-02", 50);
        account1.addTransaction("withdrawal", "2025-10-02", 1000);
        account1.addTransaction("deposit", "2025-10-03", 500);
        

        account1.displayTransactions();
        account1.display();
    }
}

/**
 * accounts[3] = new Checking(200);
 * accounts[3].withdraw(2000);
 * accounts[3].deposit(100);
 * ((Checking) accounts[3]).writeACheck(50);
 * 
 * accounts[3].setName("Eddie");
 */
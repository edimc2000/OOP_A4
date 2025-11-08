package src;

import static java.lang.System.*;
import java.util.Arrays;

public class BankAccountDriver {
    public static void main(String[] args) {

        if (args != null) {
            out.println("DEBUG: args length = " + args.length + " args => " + Arrays.toString(args));
        } else {
            out.println("null");
        }

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

        accounts[3] = new Checking(200);
        accounts[3].withdraw(2000);
        accounts[3].deposit(100);
        ((Checking) accounts[3]).writeACheck(50);

        accounts[3].setName("Eddie");

        for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
            accounts[i].display();
        }

    }

}

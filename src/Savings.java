package src;

import static java.lang.System.*;

import shared.Helper;

public class Savings extends BankAccount {

    private double intRate = 0.0;

    public Savings(double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);

    }

    public void setIntRate(double interestRate) {
        this.intRate = interestRate;
    }

    // interest amount
    public void addInterest() {
        out.println("\n-------------- add interest method");
        out.println("The  balance is \t\t: " + this.getBalance());
        this.setBalance(this.getBalance() * (1 + intRate));
        out.println("The current balance is \t\t: " + this.getBalance() + "\n--------------");
    }

    public void display() {
        out.println("Savings Account");
        out.println("Account Balance \t\t: " + Helper.formatTwoDecimals(getBalance()));

    }

}

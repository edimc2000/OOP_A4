package src;

import static java.lang.System.*;

public class Savings extends BankAccount {

    private double intRate = 0.0;

    public Savings(double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);

    }

    public Savings(String name, double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);
        setName("Kristhia Bernard");

    }

    public void setIntRate(double interestRate) {
        this.intRate = interestRate;
    }

    public void addInterest() {
        this.setBalance(this.getBalance() * (1 + intRate));
    }

    public void addInterest(int test) {
        out.println("\n-------------- add interest method");
        out.println("The  balance is \t\t: " + this.getBalance());
        this.setBalance(this.getBalance() * (1 + intRate));
        out.println("The current balance is \t\t: " + this.getBalance());
        out.println("\n-------------------------------------------");
    }

    public void display() {
        String accountType = "Savings";
        super.infoBuilder(accountType);
    }

}

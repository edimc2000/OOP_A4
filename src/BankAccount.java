package src;

import static java.lang.System.*;

import shared.Helper;

public abstract class BankAccount {

    public BankAccount() {

    }

    private double balance = 0;
    private String accountName;

    public BankAccount(double balance) {
        this.balance = balance < 0 ? 0 : balance;

    }

    public String getName() {
        return this.accountName;
    }

    public void setName(String name) {
        this.accountName = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) {
        out.println("\n-------------- DEPOSIT");
        out.println("The  balance is \t\t: " + this.balance);
        out.println("Depositing \t\t\t: " + amount + "\n");

        this.balance += amount;

        out.println("The current balance is  \t: " + this.balance);
        out.println("\n-------------------------------------------");
    }

    public void withdraw(double amount) {
        out.println("\n-------------- WITHDRAWAL");
        out.println("The  balance is \t\t: " + this.balance);
        out.println("Withdrawing \t\t\t: " + amount + "\n");

        this.balance -= amount;
        this.balance = this.balance < 0 ? 0 : this.balance;

        out.println("The current balance is  \t: " + this.balance);
        out.println("\n-------------------------------------------");
    }

    public void infoBuilder(String accountType) {
        String info;
        accountType = accountType + " Account";

        String showName = "Name\t\t: " + this.getName();
        String balance = "Balance\t: " + Helper.formatTwoDecimals(getBalance());

        String showNameTemplate = (this.getName() != null) ? "\n%s \n %s\n %s\n" : "\n%s \n %s\n";

        info = (this.getName() != null)
                ? String.format(showNameTemplate, accountType, showName, balance)
                : String.format(showNameTemplate, accountType, balance);
        
        out.println(info);
    }

    public abstract void display();
}
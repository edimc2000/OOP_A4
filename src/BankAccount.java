import static java.lang.System.*;

public abstract class BankAccount {

    public BankAccount() {

    }

    private double balance = 0;

    public BankAccount(double balance) {
        this.balance = balance;

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

        out.println("The current balance is  \t: " + this.balance + "\n--------------");
    }

    public void withdraw(double amount) {
        out.println("\n-------------- WITHDRAWAL");
        out.println("The  balance is \t\t: " + this.balance);
        out.println("Withdrawing \t\t\t: " + amount + "\n");

        this.balance -= amount;

        out.println("The current balance is  \t: " + this.balance + "\n--------------");
    }

    public abstract void display();
}
package src;

import static java.lang.System.*;

import java.util.ArrayList;

import shared.Helper;

public abstract class BankAccount {

    private double balance = 0;
    private String accountName;
    private ArrayList<Transaction> transactions = new ArrayList<>();

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
        this.balance += amount;
    }

    public void addTransaction(String transaction, String date, double amount) {
        switch (transaction) {
            case "deposit":
                this.deposit(amount);
                break;
            case "withdrawal":
                this.withdraw(amount);
                break;
        }

        transactions.add(new Transaction(transaction, date, amount, getBalance()));
    }

    // Helper method to display all transactions
    public void displayTransactions() {
        out.println(String.format("%-15s %-20s %-20s %-20s\n",
                "Date", "Transaction", "Amount", "Running Balance"));

        for (Transaction lineItem : transactions) {
            String transactionType = lineItem.getType().substring(0, 1).toUpperCase() +
                    lineItem.getType().substring(1);
            out.println(String.format("%-15s %-20s $ %-18.2f $ %-20.2f",
                    lineItem.getDate(),
                    transactionType,
                    lineItem.getAmount(),
                    lineItem.getBalanceAfter()));
        }
    }

    public void withdraw(double amount) {

        this.balance -= amount;
        this.balance = this.balance < 0 ? 0 : this.balance;

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
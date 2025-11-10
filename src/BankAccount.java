package src;

import static java.lang.System.*;
import java.util.ArrayList;
import shared.Helper;

/**
 * BankAccount.java
 * Abstract bank account with basic banking operations.
 * 
 * @author Eddie C.
 * @version 1.8
 * @since 2025-11-09
 */

public abstract class BankAccount {

    /** Current account balance */
    private double balance = 0;

    /** * Displays account information */
    public abstract void display();

    /**
     * Account type identifier (e.g., "Savings", "Checking")
     */
    private String accountType;

    /**
     * Sets the account type.
     * 
     * @param accountType the type of account (e.g., "Savings", "Checking")
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Gets the account type.
     * 
     * @return the account type (e.g., "Savings", "Checking")
     */
    public String getAccountType() {
        return this.accountType;
    }

    /**
     * Withdraws amount from account
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            return; // ignore 0 and negative numbers
        }

        this.balance -= amount;

        // prevents negative balance
        if (this.balance < 0) {
            this.balance = 0;
        }
    }

    /**
     * Deposits amount into account
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Constructs bank account with initial balance
     * 
     * @param balance the starting balance
     */
    public BankAccount(double balance) {
        this.balance = balance < 0 ? 0 : balance;
    }

    /** Additional variables and methods to enhance functionality */

    /** Account holder name */
    private String accountName;

    /** List of account transactions */
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * Gets transaction list
     * 
     * @return list of transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    /**
     * Gets account name
     * 
     * @return the account name
     */
    public String getName() {
        return this.accountName;
    }

    /**
     * Sets account name
     * 
     * @param name the account name
     */
    public void setName(String name) {
        this.accountName = name;
    }

    /**
     * Gets account balance
     * 
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sets account balance
     * 
     * @param amount the new balance amount
     */
    public void setBalance(double amount) {
        this.balance = amount;
    }

    /**
     * Adds transaction to account
     * 
     * @param transactionType the type of transaction
     * @param date            the transaction date
     * @param amount          the transaction amount
     */
    public void addTransaction(String transactionType, String date, double amount) {
        switch (transactionType) {
            case "opening":
                break;
            case "interest":
                this.deposit(amount);
                break;
            case "deposit":
                this.deposit(amount);
                break;
            case "withdrawal":
            case "check":
            case "chk svc charge":
                this.withdraw(amount);
                break;
        }
        transactionType = transactionType.substring(0, 1).toUpperCase() +
                transactionType.substring(1);
        transactions.add(new Transaction(transactionType, date, amount, getBalance()));
    }

    /**
     * Displays all transactions
     * 
     * @param listOfTransactions the transactions to display
     */
    public static void displayTransactions(ArrayList<Transaction> listOfTransactions) {
        out.println(String.format("%-15s %-20s %11s %8s %s",
                " Date", "Transaction", "Amount", "", "Running Balance"));
        out.println(String.format(" %-14s %-21s %10s %3s %s",
                "-".repeat(10), "-".repeat(11), "-".repeat(15), "", "-".repeat(15)));
        for (Transaction lineItem : listOfTransactions) {
            out.println(lineItem);
        }
        out.println("\n");
    }

    /**
     * Returns formatted string representation of account information.
     * Format includes account type, name (if present), and current balance.
     * 
     * @return formatted account information string
     * 
     * @example
     * 
     *          <pre>
     * Savings Account 
     *  Name    : John Doe
     *  Balance : $1,000.00
     *          </pre>
     * 
     */
    @Override
    public String toString() {
        String info;
        String accountType = getAccountType() + " Account";

        String showName = "Name\t\t: " + this.getName();
        String balance = "Balance\t: " + Helper.formatCurrency(getBalance(), 1);

        String showNameTemplate = (this.getName() != null) ? "\n%s \n %s\n %s\n" : "\n%s \n %s\n";

        info = (this.getName() != null)
                ? String.format(showNameTemplate, accountType, showName, balance)
                : String.format(showNameTemplate, accountType, balance);

        return info;
    }

    /**
     * Compares this bank account with another object for equality.
     * Two accounts are equal if they are the same type and have the same balance.
     * 
     * @param obj the object to compare with
     * @return true if the accounts have the same balance and type, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        BankAccount that = (BankAccount) obj;
        return Double.compare(that.getBalance(), getBalance()) == 0;

    }
}
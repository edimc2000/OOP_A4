package src;

import static java.lang.System.*;

/**
 * Savings account with interest rate functionality.
 * 
 * @author Eddie C.
 * @version 1.8
 * @since 2025-11-09
 */
public class Savings extends BankAccount {

    /** interest rate as decimal */
    private double intRate = 0.0;

    /**
     * Constructs savings account with balance and interest rate and default account type..
     * 
     * @param balance      the starting balance
     * @param interestRate the annual interest rate
     */
    public Savings(double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);
        setAccountType("Savings");
    }

    /**
     * Constructs named savings account with balance and interest rate.
     * 
     * @param name         the account holder name
     * @param balance      the starting balance
     * @param interestRate the annual interest rate
     */
    public Savings(String name, double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);
        setName(name);
    }

    /**
     * Sets interest rate.
     * 
     * @param interestRate the annual interest rate
     */
    public void setIntRate(double interestRate) {
        this.intRate = interestRate;
    }

    /**
     * Gets interest rate.
     * 
     * @return the current interest rate
     */
    public double getIntRate() {
        return this.intRate;
    }

    /**
     * Adds earned interest to account balance.
     */
    public void addInterest() {
        double interest = interestAmount();
        this.setBalance(this.getBalance() + interest);
    }

    /**
     * Calculates interest amount.
     * 
     * @return the interest amount
     */
    public double interestAmount() {
        return this.getBalance() * intRate;
    }

    /**
     * Displays savings account information.
     */
    @Override
    public void display() {
        out.println(this);
    }
}
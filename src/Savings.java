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

        this.setBalance(this.getBalance() * (1 - intRate));
    }

    public void display() {
        out.println("Savings Account");
        out.println(getBalance());
        out.println(Helper.formatTwoDecimals(20));

    }

}

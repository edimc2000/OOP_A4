public class BankAccount {

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

}
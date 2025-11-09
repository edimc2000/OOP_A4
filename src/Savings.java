package src;



public class Savings extends BankAccount {

    private double intRate = 0.0;

    public Savings(double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);

    }

    public Savings(String name, double balance, double interestRate) {
        super(balance);
        setIntRate(interestRate);
        setName(name);

    }

    public void setIntRate(double interestRate) {
        this.intRate = interestRate;
    }

    public void addInterest() {
        this.setBalance(this.getBalance() * (1 + intRate));
    }


   public double interestAmount() {
        return this.getBalance() *  intRate;
    }


    public void display() {
        String accountType = "Savings";
        this.infoBuilder(accountType);
    }

}

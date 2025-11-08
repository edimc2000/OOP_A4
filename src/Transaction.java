package src;
public class Transaction {
    private String type;
    private String date;
    private double amount;
    private double balanceAfter;
    
    public Transaction(String type, String date, double amount, double balanceAfter) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }
    
    // Getters
    public String getType() { return type; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public double getBalanceAfter() { return balanceAfter; }
    
    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | Balance: $%.2f", 
                           date, type, amount, balanceAfter);
    }
}
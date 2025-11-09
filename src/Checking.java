package src;

import static java.lang.System.*;
import shared.Helper;

public class Checking extends BankAccount {

  private static final double serviceFee = 1;

  public Checking(double balance) {
    super(balance);
  }

  public double writeACheck(double amount, String date) {
    this.addTransaction("check", date, amount);
    this.addTransaction("svc charge", date, Checking.serviceFee);
    return amount + 1 ;
  }

  public void writeACheck(double amount) {
    setBalance(getBalance() - amount - Checking.serviceFee);
  }

  public void display() {
    String accountType = "Checking";
    super.infoBuilder(accountType);

  }
}

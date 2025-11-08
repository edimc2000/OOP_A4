package src;

import static java.lang.System.*;
import shared.Helper;

public class Checking extends BankAccount {

  private static final double serviceFee = 1;

  public Checking(double balance) {
    super(balance);
  }

  public void writeACheck(double amount) {
    setBalance(getBalance() - amount - Checking.serviceFee);

  }

  public void writeACheck(double amount, boolean showDetail) {
    out.println("Checking Account");
    out.println("\n-------------- check amount " + amount);
    setBalance(getBalance() - amount - Checking.serviceFee);
    out.println("Account Balance \t\t: " + Helper.formatTwoDecimals(getBalance()));
    out.println("\n-------------------------------------------");

  }

  public void display() {
    String accountType = "Checking";
    super.infoBuilder(accountType);

  }
}

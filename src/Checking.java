package src;

import static java.lang.System.*;

/**
 * Checking account with check writing and service fee functionality.
 * 
 * @author Eddie C.
 * @version 1.8
 * @since 2025-11-09
 */
public class Checking extends BankAccount {

  /** Service fee for check transactions */
  private static final double serviceFee = 1;

  /** Unknown date for check transactions */
  private static final String UNKNOWN_DATE = "****-**-**";

  /**
   * Constructs checking account with initial balance.
   * 
   * @param balance the starting balance
   */
  public Checking(double balance) {
    super(balance);
  }

  /**
   * Writes a check, deducting amount plus service fee.
   * 
   * @param amount the check amount
   */
  public void writeACheck(double amount) {
    this.addTransaction("check", getUnknownDate(), amount);
    this.addTransaction("svc charge", getUnknownDate(), getServiceFee());
  }

  /**
   * Writes a check with transaction recording.
   * 
   * @param amount the check amount
   * @param date   the transaction date
   * @return total amount deducted (check amount + service fee)
   */
  public double writeACheck(double amount, String date) {
    this.addTransaction("check", date, amount);
    this.addTransaction("chk svc charge", date, getServiceFee());
    return amount + getServiceFee();
  }

  /**
   * Gets the service fee amount.
   * 
   * @return the unkown date format string
   */
  public static String getUnknownDate() {
    return UNKNOWN_DATE;
  }

  /**
   * Gets the service fee amount.
   * 
   * @return the current service fee
   */
  public static double getServiceFee() {
    return serviceFee;
  }

  /**
   * Displays checking account information.
   */
  @Override
  public void display() {
    this.setAccountType("Checking");
    out.println(this);
  }
}
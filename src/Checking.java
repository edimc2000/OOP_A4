package src;
import static java.lang.System.*;
import shared.Helper;

public class Checking extends BankAccount {

private static final double serviceFee = 1; 

  public Checking(double balance) {
    super(balance);

  }
  
    public void display() {

      
        out.println("checking Account");
        out.println("Account Balance \t\t: " + Helper.formatTwoDecimals(getBalance()));

    }


    public void writeACheck (double amount ){
 out.println("\n-------------- check amount " + amount);
      setBalance(getBalance() - amount - Checking.serviceFee); 
out.println("Account Balance \t\t: " + Helper.formatTwoDecimals(getBalance()));
    } 


    
}

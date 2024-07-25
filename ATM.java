import java.util.Scanner;

class BankAccount {
  private double bal;

  public BankAccount(double bal) {
    this.bal = bal;
  }

  public double getBalance() {
    return bal;
  }
 
  public void withdraw(double amt) {
    bal -= amt;
  }

  public void deposit(double amt) {
    bal += amt;
  }
}

public class ATM {
  private BankAccount account;

  public ATM(BankAccount account) {
    this.account = account;
  }

  public void withdraw(double amt) {
    if (account.getBalance() >= amt) {
      account.withdraw(amt);
      System.out.println("Withdrawal successful. New balance: " + account.getBalance());
    } else {
      System.out.println("Insufficient balance.");
    }
  }

  public void deposit(double amt) {
    account.deposit(amt);
    System.out.println("Deposit successful. New bal: " + account.getBalance());
  }

  public void checkBalance() {
    System.out.println("Current bal: " + account.getBalance());
  }

  public static void main(String[] args) {
    BankAccount account = new BankAccount(1000.0); 
    ATM atm = new ATM(account);

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("ATM Menu:");
      System.out.println("1: Withdraw");
      System.out.println("2: Deposit");
      System.out.println("3: Check Balance");
      System.out.println("4: Exit");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter amount to withdraw: ");
          double amt = scanner.nextDouble();
          atm.withdraw(amt);
          break;
        case 2:
          System.out.print("Enter amount to deposit: ");
          amt = scanner.nextDouble();
          atm.deposit(amt);
          break;
        case 3:
          atm.checkBalance();
          break;
        case 4:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
}

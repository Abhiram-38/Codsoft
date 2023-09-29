import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your account balance is Rs " + balance);
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: Rs ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (bankAccount.deposit(depositAmount)) {
                        System.out.println("Rs" + depositAmount + " deposited successfully.");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case "3":
                    System.out.print("Enter the amount to withdraw: Rs ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Rs" + withdrawAmount + " withdrawn successfully.");
                    } else {
                        System.out.println("Invalid withdrawal amount or insufficient balance.");
                    }
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: Rs ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
	}
}

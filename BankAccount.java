import java.util.Scanner;


interface BankWork {
    void deposit(double money);
    void withdraw(double money) throws BalanceException;
    void checkBalance();
}

// Interface for customer details
interface CustomerWork {
    void showCustomerDetails();
}

// Custom exception
class BalanceException extends Exception {
    BalanceException(String msg) {
        super(msg);
    }
}

// BankAccount class implementing multiple interfaces
class BankAccount implements BankWork, CustomerWork {

    private String name;
    private int accNo;
    private double balance;


    BankAccount(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += money;
        System.out.println("Money deposited successfully");
    }

    public void withdraw(double money) throws BalanceException {
        if (money <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        if (money > balance) {
            throw new BalanceException("Insufficient balance");
        }
        balance -= money;
        System.out.println("Money withdrawn successfully");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Show customer details
    public void showCustomerDetails() {
        System.out.println("\nCustomer Name: " + name);
        System.out.println("Account Number: " + accNo);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankInterfaceProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Create Bank Account");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(name, accNo, balance);

        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Customer Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        acc.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        acc.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        acc.checkBalance();
                        break;

                    case 4:
                        acc.showCustomerDetails();
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Wrong choice");
                }
            } catch (BalanceException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}

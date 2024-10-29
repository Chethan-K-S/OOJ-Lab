import java.util.*;

abstract class Account {
    String customerName;
    int accountNumber;
    double balance;
    String accountType;

    Account(String customerName, int accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    abstract void computeInterest();

    abstract void withdraw(double amount);
}

class SavAcct extends Account {
    final double interestRate = 0.04;

    SavAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    @Override
    void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added. Updated balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class Cheque {
    int chequeNumber;
    double amount;
    String status;
    Date issueDate;
    Date postDate;

    Cheque(int chequeNumber, double amount, Date issueDate, Date postDate) {
        this.chequeNumber = chequeNumber;
        this.amount = amount;
        this.issueDate = issueDate;
        this.postDate = postDate;
        this.status = "Issued";
    }
}

class CurAcct extends Account {
    final double minimumBalance = 1000.0;
    final double penalty = 50.0;
    Cheque[] chequeHistory = new Cheque[100];
    int chequeCount = 0;
    int nextChequeNumber = 1001;

    CurAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    void chequeBookFacility() {
        System.out.println("Cheque book facility is available for Current Account.");
    }

    void issueCheque(double amount, Date postDate) {
        if (chequeCount >= chequeHistory.length) {
            System.out.println("Cheque book limit reached. No more cheques can be issued.");
            return;
        }

        if (balance >= amount) {
            Cheque cheque = new Cheque(nextChequeNumber++, amount, new Date(), postDate);
            chequeHistory[chequeCount++] = cheque;
            balance -= amount;
            System.out.println("Cheque #" + cheque.chequeNumber + " issued for " + amount + ". Updated balance: " + balance);
            if (balance < minimumBalance) {
                balance -= penalty;
                System.out.println("Balance below minimum. Penalty imposed. Updated balance: " + balance);
            }
        } else {
            System.out.println("Insufficient balance to issue cheque.");
        }
    }

    void stopCheque(int chequeNumber) {
        for (int i = 0; i < chequeCount; i++) {
            if (chequeHistory[i].chequeNumber == chequeNumber && chequeHistory[i].status.equals("Issued")) {
                chequeHistory[i].status = "Stopped";
                balance += chequeHistory[i].amount;
                System.out.println("Cheque #" + chequeNumber + " stopped. Amount " + chequeHistory[i].amount + " refunded. Updated balance: " + balance);
                return;
            }
        }
        System.out.println("Cheque #" + chequeNumber + " not found or already cleared.");
    }

    void displayChequeHistory() {
        System.out.println("Cheque History:");
        for (int i = 0; i < chequeCount; i++) {
            Cheque cheque = chequeHistory[i];
            System.out.println("Cheque #" + cheque.chequeNumber + " | Amount: " + cheque.amount + " | Status: " + cheque.status + 
                               " | Issue Date: " + cheque.issueDate + " | Post Date: " + cheque.postDate);
        }
    }

    @Override
    void computeInterest() {
        System.out.println("No interest for Current Account.");
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            if (balance < minimumBalance) {
                balance -= penalty;
                System.out.println("Balance below minimum. Penalty imposed. Updated balance: " + balance);
            } else {
                System.out.println("Withdrawal successful. Updated balance: " + balance);
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account type (1 for Savings, 2 for Current): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.println("Enter account number: ");
        int accNum = scanner.nextInt();

        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account;
        if (choice == 1) {
            account = new SavAcct(name, accNum, balance);
        } else {
            account = new CurAcct(name, accNum, balance);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            System.out.println("3. Compute Interest");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Cheque Book Facility (Current Account only)");
            System.out.println("6. Issue Cheque (Current Account only)");
            System.out.println("7. Stop Cheque (Current Account only)");
            System.out.println("8. Display Cheque History (Current Account only)");
            System.out.println("9. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    account.computeInterest();
                    break;
                case 4:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 5:
                    if (account instanceof CurAcct) {
                        ((CurAcct) account).chequeBookFacility();
                    } else {
                        System.out.println("Cheque book facility is not available for Savings Account.");
                    }
                    break;
                case 6:
                    if (account instanceof CurAcct) {
                        System.out.println("Enter cheque amount:");
                        double chequeAmount = scanner.nextDouble();
                        ((CurAcct) account).issueCheque(chequeAmount, new Date());
                    } else {
                        System.out.println("Cheque facility is not available for Savings Account.");
                    }
                    break;
                case 7:
                    if (account instanceof CurAcct) {
                        System.out.println("Enter cheque number to stop:");
                        int chequeNumber = scanner.nextInt();
                        ((CurAcct) account).stopCheque(chequeNumber);
                    } else {
                        System.out.println("Cheque facility is not available for Savings Account.");
                    }
                    break;
                case 8:
                    if (account instanceof CurAcct) {
                        ((CurAcct) account).displayChequeHistory();
                    } else {
                        System.out.println("Cheque history is not available for Savings Account.");
                    }
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Atm {

    private HashMap<UUID, Account> userAccounts;
    private Account currentAccount;

    public Atm () {
        userAccounts = new HashMap<>();
    }

    public void addAccount(Account account){
        userAccounts.put(UUID.randomUUID(), account);
    }

    public void showAccounts() {
        userAccounts.values().forEach(a -> System.out.println(a));
    }


    public boolean authenticate(Scanner scanner) {
        System.out.println("Enter your PIN");
        int pin = scanner.nextInt();

        for (Account userAccount : userAccounts.values()) {
            if (userAccount.getPin() == pin) {
                currentAccount = userAccount;
                System.out.println("Authenticated in account: " + currentAccount.getAccountNumber());
                return true;
            } 
        }
        return false;
    }

    public void showMenu(Scanner scanner){
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Check balance");
                    System.out.println("Current balance is: " + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Deposit money");
                    double amount = scanner.nextDouble();
                    currentAccount.addMoney(amount);
                    System.out.println("Balance after deposit:" + currentAccount.getBalance());
                    break;
                default:
                    System.out.println("No valid option");
                    break;
            }
        }
    }

}

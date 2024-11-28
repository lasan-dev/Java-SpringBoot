import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        // create ATM 

        // System components
            // User - represents the user of the atm with a bank account
            
            // Atm - Represents the machine user interacts to deposit or withdraw money
                // validate user - PIN
                // widraw money for authenticated user
                // deposit money for authenticated user
            
            // Account - Represents the bank account 
                // Balance - amount of money


            Scanner scanner = new Scanner(System.in);

            Atm atm = new Atm();
            //atm.showMenu(scanner);

            User user1 = new User("John");
            User user2 = new User("Doe");

            Account account1 = new Account(user1, 1000, 12345);
            Account account2 = new Account(user2, 100, 54321);

            // Add accounts
            atm.addAccount(account1);
            atm.addAccount(account2);

        // Authenticate user
        boolean authenticated = false;
        while (!authenticated) {
            authenticated = atm.authenticate(scanner);
        }

        // Show the ATM menu
        atm.showMenu(scanner);

        scanner.close();
    }
}

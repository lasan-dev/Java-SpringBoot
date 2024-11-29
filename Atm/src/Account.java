import java.util.UUID;

public class Account {

    private UUID accountNumber;
    private double balance;
    private User user;
    private int pin;

    Account(User user, double initialAmount, int pin){
        balance = initialAmount;
        this.user = user;
        accountNumber = UUID.randomUUID();
        this.pin = pin;
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber.toString();
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber +  " | User account: " + user.getName();
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
}

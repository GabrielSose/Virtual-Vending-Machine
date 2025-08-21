import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Item> items;
    private double balance;

    public VendingMachine() {
        items = new ArrayList<>();
        balance = 0.0;

        // Add some sample items
        items.add(new Item("Chips", 1.50, 5));
        items.add(new Item("Soda", 1.25, 3));
        items.add(new Item("Candy", 0.75, 10));
    }

    public void insertMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Inserted $" + amount + ". Current balance: $" + balance);
        } else {
            System.out.println("Please insert a valid amount.");
        }
    }

    public void displayItems() {
        System.out.println("\nAvailable Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i));
        }
    }

    public void purchaseItem(int index) {
        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Item selected = items.get(index);

        if (selected.getQuantity() == 0) {
            System.out.println("Sorry, " + selected.getName() + " is out of stock.");
        } else if (balance >= selected.getPrice()) {
            balance -= selected.getPrice();
            selected.reduceQuantity();
            System.out.println("Dispensing " + selected.getName() + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. " + selected.getName() + " costs $" + selected.getPrice());
        }
    }

    public void refund() {
        System.out.println("Refunding $" + balance);
        balance = 0.0;
    }
}

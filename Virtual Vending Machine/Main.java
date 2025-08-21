import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to GABO's Vending Machine!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Insert Money");
            System.out.println("2. Display Items");
            System.out.println("3. Purchase Item");
            System.out.println("4. Refund");
            System.out.println("5. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to insert: $");
                    double amount = scanner.nextDouble();
                    vm.insertMoney(amount);
                    break;
                case 2:
                    vm.displayItems();
                    break;
                case 3:
                    vm.displayItems();
                    System.out.print("Enter item number to purchase: ");
                    int index = scanner.nextInt();
                    vm.purchaseItem(index);
                    break;
                case 4:
                    vm.refund();
                    break;
                case 5:
                    System.out.println("Thanks for using GABO's Vending Machine. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

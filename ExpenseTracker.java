import java.util.ArrayList;
import java.util.Scanner;

class ExpenseTracker {
    private ArrayList<Double> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addExpense() {
        System.out.print("Enter the amount of the expense: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        expenses.add(amount);
        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        System.out.println("List of expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". $" + expenses.get(i));
        }
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Double expense : expenses) {
            total += expense;
        }
        return total;
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = expenseTracker.scanner.nextInt();
            expenseTracker.scanner.nextLine(); 

            switch (choice) {
                case 1:
                    expenseTracker.addExpense();
                    break;
                case 2:
                    expenseTracker.viewExpenses();
                    break;
                case 3:
                    System.out.println("Total Expenses: Rs." + expenseTracker.getTotalExpenses());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        expenseTracker.closeScanner();
    }
}

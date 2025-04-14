import java.io.*;
import java.sql.Array;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        File expenseFile = new File("expenses.txt");
        try {
            if (!expenseFile.exists()) {
                expenseFile.createNewFile();
            } else {
                // Read and load existing expenses to ArrayList from txt file
                try (BufferedReader reader = new BufferedReader(new FileReader(expenseFile))) {
                    String[] parts = new String[4];
                    String line;
                    while ((line = reader.readLine()) != null) {
                            parts = line.split(",");
                            if (parts.length == 4) {
                            String expenseDate = parts[0];
                            String expenseDescription = parts[1];
                            String expenseCategory = parts[2];
                            double expenseAmount = Double.parseDouble(parts[3]);
                            ExpenseManager.expenseArrayList.add(new Expense(expenseDate, expenseDescription, expenseCategory, expenseAmount));
                        } else {
                            System.out.println("Skipping malformed line: " + line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error when reading the file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error when creating the file: " + e.getMessage());
        }

        boolean menuIsRunning = true;
        while (menuIsRunning) {
            System.out.println("\nWelcome to Expense Manager!");
            System.out.println("1. Add an expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Search expenses");
            System.out.println("4. Delete an expense");
            System.out.println("5. Exit");
            int menuInput = scanner.nextInt();
            scanner.nextLine();

            switch (menuInput) {
                case 1:
                    System.out.println("\nAdding an expense");
                    System.out.print("Date: ");
                    String inputDate = scanner.nextLine();
                    System.out.print("Description: ");
                    String inputDescription = scanner.nextLine();
                    System.out.print("Category: ");
                    String inputCategory = scanner.nextLine();
                    System.out.print("Amount: ");
                    double inputAmount = scanner.nextDouble();
                    scanner.nextLine();

                    expenseManager.addExpense(inputDate, inputDescription, inputCategory, inputAmount,
                                                expenseManager.expenseArrayList, expenseFile);
                    break;
                case 2:
                    System.out.println("\nDisplaying all expenses:");
                    expenseManager.displayAllExpenses(expenseManager.expenseArrayList);
                    break;
                case 3:
                    System.out.println("\nSearching expenses:");
                    expenseManager.searchExpense(expenseManager.expenseArrayList, scanner);
                    break;
                case 4:
                    System.out.println("\nDeleting an expense:");
                    expenseManager.deleteExpense(expenseManager.expenseArrayList, scanner, expenseFile);
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    menuIsRunning = false;
                    break;
                default:
                    System.out.println("\nEnter a valid input!");
                    break;
            }
        }
    }
}

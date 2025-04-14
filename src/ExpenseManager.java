import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    public static ArrayList<Expense> expenseArrayList = new ArrayList<>();

    public void addExpense(String inputDate, String inputDescription,
                                  String inputCategory, double inputAmount,
                                  ArrayList<Expense> expenseArrayList, File expenseFile) {
        Expense newExpense = new Expense(inputDate, inputDescription, inputCategory, inputAmount);
        expenseArrayList.add(newExpense);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(expenseFile, true))) {
            String concatenatedExpense = newExpense.getExpenseDate() + "," + newExpense.getExpenseDescription() + ","
                                        + newExpense.getExpenseCategory() + "," + newExpense.getExpenseAmount();
            writer.write(concatenatedExpense);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error when writing to the file: " + e.getMessage());
        }
    }

    public void displayAllExpenses(ArrayList<Expense> expenseArrayList) {
        if (!expenseArrayList.isEmpty()) {
            for (Expense expense: expenseArrayList) {
                System.out.println(expense);
            }
        } else {
            System.out.println("Nothing to display!");
        }
    }

    public void searchExpense(ArrayList<Expense> expenseArrayList, Scanner scanner) {
        ArrayList <Expense> foundExpensesArrayList = new ArrayList<>();
        boolean isFound = false;

        System.out.println("Would you like to search by date or category? (D/C)");
        char searchFormInput = scanner.nextLine().toUpperCase().charAt(0);
        System.out.println("\nEnter the value you would like to search: ");
        String inputValue = scanner.nextLine();
        switch (searchFormInput) {
            case 'D':
                for (Expense expense: expenseArrayList) {
                    if (expense.getExpenseDate().equalsIgnoreCase(inputValue)) {
                        foundExpensesArrayList.add(expense);
                        isFound = true;
                    }
                }
                break;
            case 'C':
                for (Expense expense: expenseArrayList) {
                    if (expense.getExpenseCategory().equalsIgnoreCase(inputValue)) {
                        foundExpensesArrayList.add(expense);
                        isFound = true;
                    }
                }
                break;
            default:
                System.out.println("Enter a valid input!");
                break;
        }
        if (isFound) {
            System.out.println("Results: ");
            for (Expense expense: foundExpensesArrayList) {
                System.out.println(expense);
            }
        } else {
            System.out.println("No matches found!");
        }
    }

    public void deleteExpense(ArrayList<Expense> expenseArrayList, Scanner scanner, File expenseFile) {
        for (int i = 0; i < expenseArrayList.size(); i++) {
            System.out.println("\nIndex: " + i);
            System.out.println(expenseArrayList.get(i));
        }

        System.out.println("Which expense would you like to delete? (Enter index value)");
        int indexInput = scanner.nextInt();
        scanner.nextLine();
        expenseArrayList.remove(indexInput);

        // Create a new ArrayList skipping the removed line
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(expenseFile))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                if (currentLine != indexInput) {
                    lines.add(line);
                }
                currentLine++;
            }
        } catch (IOException e) {
            System.out.println("Error when reading the file: " + e.getMessage());
        }
        // Overwrite the file without the removed one
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(expenseFile))) {
            for (String line: lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error when writing to file: " + e.getMessage());
        }
    }
}

public class Expense {
    private String expenseDate;
    private String expenseDescription;
    private String expenseCategory;
    private double expenseAmount;

    Expense(String expenseDate, String expenseDescription, String expenseCategory, double expenseAmount) {
     this.expenseDate = expenseDate;
     this.expenseDescription = expenseDescription;
     this.expenseCategory = expenseCategory;
     this.expenseAmount = expenseAmount;
    }
    public String getExpenseDate() {
        return expenseDate;
    }
    public String getExpenseDescription() {
        return expenseDescription;
    }
    public String getExpenseCategory() {
        return expenseCategory;
    }
    public double getExpenseAmount() {
        return expenseAmount;
    }
    @Override
    public String toString() {
        return "\nDate: " + getExpenseDate() +
                "\nDescription: " + getExpenseDescription() +
                "\nCategory: " + getExpenseCategory() +
                "\nAmount: " + getExpenseAmount();
    }
}

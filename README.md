# Personal Expense Tracker Assignment

## Overview
In this project, you will build a console-based expense tracking application in Java. The program will allow users to record, view, search, and delete expense entries. You will practice:

- Reading from and writing to files
- Handling exceptions
- Using basic Java concepts such as:
    - Classes and objects
    - Loops and conditional statements
    - Collections

## Requirements

### 1. Expense Model (POJO)
Create an `Expense` class with at least the following fields:

- **Date**: Use a `String` or `java.time.LocalDate` for the expense date.
- **Description**: A brief text to describe the expense.
- **Amount**: A `double` representing the cost.
- **Category**: Such as Food, Transportation, Entertainment, etc.

Include:
- Getters and setters
- A constructor
- An overridden `toString()` method for pretty-printing the details

---

### 2. User Interface (Console Menu)
When your program starts, present the user with a menu such as:

- Add an expense
- View all expenses
- Search expenses
- Delete an expense
- Exit

Additional requirements:

- Validate user input to ensure proper choices are made.
- Use loops to return to the main menu after completing an action.

---

### 3. Adding an Expense
- Prompt the user to enter the details for an expense.
- Instantiate an `Expense` object with user input.
- Add the new expense to a collection (e.g., `ArrayList<Expense>`).

---

### 4. Viewing Expenses
- Display all saved expenses in a user-friendly format.
- Format the output for easy reading (e.g., columns for Date, Description, Amount, Category).
- If no expenses exist, print an appropriate message.

---

### 5. Searching for Expenses
- Ask the user if they want to search by **date** or **category**.
- Accept the search query and display all expenses that match.

Search details:
- For **date**: Allow an exact match.
- For **category**: Ignore case (e.g., “food” matches “Food”).
- Handle cases where no records match.

---

### 6. Deleting an Expense
- List expenses with an index number.
- Ask the user which expense (by index) they would like to delete.
- Remove the selected expense from the collection.
- Handle invalid inputs (e.g., index out of bounds).

---

### 7. File I/O: Persistence

#### Saving Data
- When the program exits (or after every change), write the list of expenses to a plain text file (or CSV file).
- Use a simple format: each line represents one expense.

#### Loading Data
- At program startup, check if the file exists.
- If it does, read from the file and populate your expense collection.

Use:
- `BufferedReader` and `BufferedWriter`  
  or
- `Scanner` and `PrintWriter`

Also:
- Use `try-catch` blocks to manage potential file-related errors (e.g., file not found, I/O errors).

# Personal Expense Tracker

A console-based expense tracker written in Java. It lets you record expenses,
view them, search them, and delete them, with all data persisted to a local
text file so entries survive between runs.

## What it does

A text menu drives the program:

1. Add an expense (date, description, category, amount)
2. View all expenses
3. Search expenses by date or category
4. Delete an expense by index
5. Exit

On startup the program loads any existing entries from `expenses.txt`. Each
change is written back to the file, so the data is always persisted.

## Design

| Class | Responsibility |
|-------|----------------|
| `Expense` | Model for a single expense: date, description, category, amount, with a formatted `toString()` |
| `ExpenseManager` | Business logic: add, display, search, and delete expenses, plus reading and writing the data file |
| `UserInterface` | Entry point; loads the file, then runs the interactive menu loop |

## Concepts demonstrated

- File I/O with `BufferedReader` and `BufferedWriter` over a CSV-style format
- Exception handling for missing files, I/O errors, and malformed lines
- Collections (`ArrayList`) for in-memory storage
- Case-insensitive category search and exact-match date search
- Input validation and menu-driven control flow

## Data format

Expenses are stored one per line as comma-separated values:

```
date,description,category,amount
```

Malformed lines are skipped on load rather than crashing the program.

## Running it

```bash
javac src/*.java -d out
java -cp out UserInterface
```

Coursework project, Valencia College (Computer Programming and Analysis).

_This README.md file was created with assistance from AI - GitHub Copilot. The remaining code was developed without AI support, except where explicitly indicated in the code comments._

# Simple Bank Account App (Inheritance & Polymorphism)

This is a Java project used to demonstrate inheritance and polymorphism with a simple bank-account application. The program models bank accounts (base class and subclasses), supports basic operations (deposit, withdraw), and records transactions.

## Project overview

- Language: Java (8+)
- No external dependencies — only the Java Standard Library
- Structure: top-level `src/` for core classes and `shared/` for helpers

    ![Sample output with out arguments ](/screenshots/tree.png)


This repository includes an interactive driver that lets you create accounts and exercise account behavior via the console.

## Files in this repository

Files are located at the project root (no package declared in source files):

- `src/BankAccount.java`
  - Abstract/base class for common account fields and behavior (balance, account number, deposit/withdraw stub methods, transaction list handling).
- `src/Checking.java`
  - Checking account subclass. Implements checking-specific behaviors such as overdraft handling (if implemented in code) and any fees.
- `src/Savings.java`
  - Savings account subclass. Implements savings-specific behaviors (interest application if present in code) and withdrawal rules.
- `src/Transaction.java`
  - Simple record class that stores transaction details (type, amount, timestamp, resulting balance).
- `src/BankAccountDriver.java`
  - Interactive driver / program entrypoint. Presents menus, accepts user input (create account, deposit, withdraw, list transactions), and prints reports.
- `shared/Helper.java`
  - Utility functions used across the project (safe parsing helpers `stringToInt`, `stringToDouble`, and formatting like `formatCurrency`).
- `shared/ColorStyle.java`
  - ANSI color constants to improve console output readability (optional — terminal must support ANSI escape sequences).

There is also a `screenshots/` folder included with example program output.

## Quick features

- Polymorphic account hierarchy: `BankAccount` (base) with `Checking` and `Savings` subclasses.
- Transaction recording via `Transaction` objects.
- Console-driven interactive flow in `BankAccountDriver` to create accounts and perform operations.
- Centralized input validation using helpers in `shared/Helper`.

## Run (powershell)

From the project root (the folder that contains `src/` and `shared/`), run:

Run the sample 
```pwsh
java .\src\BankAccountDriver.java 
```

Run the test for Savings Account with transaction listing 
```pwsh
java .\src\BankAccountDriver.java savings
```

Run the test for Savings Account with transaction listing 
```pwsh
java .\src\BankAccountDriver.java interest
```

Run the test for Savings Account with transaction listing 
```pwsh
java .\src\BankAccountDriver.java check
```

Run the test for Savings Account with transaction listing 
```pwsh
java .\src\BankAccountDriver.java compare
```





Run all commands 
```pwsh
.\runme.cmd
```

## Example session (representative)

- Create an account (checking or savings).
- Deposit money.
- Withdraw money (overdraft behavior depends on `Checking` implementation).
- Print transaction history for an account.

Screenshots of sample runs are available in the `screenshots/` folder.

![Sample output with out arguments ](/screenshots/sample.png)

![Checking Account Transactions](/screenshots/checkingTx.png)

![Savings Account Transactions](/screenshots/savingsTx.png)

![Savings and Interest](/screenshots/interestTx.png)


## Requirements

- Java 8 or later
- No external libraries
- ANSI-capable terminal (optional, for colors)

## Contact / Next steps

If you want any of the following improvements, I can implement them:

- Unit tests (JUnit) for `BankAccount`, `Savings`, and `Checking`.
- Interest accrual and scheduled operations for `Savings`.
- Overdraft limits, fees, and configurable account settings for `Checking`.
- A small README-runner script or build file (Ant/Maven/Gradle) if you prefer reproducible builds.

## Contact

If you have questions or need further changes, reply here or refer to the course materials.
Bank Management System — Console ATM Edition
A lightweight console-based ATM simulator that demonstrates the core workflows of retail banking. Customers can sign up, log in, and perform everyday operations—deposit, withdrawal, balance enquiry, mini-statement, and fast-cash—through a clean, menu-driven interface.
All activity is persisted to a MySQL database, including exact time-stamped ledger entries for every transaction.

✨ Key Features

Sign Up:
    Opens a new account via a simple form (name, phone, opening balance, 4-digit PIN).
    
Secure Log-In:
    Authenticates with account number + PIN; hashed PINs in the DB.
    
Deposit:
    Credits funds, shows updated balance, writes a “credit” ledger entry.
    
Withdrawal:
    Debits user-specified amount with insufficient-funds protection.
    
Fast Cash:
    One-tap cash: ₹ 500, ₹ 1 000, ₹ 2 000, or ₹ 5 000.
    
Balance Enquiry:
    Displays current balance in rupees.
    
Mini-Statement:
    Prints the last N transactions (date-time, type, amount, post-balance).

Scope: Built for beginners—focus is on the customer side of an ATM. Fork it to add admin dashboards, interest calculators, or web / GUI front-ends.




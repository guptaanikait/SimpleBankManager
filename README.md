# Simple Bank Manager Android App

A Kotlin-based Android app simulating a simple bank manager with features including user login, balance display, funds transfer, currency exchange calculation, and bill payment.

---

## Features

- **User Authentication:** Login via username and password.
- **View Balance:** Display current account balance formatted as currency.
- **Transfer Funds:** Transfer money to specified accounts with validation.
- **Currency Exchange Calculator:** Convert amounts between EUR, GBP, and USD with dynamic selection.
- **Pay Bills:** Pay predefined utility bills with confirmation and balance checks.
- **Navigation:** Simple navigation among different functionalities using Android Fragments.
- Persistent state managed via singleton objects.

---

## Getting Started

1. Clone the repository:
2. Open in Android Studio.
3. Build and run on emulator or physical device.
4. Default user credentials:  
- Username: `Lara`  
- Password: `1234`

---

## App Structure

- **Singletons:**  
- `Balanceobject`: Holds the current balance.  
- `Bills`: Stores default bills with codes, descriptions, and amounts.  
- `ExchangeObj`: Manages currency conversion rates and current from/to currencies.  
- `Name`: Stores logged-in user's name.

- **Fragments:**  
- `LoginFragment`: Handles user login validation.  
- `UserMenuFragment`: Main menu with navigation buttons for balance, transfer, exchange, and bills.  
- `ViewBalanceFragment`: Shows current balance with currency formatting.  
- `TransferFundsFragment`: Input for account number and amount with validation and balance check for transfers.  
- `CalculateExchangeFragment`: Currency exchange amount input, from/to currency selection, and displays converted result.  
- `PayBillsFragment`: Enter bill code, confirm bill payment, checks balance, and deducts payment.

- **MainActivity:** Sets up navigation graph and passes initial data such as username, password, balance, exchange rates, and bills map.

---

## Usage

- Launch the app and login with your credentials.
- Navigate via the menu to check balance, transfer funds, convert currency, or pay bills.
- Each fragment provides user input validation and helpful feedback via toasts and dialogs.
- Currency amounts are formatted uniformly as currency strings.

---

## Code Highlights

- Uses Android Jetpack Navigation components for fragment transitions.
- Applies data validation for account numbers, amounts, and bill codes.
- Uses Kotlin extension functions for currency formatting.
- Uses `Toast` and `AlertDialog` for user feedback and confirmations.
- Manages shared state across fragments through singleton objects and passed bundles.


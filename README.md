# Point of Sale System - Muyoni Eatery

## Description
This is a Point of Sale (POS) system designed for Muyoni Eatery, allowing customers to place orders, view a total amount, process payments, print receipts, and log receipt details into a text file. The system offers an interactive menu for various items, with clear instructions for each step.

## Features
- **Interactive Menu**: Users can select from a list of food items (1 to 10) displayed with prices.
- **Order Handling**: Orders are added to a list, with total amounts calculated.
- **Payment Processing**: Allows users to input payment and automatically calculate change.
- **Receipt Generation**: Displays a formatted receipt with order details, total amount, and change.
- **File Logging**: Saves transaction details into a file (`log.txt`).
- **Customizable Console Layout**: Interactive console UI with dynamic box generation and cursor positioning.
- **Program Restart**: Option to restart the ordering process without closing the program.
- **Error Handling**: Prompts users with clear error messages if inputs are invalid.

## System Requirements
- **Java 8 or higher**: This project was developed using Java and requires a Java Runtime Environment to run.
- **Operating System**: Works across Windows and Linux systems.

## Project Structure
### Main Features Breakdown
#### Menu Display and Order Handling:
- Users can select items from the menu and add them to their order.
- Prices are displayed next to each menu item.
- Once an item is selected, it is added to the order list with the corresponding price.

#### Total Calculation:
- After making selections, the system calculates the total cost of the order.

#### Payment and Change Calculation:
- Users can input payment, and the system will check if it is sufficient. If not, they are prompted to input again.
- The system calculates the change to be returned.

#### Receipt Generation:
- A detailed receipt is generated, displaying each item in the order, total amount, change, and a thank-you note.
- Receipts are saved to `log.txt` for record-keeping.

#### Console Interaction:
- The system uses `gotoxy` to position text at specific points on the screen for better readability.
- It clears the console screen at the start of each new order or interaction.

#### Restart Functionality:
- Users can choose to restart the process after receiving the receipt or at any time during the interaction.

### File Logging
After completing a transaction, all order details are saved into `log.txt` with the following format:

This ensures proper record-keeping for every transaction.

## Getting Started
1. **Clone the repository to your local machine.**
   ```bash
   git clone https://github.com/muyonii/Point-of-Sale.git
2. **Navigate to the directory where the Java file is located.**
   ```bash
   cd Point-of-Sale-muyoni
3. **Compile the Java program.**
   ```bash
   javac PointOfSaleV2.java
4. **Run the program.**
   ```bash
   java PointOfSaleV2

## Program Flow

1. **Menu Display**: 
   - The program starts by displaying the menu for Muyoni Eatery, including a list of items and their prices.

2. **Order Process**: 
   - The customer selects items from the menu by entering a number corresponding to the item they wish to order.
   - The selected item is added to the order list, and its price is added to the total.

3. **Total Calculation**: 
   - The program automatically calculates and displays the total cost of the customer's order.

4. **Order More Prompt**: 
   - The program asks if the customer would like to order more items (Y/n).
   - If the customer chooses "Y" or "y", the menu is displayed again for new selections.
   - If the customer chooses "N" or "n", the program proceeds to the payment process.

5. **Payment Process**: 
   - The program prompts the customer to enter their payment amount.
   - The program checks if the payment is sufficient. If the payment is less than the total, the user is asked to re-enter the amount.
   - If the payment is sufficient, the program calculates and displays the change.

6. **Receipt Generation**: 
   - Once the payment is processed, the program generates an itemized receipt displaying:
     - The customer's orders.
     - The total amount.
     - The amount of change.
   - The receipt is printed on the screen.

7. **Log Receipt**: 
   - The transaction details (order list, total, payment, and change) are saved to a text file (`log.txt`) for record-keeping.

8. **Restart Prompt**: 
   - The program asks if the customer would like to restart the process for a new order (Y/n).
   - If the customer chooses "Y" or "y", the program restarts from the menu.
   - If the customer chooses "N" or "n", the program ends.

## Notes

- **Menu and Item Selection**: 
  - The menu consists of 10 items with corresponding prices.
  - Users can select an item by entering the number (1-10) associated with the item they want to order.
  - The program adds the selected item's price to the total cost.

- **Order Validation**: 
  - If an invalid input is provided (a number outside the 1-10 range), the program prompts the user to try again.
  
- **Total and Payment Handling**: 
  - The total amount is automatically calculated based on the user's selections.
  - The program ensures the payment is sufficient. If not, the user is prompted to re-enter the payment.

- **Receipt Generation**: 
  - A formatted receipt is displayed, showing the orders, total amount, change, and a thank you message.
  - A text file (`log.txt`) is created to log the transaction details for record-keeping.

- **Restarting the Program**: 
  - After the receipt is generated, the program asks if the user wants to restart the ordering process.
  - If the user chooses "Y" or "y", the program restarts from the menu.
  - If the user chooses "N" or "n", the program ends.

- **Console Clearing**: 
  - The console screen is cleared at the beginning of the program to provide a clean user interface.

- **File Logging**: 
  - A text file (`log.txt`) is generated and appended with the transaction details for each receipt generated, allowing the user to maintain a record of past transactions.

## Conclusion

This program serves as a case study for **Computer Programming 1**, demonstrating the application of fundamental programming concepts such as conditional statements, loops, functions, and file handling. It provides a practical example of a point-of-sale system, simulating the ordering, payment, receipt generation, and logging of transactions in a restaurant setting.

Through the development of this project, the concepts learned in the course, including user input validation, total calculation, and file management, were effectively applied. The program is designed to be interactive and user-friendly, with clear prompts and error handling to ensure smooth operation.

This case study is presented in partial fulfillment of the requirements for **Computer Programming 1** and aims to showcase the student's understanding of basic programming principles and problem-solving skills.

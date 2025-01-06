//package PointofSaleV2;
/*                                                                           
*     ,-----.                           ,---.   ,--.             ,--.          
*    '  .--./ ,--,--. ,---.  ,---.     '   .-',-'  '-.,--.,--. ,-|  |,--. ,--. 
*    |  |    ' ,-.  |(  .-' | .-. :    `.  `-.'-.  .-'|  ||  |' .-. | \  '  /  
*    '  '--'\\ '-'  |.-'  `)\   --.    .-'    | |  |  '  ''  '\ `-' |  \   '   
*     `-----' `--`--'`----'  `----'    `-----'  `--'   `----'  `---' .-'  /    
*                                                                    `---'   
*                                                                                                                                                                                                                                          
*   ,--.  ,--.         ,--.  ,-----.                                    ,--.   ,--.                   ,--.                
*   |  ,'.|  | ,---. ,-'  '-.|  |) /_  ,---.  ,--,--.,--,--,  ,---.      \  `.'  /,---. ,--.--. ,---. `--' ,---. ,--,--,  
*   |  |' '  || .-. :'-.  .-'|  .-.  \| .-. :' ,-.  ||      \(  .-'       \     /| .-. :|  .--'(  .-' ,--.| .-. ||      \ 
*   |  | `   |\   --.  |  |  |  '--' /\   --.\ '-'  ||  ||  |.-'  `)       \   / \   --.|  |   .-'  `)|  |' '-' '|  ||  | 
*   `--'  `--' `----'  `--'  `------'  `----' `--`--'`--''--'`----'         `-'   `----'`--'   `----' `--' `---' `--''--'
*/

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PointOfSaleV1 {
    static boolean isMenuDisplayed = false;
    static double total, payment, change;
    static List<String> orderList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        if(!isMenuDisplayed){
            displayMenu(); // Display the menu
            isMenuDisplayed = true;
        }
        takeOrders(); // Take orders from the user
        displayTotal(); // Display the total amount
        processPayment(); // Process the payment
        printReceipt(); // Print the receipt
        logReceipt(); // Log the receipt
        askForRestart(); // Ask if the user wants to restart
    }

    private static void displayMenu() {
        String[] menu = {
            "1. Shrimp Skewers - 8.9$", "2. Mushroom Risotto - 12.5$", 
            "3. Calamari Rings - 7.8$", "4. Caprese Salad - 6.4$", 
            "5. Herb Chicken - 11.2$", "6. Beef Tenderloin - 19.3$", 
            "7. Seared Salmon - 14.7$", "8. Lobster Bisque - 9.6$", 
            "9. Pesto Pasta - 10.1$", "10. Lava Cake - 5.9$"
        };
        System.out.println("Muyoni Restaurant Menu:");
        for (String item : menu) {
            System.out.println(item);
        }
    }

    private static void takeOrders() {
        while (true) {
            System.out.print("Enter Order Number (1-10): ");
            String orderNum = input.nextLine(); // Get order input

            switch (orderNum) {
                case "1":
                    total += 8.9;
                    orderList.add("Shrimp Skewers - 8.9$");
                    break;
                case "2":
                    total += 12.5;
                    orderList.add("Mushroom Risotto - 12.5$");
                    break;
                case "3":
                    total += 7.8;
                    orderList.add("Calamari Rings - 7.8$");
                    break;
                case "4":
                    total += 6.4;
                    orderList.add("Caprese Salad - 6.4$");
                    break;
                case "5":
                    total += 11.2;
                    orderList.add("Herb Chicken - 11.2$");
                    break;
                case "6":
                    total += 19.3;
                    orderList.add("Beef Tenderloin - 19.3$");
                    break;
                case "7":
                    total += 14.7;
                    orderList.add("Seared Salmon - 14.7$");
                    break;
                case "8":
                    total += 9.6;
                    orderList.add("Lobster Bisque - 9.6$");
                    break;
                case "9":
                    total += 10.1;
                    orderList.add("Pesto Pasta - 10.1$");
                    break;
                case "10":
                    total += 5.9;
                    orderList.add("Lava Cake - 5.9$");
                    break;
                default:
                    System.out.println("Invalid order! Please enter a number between 1 and 10.");
                    continue; // Retry order input
            }
            
            System.out.print("Order More? (Y/n): ");
            String orderMore = input.nextLine();
            if (orderMore.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private static void displayTotal() {
        System.out.printf("Your Total is: %.2f $\n", total);
    }

    private static void processPayment() {
        while (true) {
            System.out.print("Enter Payment: ");
            String paymentIn = input.nextLine(); // Get payment input
            try {
                payment = Double.valueOf(paymentIn); // Convert input to double
            } catch (Exception e) {
                System.out.println("Invalid! Please enter a valid number.");
                continue; // Retry payment input
            }
            if (payment < total) {
                System.out.println("Not Enough! Please enter an amount greater than or equal to the total.");
                continue; // Retry payment input
            } else {
                change = payment - total; // Calculate change
                System.out.printf("Your Change is: %.2f $\n", change); // Display change
                break;
            }
        }
    }

    private static void printReceipt() {
        System.out.println("\n--- Receipt ---");
        System.out.println("Muyoni's Eatery");
        System.out.println("Balanga City, Bataan");
        for (String order : orderList) {
            System.out.println(order);
        }
        System.out.printf("Total: %.2f $\n", total);
        System.out.printf("Change: %.2f $\n", change);
        System.out.println("Thank You!");
    }

    private static void logReceipt() {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("--- Receipt ---\n");
            writer.write("Muyoni's Eatery\n");
            writer.write("Balanga City, Bataan\n");
            for (String order : orderList) {
                writer.write(order + "\n"); // Log each order
            }
            writer.write(String.format("Total: %.2f $\n", total));
            writer.write(String.format("Payment: %.2f $\n", payment));
            writer.write(String.format("Change: %.2f $\n", change));
            writer.write("Thank you for dining with us!\n\n");
        } catch (IOException e) {
            System.out.println("Error logging receipt: " + e.getMessage()); // Handle file writing error
        }
    }

    private static void askForRestart() {
        System.out.print("Restart the program? (y/N): ");
        String restart = input.nextLine();
        if (restart.equalsIgnoreCase("y")) {
            main(null); // Restart the program
        } else {
            System.out.println("Thank you! Goodbye!");
        }
    }
}

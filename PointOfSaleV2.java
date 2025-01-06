
/*                                                                           
*     ,-----.                           ,---.   ,--.             ,--.          
*    '  .--./ ,--,--. ,---.  ,---.     '   .-',-'  '-.,--.,--. ,-|  |,--. ,--. 
*    |  |    ' ,-.  |(  .-' | .-. :    `.  `-.'-.  .-'|  ||  |' .-. | \  '  /  
*    '  '--'\\ '-'  |.-'  `)\   --.    .-'    | |  |  '  ''  '\ `-' |  \   '   
*     `-----' `--`--'`----'  `----'    `-----'  `--'   `----'  `---' .-'  /    
*                                                                    `---'   
*                                                                                                                                                                                                                     
*   ,--.   ,--.,---.       ,-----.          ,--.           ,--.   ,--.                   ,--.                
*    \  `.'  /'   .-'     '  .--./ ,---.  ,-|  | ,---.      \  `.'  /,---. ,--.--. ,---. `--' ,---. ,--,--,  
*     \     / `.  `-.     |  |    | .-. |' .-. || .-. :      \     /| .-. :|  .--'(  .-' ,--.| .-. ||      \ 
*      \   /  .-'    |    '  '--'\' '-' '\ `-' |\   --.       \   / \   --.|  |   .-'  `)|  |' '-' '|  ||  | 
*       `-'   `-----'      `-----' `---'  `---'  `----'        `-'   `----'`--'   `----' `--' `---' `--''--'                                                                                                                                                                                    
*/
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PointOfSaleV2 {
    static boolean isMenuDisplayed = false;
    static double total, payment, change;
    static List<String> orderList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) { // Main function to run the program
        if(isMenuDisplayed == false){
            clearConsole(); // Clear console screen
            displayBox(72, 9, 1, 1); // Displaying the menu box
            String[] menu = {"Shrimp Skewers - 8.9$", "Mushroom Risotto - 12.5$", 
            "Calamari Rings - 7.8$", "Caprese Salad - 6.4$", "Herb Chicken - 11.2$", 
            "Beef Tenderloin - 19.3$", "Seared Salmon - 14.7$", "Lobster Bisque - 9.6$", 
            "Pesto Pasta - 10.1$", "Lava Cake - 5.9$"};
                gotoxy(25, 3, 0, 0); // Positioning cursor
            System.out.print("Muyoni Restaurant Menu"); // Display menu title
                gotoxy(10, 5, 0, 0);
            System.out.printf("[1]%s      [6]%s%n", menu[0], menu[5]);
                gotoxy(10, 6, 0, 0);
            System.out.printf("[2]%s   [7]%s%n", menu[1], menu[6]);
                gotoxy(10, 7, 0, 0);
            System.out.printf("[3]%s      [8]%s%n", menu[2], menu[7]);
                gotoxy(10, 8, 0, 0);
            System.out.printf("[4]%s       [9]%s%n", menu[3], menu[8]);
                gotoxy(10, 9, 0, 0);
            System.out.printf("[5]%s       [10]%s%n", menu[4], menu[9]);
            isMenuDisplayed = true; // Set menu displayed flag
        }
        order(); // Call order function
        total(); // Call total function
        orderMore(); // Call orderMore function
        payment(); // Call payment function
        receipt(); // Call receipt function
        logReceipt(); // Call logReceipt function
        restart(); // Call restart function
        input.close();
        gotoxy(0, 50, 0, 0); // Positioning cursor to end`
        System.exit(0); // End the program
    }

    private static void displayBox(int lenght, int width, int x, int y){ // Function to display a box of specified dimensions at a given position on the screen
        gotoxy(x, y, 0, 0); // Positioning cursor
        System.out.print("╔");
        for(byte i = 1; i <= lenght; i++){
            System.out.print("═"); // Top border
        }
        
        System.out.print("╗");
        y++;

        while (width != 0) {
            gotoxy(x, y, 0, 0); // Positioning cursor
            System.out.print("║");
            for(byte i = 1; i <= lenght; i++){
                System.out.print(" "); // Space inside the box
            }

            gotoxy(x + lenght + 1, y, 0, 0); // Positioning cursor
            System.out.print("║");
            y++;
            width--; // Decrease width

        }
        gotoxy(x, y, 0, 0); // Positioning cursor
        System.out.print("╚");
        for(byte i = 1; i <= lenght; i++){
            System.out.print("═"); // Bottom border
        }
        System.out.print("╝");
    }

    private static void gotoxy(int x, int y, int lenght, int width) { // Function to move the cursor to a specified position on the screen and also deletes
        System.out.print(String.format("%c[%d;%df",0x1B,y,x)); // Move cursor to (x,y)
        for(byte i = 1; i <= width; i++){
            for(byte j = 1; j <= lenght; j++) {
                System.out.print(" "); // Print spaces to clear line
            }
            y++;
            System.out.print(String.format("%c[%d;%df",0x1B,y,x)); // Move cursor to next line
        }
    }

    private static void delay(int ms){ // Function to wait for a specified amount of time (milliseconds)
        try {
            Thread.sleep(ms); // Delay execution by ms milliseconds
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
    }

    private static void order(){ // Function to handle ordering process
        displayBox(34, 1, 1, 12); // Display order box
            gotoxy(6, 13, 0, 0); // Positioning cursor
        System.out.print("Enter Order[1-10]: ");
        String orderNum = input.nextLine(); // Get order input
  
        switch (orderNum) {
        case "1":
            total += 8.9; // Add price to total
            orderList.add("Shrimp Skewers \t 8.9$"); // Add item to order list
            break;

        case "2":
            total += 12.5;
            orderList.add("Mushroom Risotto \t 12.5$");
            break;

        case "3":
            total += 7.8;
            orderList.add("Calamari Rings \t 7.8$");
            break;

        case "4":
            total += 6.4;
            orderList.add("Caprese Salad \t 6.4$");
            break;

        case "5":
            total += 11.2;
            orderList.add("Herb Chicken \t 11.2$");
            break;

        case "6":
            total += 19.3;
            orderList.add("Beef Tenderloin \t 19.3$");
            break;  

        case "7":
            total += 14.7;
            orderList.add("Seared Salmon \t 14.7$");
            break;

        case "8":
            total += 9.6;
            orderList.add("Lobster Bisque \t 9.6$");
            break;

        case "9":
            total += 10.1;
            orderList.add("Pesto Pasta \t 10.1$");
            break; 

        case "10":
            total += 5.9;
            orderList.add("Lava Cake \t\t 5.9$");
            break;    
  
        default:
                gotoxy(6, 13, 30, 0); // Positioning cursor to error message
            delay(200); // Brief delay before displaying error
                gotoxy(6, 13, 0, 0);
            System.out.print("Invalid! Only 1 to 10");
            delay(800); // Brief delay before retry
            order(); // Retry order input
            break;
        }
    }

    private static void total() { // Function to display the total cost
        displayBox(34, 1, 39, 12); // Display total box
            gotoxy(45, 13 , 0, 0); // Positioning cursor
        System.out.printf("Your Total is: %.2f $", total); // Display total amount
    }
    
    private static void orderMore() { // Function to ask if the customer wants to order more
        displayBox(34, 1, 1, 15); // Display orderMore box
            gotoxy(6, 16, 0, 0); // Positioning cursor
        System.out.print("Order More?(Y/n): ");
        String orderMore = input.nextLine(); // Get orderMore input
    
        switch (orderMore) {
            case "Y":
            case "y":
                    gotoxy(1, 15, 40, 3); // Clear previous orderMore prompt
                main(null); // Restart ordering process
                break;
            case "N":
            case "n":
                break;
            default:
                    gotoxy(6, 16, 30, 0); // Delete current text
                delay(200); // Brief delay before displaying error
                    gotoxy(6, 16, 0, 0); // Positioning cursor to error message
                System.out.print("Invalid! Only Y or n");
                delay(800); // Brief delay before retry
                orderMore(); // Retry orderMore input
                break;
        }
      }
    
      private static void payment() { // Function to handle payment process
        displayBox(34, 2, 39, 14); // Display payment box
            gotoxy(39, 14, 0, 0); // Positioning cursor
        System.out.print("║ -------------------------------- ║");
            gotoxy(43, 15 , 0, 0); // Positioning cursor
        System.out.print("Enter Payment: ");
        String paymentIn = input.nextLine(); // Get payment input
        try {
            payment = Double.valueOf(paymentIn); // Convert input to double
            
          }
          catch(Exception e) {
                gotoxy(43, 16, 30, 0); // Positioning cursor to error message
            delay(100); // Brief delay before displaying error
                gotoxy(43, 16, 0, 0);
            System.out.print("Invalid! Integer only");
            delay(1000); // Brief delay before retry
            payment(); // Retry payment input in case of error
          }
        if (payment < total) { // Check if payment is less than total
                gotoxy(43, 16, 30, 1); // Positioning cursor to error message
            delay(100); // Brief delay before displaying error
                gotoxy(43, 16, 0, 0);
            System.out.print("Invalid! Not Enough");
            delay(1000); // Brief delay before retry
            payment(); // Retry payment input if insufficient
        } else{
                gotoxy(43, 16 , 0, 0); // Positioning cursor
            change = payment - total; // Calculate change
            System.out.printf("Your Change is: %.2f", change); // Display change
        }
      }
    
    private static void receipt() { // Function to print the receipt
        int startLine = 19;
        displayBox(34, 6, 1, 12); // Display receipt box
            gotoxy(0, 19, 50, 0); // Positioning cursor
        for (String order : orderList) { 
            System.out.print("║                                  ║");
                gotoxy(5, startLine , 0, 0); // Positioning cursor
            System.out.print(order); // Print each order in receipt
            startLine++;
                gotoxy(0, startLine , 0, 0); // Positioning cursor
        }
        displayBox(34, 3, 1, startLine);
            gotoxy(0, startLine++ , 0, 0);
        System.out.print("║ -------------------------------- ║");
            gotoxy(11, 13 , 0, 0); // Positioning cursor
        System.out.print("Muyoni's Eatery~");
            gotoxy(9, 14 , 0, 0); // Positioning cursor
        System.out.print("Balanga City, Bataan");
            gotoxy(15, 16 , 0, 0); // Positioning cursor
        System.out.print("Receipt");
            gotoxy(5, 17 , 0, 0); // Positioning cursor
        System.out.print("Here are your orders:");
            gotoxy(6, startLine++, 0, 0); // Positioning cursor
        System.out.printf("Your Total is:      %.2f$", total); // Display total amount
            gotoxy(6, startLine++, 0, 0); // Positioning cursor
        System.out.printf("Your Change is:     %.2f$", change); // Display change amount
            gotoxy(14, startLine, 0, 0); // Positioning cursor
        System.out.print("Thank You!"); // Display thank you message
        
    }
    
    private static void restart() { // Function to ask if the customer wants to restart the program
        displayBox(34, 1, 39, 18);
        gotoxy(41, 19, 0, 0);
        System.out.print("Restart the program? [y/N]: ");
        String restart = input.nextLine(); // Get orderMore input
    
        switch (restart) {
            case "Y":
            case "y":
                isMenuDisplayed = false;
                    gotoxy(1, 15, 40, 3); // Clear previous orderMore prompt
                main(null); // Restart ordering process
                break;
            case "N":
            case "n":
                break;
            default:
                    gotoxy(41, 19, 30, 1); // Delete current text
                delay(100); // Brief delay before displaying error
                    gotoxy(41, 19, 0, 0); // Positioning cursor to error message
                System.out.print("Invalid! Only y or N");
                delay(1000); // Brief delay before retry
                restart(); // Retry orderMore input
                break;
        }
    }
    
    private static void logReceipt() { // Function to save the receipt details to a file
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("--- Receipt ---\n");
            writer.write("Muyoni's Eatery\n");
            writer.write("Balanga City, Bataan\n");
            for (String order : orderList) {
                writer.write(order + "\n"); // Log each order
            }
            writer.write(String.format("Total: %.2f $\n", total)); // Log total amount
            writer.write(String.format("Payment: %.2f $\n", payment)); // Log payment amount
            writer.write(String.format("Change: %.2f $\n", change)); // Log change amount
        } catch (IOException e) {
            System.out.println("Error logging receipt: " + e.getMessage()); // Handle file writing error
        }
    }
    
    public static void clearConsole() { // Function to clear the console screen
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear console for Windows
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear console."); // If theres an error
        }
    }
}

/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

import java.util.Scanner;

/**
 * Console is the class to hold a print and display data to the user.
 * Console coordinates the printing and display of menu for the user to view,
 * and gather the input of the user to pass to the other objects.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class Console {

    Scanner sc = new Scanner(System.in);
    Type userType;

    /**
     * The Console used for initialization of the Console object.
     */
    public Console() {
    }

    /**
     * The welcomeMessage display a welcome message to the user and waits for a input from the user.
     * the welcomeMessage display a welcome message and a basic menu with the available options to the user
     * and uses a Scanner objects to get the input from the user. after gathering the input for the user it returns a Type depending of the input of the user.
     *
     * @return Type enum object of type, and return it to the object.
     */
    public Type welcomeMessage() {
        System.out.println("          +-+-+-+-+-+-+-+-+-+-+\n"
                + "          |B|i|g|P|r|o|g|r|a|m|\n"
                + "          +-+-+-+-+-+-+-+-+-+-+\n\n"
                + "   WELCOME TO THE THREE BIG'S PROGRAM.\n\n"
                + " This program allows you to Trade between companies.\n"
                + "Select which company would you like to trade as:\n\n"
                + "               A -> Company BigA\n"
                + "               B -> Company BigB\n"
                + "               C -> Company BigC\n"
                + "   Any other key -> Trade autonomously\n\n"
                + "Type your selection: ");

        String companySelection = sc.nextLine().toUpperCase().trim();

        switch (companySelection) {
            case "A":
                userType = userType.A;
                break;
            case "B":
                userType = userType.B;
                break;
            case "C":
                userType = userType.C;
                break;
            default:
                userType = userType.X;
                break;

        }
        return userType;

    }

    /**
     * The transactionsCompletedHeader print on screen a formated header for the transaction report.
     * The transactionsCompletedHeader print on screen a formated header for the transaction report.
     *
     * @param userType Type object to print header if user chose a type A, B , or C. 
     */
    public void transactionsCompletedHeader(Type userType) {
        if (userType != Type.X) {
            System.out.println("\n\nTRANSACTIONS COMPLETED BY BIG " + userType.toString() + "\n");
            horizontalLine();
            System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "Depot", "Transaction", "to", "Sale/Buy", "Delivery", "Total");
            System.out.println();
            horizontalLine();
        }
    }

    /**
     * The tradeInformationHeader print on screen a formated header for the Trade Information report.
     * The tradeInformationHeader print on screen a formated header for the Trade Information report.
     *
     * @param userType Type object to print header if user chose a type A, B , or C. 
     */
    public void tradeInformationHeader(Type userType) {

        if (userType != Type.X) {
            horizontalLine();

            System.out.print("\n\n\nTRADE INFORMATION BY DEPOT " + userType.toString() + "\n");
            horizontalLine();
            System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "DEPOT", "SALES", "DELIVERY", "UNIT", "PURCHASES", "DELIVERY");
            System.out.println();
            System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "NAME", "", "SALES", "SOLD", "", "PURCHASES");
            System.out.println();
            horizontalLine();
        }
    }

    /**
     * The profitAndLossHeader print on screen a formated header for the profit and loss report.
     * The profitAndLossHeader print on screen a formated header for the profit and loss report.
     *
     */
    public void profitAndLossHeader() {
        horizontalLine();
        System.out.print("\n\n\nPROFIT AND LOSS BY COMPANY\n");
        horizontalLine();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "", "", "", "TOTAL", "", "", "TOTAL", "TOTAL");
        System.out.println();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "COMPANY", "SALES", "DELIVERY", "SALES", "PURCHASES", "DELIVERY", "TOTAL", "PROFIT");
        System.out.println();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "", "", "SALES", "SALES", "", "PURCHASES", "PURCHASES", "/LOSS");
        System.out.println();
        horizontalLine();
    }

    /**
     * The horizontalLine print on screen a horizontal line.
     * The horizontalLine print on screen a horizontal line.
     *
     */
    public void horizontalLine() {
        System.out.println("---------------------------------------------------------------------------------------------------------");

    }

    /**
     * The returnToMain print on screen a line to ask to the user for a input and wait for the to return to the main menu.
     * The returnToMain print on screen a line to ask to the user for a input and wait for the to return to the main menu.
     *
     * @return  Boolean base on input of the user, if "EXIT" return false, any other return true.
     */
    public Boolean returnToMain() {
        System.out.println("\n\n\n\n\n\nType any key to return to the main Menu"
                + "or Type 'EXIT' to finish the program");
        String returnMain = sc.nextLine().toUpperCase().trim();
        if (returnMain.equals("EXIT")) {
            return false;
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return true;
    }
}

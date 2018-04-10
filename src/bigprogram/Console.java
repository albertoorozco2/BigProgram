/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigprogram;

import java.util.Scanner;

/**
 *
 * @author A1
 */
public class Console {

    Scanner sc = new Scanner(System.in);

    public Console() {
    }

    public String welcomeMessage() {
        System.out.println("          +-+-+-+-+-+-+-+-+-+-+\n" 
                         +"          |B|i|g|P|r|o|g|r|a|m|\n" 
                         +"          +-+-+-+-+-+-+-+-+-+-+\n\n"
                         +"   WELCOME TO THE THREE BIG'S PROGRAM.\n\n"
                        + " This program allows you to Trade between companies.\n"
                        + "Select which company would you like to trade as:\n\n"
                        + "         A -> Company BigA\n"
                        + "         B -> Company BigB\n"
                        + "         C -> Company BigC\n"
                        + "       Any -> Trade autonomously\n\n"
                        + "Type your selection: ");

        String companySelection = sc.nextLine().toUpperCase().trim();
        if (companySelection.equals("A") || companySelection.equals("B") || companySelection.equals("C")) {
            System.out.println("You have selected to start trading as Big " + companySelection + "\n");
        } else {
            System.out.println("You have selected to start trading autonomously \n"
                    + "You have been assign to trade as BigB");
            companySelection = "B";
        }
        return companySelection;
    }

    public void transactionsCompletedHeader(String userType) {
        System.out.println("\n\nTRANSACTIONS COMPLETED BY BIG " + userType + "\n");
        horizontalLine();
        System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "Depot", "Transaction", "to", "Sale/Buy", "Delivery", "Total");
        System.out.println();
        horizontalLine();
    }

    public void tradeInformationHeader(String userType) {
        horizontalLine();

        System.out.print("\n\n\nTRADE INFORMATION BY DEPOT " + userType + "\n");
        horizontalLine();
        System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "DEPOT", "SALES", "DELIVERY", "UNIT", "PURCHASES", "DELIVERY");
        System.out.println();
        System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s |", "NAME", "", "SALES", "SOLD", "", "PURCHASES");
        System.out.println();
        horizontalLine();
    }

    public void profitAndLossHeader() {
        horizontalLine();
        System.out.print("\n\n\nPROFIT AND LOSS BY COMPANY\n");
        horizontalLine();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s |", "", "TOTAL", "TOTAL", "TOTAL", "TOTAL", "TOTAL");
        System.out.println();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s |", "COMPANY", "SALES", "DELIVERY", "PURCHASES", "DELIVERY", "PROFIT");
        System.out.println();
        System.out.printf("| %11s | %10s | %10s | %10s | %10s | %10s |", "", "", "SALES", "", "PURCHASES", "/LOSS");
        System.out.println();
        horizontalLine();
    }

    public void horizontalLine(){
            System.out.println("-------------------------------------------------------------------------------");

    }
    
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

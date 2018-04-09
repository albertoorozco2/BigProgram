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
public class Main {
  
    public static void main(String[] args) {
        CompaniesFacade CompaniesFacade = new CompaniesFacade();
        System.out.println("WELCOME TO THE THREE BIG'S PROGRAM.\n"
                + "This program allows you to Trade between companies.\n" 
                + "Select which big company would you like to start trading as:\n"
                +"  A -> BigA\n"
                +"  B -> BigB\n" 
                +"  C -> BigC\n" 
                +"Any -> Trade autonomously\n"
                +"Type your selection: ");
        Scanner sc = new Scanner(System.in);
        String companySelection = sc.nextLine().toUpperCase().trim();
        if(companySelection.equals("A")||companySelection.equals("B")||companySelection.equals("C"))
        {
            System.out.println("You have selected to start trading as Big "+companySelection+"\n");
        }else{
            System.out.println("You have selected to start trading autonomously \n"
                    + "You have been assign to trade as BigB");
            companySelection = "B";
        }
        
        CompaniesFacade.Treading(companySelection);
            
    }

}

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
        CompaniesFacade CompaniesFacade;
        Console console = new Console();

        Boolean run = true;
        do{
        CompaniesFacade = new CompaniesFacade();
        CompaniesFacade.Treading(console.WelcomeMessage());
        run = console.ReturnToMain();
        }while(run==true);
            
    }

}

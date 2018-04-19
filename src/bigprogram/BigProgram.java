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
public class BigProgram {
  
    public static void main(String[] args) {
        Boolean run;
        do{ 
        Console console = new Console();
        Company companyA = new Company("Alberto");
        Company companyB = new Company("B");
        Company companyC = new Company("C");
        CompaniesFacade CompaniesFacade = new CompaniesFacade(companyA, companyB, companyC, console);
       
        CompaniesFacade.treading();
        run = console.returnToMain();
        }while(run==true);
            
    }

}

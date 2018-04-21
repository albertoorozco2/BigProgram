/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigprogram;


/**
 *
 * @author A1
 */
public class BigProgram {
    
  
    public static void main(String[] args) {
        Console console = new Console();
        DepotBuilder depotBuilder = new DepotBuilder();
        DepotStorage storage = new DepotStorage();
        Company companyA;
        Company companyB;
        Company companyC;
        CompaniesFacade CompaniesFacade;
        Boolean run;

        do{ 
         companyA = new Company(Type.A, depotBuilder, storage);
         companyB = new Company(Type.B, depotBuilder, storage);
         companyC = new Company(Type.C, depotBuilder, storage);
         CompaniesFacade = new CompaniesFacade(companyA, companyB, companyC, console);
        CompaniesFacade.treading();
        run = console.returnToMain();
        }while(run==true);
            
    }

}

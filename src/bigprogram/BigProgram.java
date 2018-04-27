/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * BigProgram initializes the program and all the objects required .
 * BigProgram initializes the program and all the objects required
 * such as console, Deport Builder, DepotStorage, Company objects.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class BigProgram {

    public static void main(String[] args) {
        Console console = new Console();
        DepotBuilder depotBuilder = new DepotBuilder() {
        };
        DepotStorage depotStorage = new DepotStorage();
        Company companyA;
        Company companyB;
        Company companyC;
        CompaniesFacade CompaniesFacade;
        Boolean run;

        do {
            companyA = new Company(Type.A, depotBuilder, depotStorage);
            companyB = new Company(Type.B, depotBuilder, depotStorage);
            companyC = new Company(Type.C, depotBuilder, depotStorage);
            CompaniesFacade = new CompaniesFacade(companyA, companyB, companyC, console);
            CompaniesFacade.treading();
            run = console.returnToMain();
        } while (run == true);

    }

}

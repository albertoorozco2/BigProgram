/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

import java.util.Random;

/**
 * DepotBuilder is the class to build Depots by implementing the Builder Interface.
 * DepotBuilder is the class to build Depots by implementing the Builder Interface,
 * with the initialization all the required objects for a Depot such as .
 * .
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class DepotBuilder implements Builder {

    private Integer name = null;
    private Stock stockItself = null;
    private Stock stockOther = null;
    private Stock stockAnother = null;
    private Allowance allowance = null;
    private Depot depot = null;
    Random rand = new Random();

    /**
     * The DepotBuilder used for initialization of the DepotBuilder object.
     */
    public DepotBuilder() {

    }

    /**
     * The buildDepot build a new Depot based on the input params.
     * The buildDepot build a new Depot based on the input name and type from the user.
     *
     * @param name required a Integer as name for the Depot.
     * @param type required a Type object to set the Type of Depot.
     */

    @Override
    public void buildDepot(Integer name, Type type) {
        //    System.out.println(type);
        depot = new Depot();
        switch (type) {
            case A:
                this.stockItself = new Stock(type.A, (rand.nextInt((50 - 15) + 1) + 15));
                this.stockOther = new Stock(type.B, (rand.nextInt((40 - 3) + 1) + 3));
                this.stockAnother = new Stock(type.C, (rand.nextInt((40 - 3) + 1) + 3));
                this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                break;
            case B:
                this.stockItself = new Stock(Type.B, (rand.nextInt((50 - 15) + 1) + 15));
                this.stockOther = new Stock(Type.C, (rand.nextInt((40 - 3) + 1) + 3));
                this.stockAnother = new Stock(Type.A, (rand.nextInt((40 - 3) + 1) + 3));
                this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                break;
            case C:
                this.stockItself = new Stock(Type.C, (rand.nextInt((50 - 15) + 1) + 15));
                this.stockOther = new Stock(Type.A, (rand.nextInt((40 - 3) + 1) + 3));
                this.stockAnother = new Stock(Type.B, (rand.nextInt((40 - 3) + 1) + 3));
                this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                break;
            default:
                System.out.println("Invalid Type");
                break;
        }
        this.depot.setName(name);
        this.depot.setStockItself(this.stockItself);
        this.depot.setStockOther(this.stockOther);
        this.depot.setStockAnother(this.stockAnother);
        this.depot.setAllowance(this.allowance);
    }
    /**
     * The getNewDepot returns the new Depot builded.
     * the method call the buildDepot before returning a new Depot.
     * 
     * @param name required a Integer as name for the Depot.
     * @param type required a Type object to set the Type of Depot.
     * @return Depot based of the inputs.
     */
    @Override
    public Depot getNewDepot(Integer name, Type type) {
        buildDepot(name, type);
        return depot;
    }

}

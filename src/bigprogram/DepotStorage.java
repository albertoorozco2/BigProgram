/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * DepotStorage is the class to hold and Depots in the array before send to Iterator.
 * DepotStorage is an object to hold and 100 Depots in the array before send to Iterator Object.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class DepotStorage {

    private Depot[] depots = new Depot[100];
    private int index = 0;

    /**
     * The addDepot used for add a new Depot to the Array.
     * The addDepot used for add a new Depot to the Array.
     *
     * @param depot a Depot object to be added to the Array
     */
    public void addDepot(Depot depot) {
        depots[index] = depot;
        index++;
    }

    /**
     * The getDepots return an array of 100 Depots.
     * The getDepots return an array of 100 Depots.
     *
     * @return Depot[]t an Array of 100 Depots.
     */
    public Depot[] getDepots() {
        Depot[] depotsCompleted = this.depots;
        this.depots = new Depot[100];
        index = 0;
        return depotsCompleted;
    }

}

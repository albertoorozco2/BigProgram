/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

import java.util.Iterator;

/**
 * DepotIterator is the class to hold and keep track of Depot in the iterator.
 * DepotIterator is the class to hold and keep track of Depot in the iterator,
 * It hold a all the Depots in an Array of Depot and the position with a int variable.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class DepotIterator implements Iterator<Depot> {

    private Depot[] depots;
    int position;

    /**
     * The DepotIterator used for initialization of the DepotIterator object.
     * In order to initialize it required a Depot Array and it sets position to 0/
     *
     * @param depots Array of Depots to iterate.
     */
    public DepotIterator(Depot[] depots) {
        this.depots = depots;
        position = 0;
    }

    /**
     * The hasNext implementation the interface Iterator, return boolean, if there is next.
     * The hasNext implementation the interface Iterator, return boolean, if there is next.
     *
     * @return boolean returns true if there is next.
     */
    @Override
    public boolean hasNext() {
        if (position >= depots.length || depots[position] == null) {
            return false;
        }
        return true;
    }

    /**
     * The next implementation the interface Iterator, return next Depot.
     * The next implementation the interface Iterator, return next Depot.
     *
     * @return Depot returns next Depot in the Iterator.
     */
    @Override
    public Depot next() {
        return depots[position++];
    }

    /**
     * The first set position to 0 to restart again the Iterator.
     */
    public void first() {
        position = 0;
    }

}

/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Builder is the interface for the required methods to be implemented by any DepotBuilder.
 * Builder coordinates the methods that DepotBuilder will implements.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public interface Builder {

    /**
     * The buildDepot build a new Depot based on the input params.
     * The buildDepot build a new Depot based on the input name and type from the user.
     *
     * @param name required a Integer as name for the Depot.
     * @param type required a Type object to set the Type of Depot.
     */
    public void buildDepot(Integer name, Type type);

    /**
     * The getNewDepot returns the new Depot builded.
     * the method call the buildDepot before returning a new Depot.
     *
     * @param name required a Integer as name for the Depot.
     * @param type required a Type object to set the Type of Depot.
     * @return Depot based of the inputs.
     */
    public Depot getNewDepot(Integer name, Type type);

}

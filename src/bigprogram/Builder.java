/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;


/**
 * Builder is the interface for the Depot Builder.
 * Builder coordinates the methods that DepotBuilder will implements.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public interface Builder {

    public void buildDepot(Integer name, Type type);

    public Depot getNewDepot(Integer name, Type type);

}

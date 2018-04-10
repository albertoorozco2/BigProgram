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


public class DepotStorage {
    private Depot []depots = new Depot[100];
    private int index = 0;
    
    public void addDepot(Depot depot){
 //       System.out.println(depot);
//        System.out.println(index);
        depots[index] = depot;
        index++;
    }
    
    public Depot[] getDepots(){
        return depots;
}

}

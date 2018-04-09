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
public class Company {
    
    public Integer totalSales;
    public Integer totalPurchases;
    public Integer totalDelivery;
    public DepotBuilder depotBuilder = new DepotBuilder();
    public DepotStorage storage = new DepotStorage();
    public DepotIterator iterator;
    
    public Company(String type) {
        for(int i =1; i<101; i++){
         storage.addDepot(depotBuilder.getNewDepot(i, type));
        }
        iterator = new DepotIterator(storage.getDepots());
        
        Depot one;
        for(int i =0; i<100; i++){
         
            one = iterator.next();
            System.out.println(one.stockItself.getStockType()+"-"+one.getName());
        }
    }
    
    
    
}

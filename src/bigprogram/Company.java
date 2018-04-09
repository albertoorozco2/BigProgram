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
    
    public Integer totalSales = 0;
    public Integer totalDeliverySales = 0;
    public Integer totalPurchases =0;
    public Integer totalDeliveryPurchases=0;
    public DepotBuilder depotBuilder = new DepotBuilder();
    public DepotStorage storage = new DepotStorage();
    public DepotIterator iterator;
    public String companyType;
    
    public Company(String type) {
        this.companyType = type;
        for(int i =1; i<101; i++){
         storage.addDepot(depotBuilder.getNewDepot(i, type));
        }
//        System.out.println(type+"completed");
        iterator = new DepotIterator(storage.getDepots());
//        System.out.println(type+"completed");

        Depot one;
        for(int i =0; i<100; i++){
         
            one = iterator.next();
   //         System.out.println(one.stockItself.getStockType()+"-"+one.getName());
           
        }
         iterator.first();
    }
    public void tradeInformationByDepot(Boolean print){
        
        Depot one;
        iterator.first();
        for(int i =0; i<100; i++){

            one = iterator.next();
            this.totalSales = this.totalSales+ one.allowance.getSales();
            this.totalDeliverySales += one.allowance.getDeliverSales();
            this.totalPurchases += one.allowance.getPurchases();
            this.totalDeliveryPurchases += one.allowance.getDeliverPurchases();
            if(print==true){one.TradeInformation();}
        }
    
    }
    public void profitAndLost(String type){
           System.out.printf("| Company %3s | %,10d | %,10d | %,10d | %,10d | %,10d |", type, totalSales, totalDeliverySales, totalPurchases, totalDeliveryPurchases, (totalSales+totalDeliverySales-totalPurchases-totalDeliveryPurchases));
           System.out.println();

    }
    
    public Integer Spent(){
    return totalPurchases+totalDeliveryPurchases;
    }
    public Integer Made(){
    return totalSales+totalDeliverySales;
    }
    public String CompanyType(){
    return companyType;
    }
    public DepotIterator getIterator(){
    return this.iterator;
    }
    
    
    
}

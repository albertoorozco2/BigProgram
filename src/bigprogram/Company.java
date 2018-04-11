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

    private Integer totalSales = 0;
    private Integer totalDeliverySales = 0;
    private Integer totalPurchases = 0;
    private Integer totalDeliveryPurchases = 0;
    private DepotBuilder depotBuilder = new DepotBuilder();
    private DepotStorage storage = new DepotStorage();
    private DepotIterator iterator;
    private String companyType;

    public Company(String type) {
        this.companyType = type;
        for (int i = 1; i < 101; i++) {
            storage.addDepot(depotBuilder.getNewDepot(i, type));
        }
    //    System.out.println(type+"completed");
        iterator = new DepotIterator(storage.getDepots());
//        System.out.println(type+"completed");

//        Depot one;
//        for (int i = 0; i < 100; i++) {
//
//            one = iterator.next();
//            //         System.out.println(one.stockItself.getStockType()+"-"+one.getName());
//
//        }
//        iterator.first();
    }

    public void tradeInformationByDepot(Boolean print) {

        Depot one;
        iterator.first();
        for (int i = 0; i < 100; i++) {

            one = iterator.next();
            this.totalSales = this.totalSales + one.allowance.getSales();
            this.totalDeliverySales += one.allowance.getDeliverSales();
            this.totalPurchases += one.allowance.getPurchases();
            this.totalDeliveryPurchases += one.allowance.getDeliverPurchases();
            if (print == true) {
                one.tradeInformationPrint();
            }
        }

    }

    public void profitAndLost(String type) {
        System.out.printf("| Company %3s | %,10d | %,10d | %,10d | %,10d | %,10d |", type, totalSales, totalDeliverySales, totalPurchases, totalDeliveryPurchases, (totalSales + totalDeliverySales - totalPurchases - totalDeliveryPurchases));
        System.out.println();

    }

    public Integer spent() {
        return totalPurchases + totalDeliveryPurchases;
    }

    public Integer made() {
        return totalSales + totalDeliverySales;
    }

    public String getCompanyType() {
        return companyType;
    }

    public DepotIterator getDepotIterator() {
        return this.iterator;
    }

}

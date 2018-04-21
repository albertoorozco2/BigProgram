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
    private DepotBuilder depotBuilder;
    private DepotStorage storage;
    private DepotIterator iterator;
    private Type companyType;

    public Company(Type type, DepotBuilder depotBuilder, DepotStorage storage) {
        this.storage = storage;
        this.companyType = type;
        this.depotBuilder = depotBuilder;
        for (int i = 1; i < 101; i++) {
            storage.addDepot(depotBuilder.getNewDepot(i, type));
        }
        iterator = new DepotIterator(storage.getDepots());

    }

    public void tradeInformationByDepot(Type userType) {
        Depot one;
        iterator.first();
        for (int i = 0; i < 100; i++) {

            one = iterator.next();
            this.totalSales = this.totalSales + one.allowance.getSales();
            this.totalDeliverySales += one.allowance.getDeliverSales();
            this.totalPurchases += one.allowance.getPurchases();
            this.totalDeliveryPurchases += one.allowance.getDeliverPurchases();
            if (userType == companyType) {
                one.tradeInformationPrint();
            }
        }

    }

    public void profitAndLost() {
        System.out.printf("| Company %3s | %,10d | %,10d | $ %,8d | %,10d | %,10d | $ %,8d | %,10d |", companyType, totalSales, totalDeliverySales,(totalSales+totalDeliverySales), totalPurchases, totalDeliveryPurchases,(totalPurchases+totalDeliveryPurchases) ,  (totalSales + totalDeliverySales - totalPurchases - totalDeliveryPurchases));
        System.out.println();

    }

    public Integer spent() {
        return totalPurchases + totalDeliveryPurchases;
    }

    public Integer made() {
        return totalSales + totalDeliverySales;
    }

    public Type getCompanyType() {
        return companyType;
    }

    public DepotIterator getDepotIterator() {
        return this.iterator;
    }

}

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
public class Allowance {

    public Integer initialAllowance = 0;
    private Integer sales = 0;
    private Integer deliverSales = 0;
    private Integer purchases = 0;
    private Integer deliverPurchases = 0;

    public Allowance(Integer allowance) {
        this.initialAllowance = allowance;
        //  System.out.println("allowance = "+allowance);
    }

    public Integer getAllowance() {
        Integer allowanceTemp = initialAllowance + sales + deliverSales - purchases - deliverPurchases;
        //  System.out.println("allowance Temp = "+allowanceTemp);
        return allowanceTemp;
    }

    public Integer getSales() {
        //          System.out.println("get sales = "+this.sales);

        return sales;
    }

    public void setSales(Integer sales) {
        //System.out.println("sales = "+ sales);

        this.sales = this.sales + sales;
        // System.out.println("sales new = "+this.sales);

    }

    public Integer getDeliverSales() {
        //  System.out.println("deliverSales = "+this.deliverSales);
        return this.deliverSales;
    }

    public void setDeliverSales(Integer deliverSales) {

        this.deliverSales = this.deliverSales + deliverSales;
        // System.out.println("deliverSales new = "+this.deliverSales);

    }

    public Integer getPurchases() {
        //    System.out.println("puchase  = "+this.purchases);
        return purchases;
    }

    public void setPurchases(Integer purchases) {
        this.purchases = this.purchases + purchases;
        //    System.out.println("puchase new = "+this.purchases);

    }

    public Integer getDeliverPurchases() {
        // System.out.println("deliverPurchases  = "+this.deliverPurchases);
        return deliverPurchases;
    }

    public void setDeliverPurchases(Integer deliverPurchases) {
        this.deliverPurchases = this.deliverPurchases + deliverPurchases;
        //   System.out.println("deliverPurchases new = "+this.deliverPurchases);

    }

}

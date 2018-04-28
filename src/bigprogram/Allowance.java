/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Allowance is an object class to keep track of the income, and expenses of the transaction of each depot based on the initial allowance assigned.
 * Allowance is an object to keep track of the income, and expenses based on the allowance,
 * by keeping track of the sales, delivery sales, purchases, delivery purchases, and initial allowance.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class Allowance {

    private Integer initialAllowance = 0;
    private Integer sales = 0;
    private Integer deliverSales = 0;
    private Integer purchases = 0;
    private Integer deliverPurchases = 0;

    /**
     * The Allowance used for initialization of the Stock Object require the Integer amount of initial allowance.
     * The Allowance used for initialization of the Stock Object require the Integer amount of initial allowance.
     *
     * @param allowance a Integer of the initial allowance.
     */
    public Allowance(Integer allowance) {
        this.initialAllowance = allowance;
    }

    /**
     * The getAllowance return an Integer of the actual Allowance.
     * The getAllowance return an Integer of the actual Allowance by
     * adding sales, delivery sales, and subtracting purchases and delivery purchases from the initial allowance.
     *
     * @return Integer of the actual Allowance.
     */
    public Integer getAllowance() {
        Integer allowanceTemp = initialAllowance + sales + deliverSales - purchases - deliverPurchases;
        return allowanceTemp;
    }

    /**
     * The getSales return an Integer of the total sells.
     * The getSales return an Integer of the total sells.
     *
     * @return Integer of the actual total sales.
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * The setSales set a new total sells.
     * The setSales set a new total sells by adding the sells trade.
     *
     * @param sales amount of sales to add to the total sales.
     */
    public void setSales(Integer sales) {
        this.sales = this.sales + sales;
    }

    /**
     * The getDeliverSales return an Integer of the total delivery sells.
     * The getDeliverSales return an Integer of the total delivery sells.
     *
     * @return Integer of the actual total delivery sales.
     */
    public Integer getDeliverSales() {
        return this.deliverSales;
    }

    /**
     * The setDeliverSales set a new total delivery sells.
     * The setDeliverSales set a new total delivery sells by adding the delivery sells trade.
     *
     * @param deliverSales amount of delivery sales to add to the total delivery sales.
     */
    public void setDeliverSales(Integer deliverSales) {
        this.deliverSales = this.deliverSales + deliverSales;
    }

    /**
     * The getPurchases return an Integer of the total purchases.
     * The getPurchases return an Integer of the total purchases.
     *
     * @return Integer of the actual total purchases.
     */
    public Integer getPurchases() {
        return purchases;
    }

    /**
     * The setPurchases set a new total purchases.
     * The setPurchases set a new total purchases by adding the purchases trade.
     *
     * @param purchases amount of delivery purchases to add to the total delivery purchases.
     */
    public void setPurchases(Integer purchases) {
        this.purchases = this.purchases + purchases;
    }

    /**
     * The getDeliverPurchases return an Integer of the total delivery purchases.
     * The getDeliverPurchases return an Integer of the total delivery purchases.
     *
     * @return Integer of the actual total delivery purchases.
     */
    public Integer getDeliverPurchases() {
        return deliverPurchases;
    }

    /**
     * The setDeliverPurchases set a new total delivery purchases.
     * The setDeliverPurchases set a new total purchases by adding the delivery purchases trade.
     *
     * @param deliverPurchases amount of delivery purchases to add to the total purchases.
     */
    public void setDeliverPurchases(Integer deliverPurchases) {
        this.deliverPurchases = this.deliverPurchases + deliverPurchases;
    }

}

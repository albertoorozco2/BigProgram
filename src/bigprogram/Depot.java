/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Depot is the class to hold a Depot features such as Stocks, and Allowance.
 * Depot is the class to hold a Depot features:
 * .
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class Depot {

    private Integer name = null;
    private Stock stockItself = null;
    private Stock stockOther = null;
    private Stock stockAnother = null;
    private Allowance allowance = null;

    /**
     * The Depot used for initialization of the Depot object.
     */
    public Depot() {
    }

    /**
     * The setStockItself set the main stock of the Depot.
     * The setStockItself required a Stock object and set the main Stock of the Depot .
     *
     * @param stockItself required a Stock object to set the StockItself.
     */
    public void setStockItself(Stock stockItself) {
        this.stockItself = stockItself;
    }

    /**
     * The setStockOther set the stock of an different type from the Depot.
     * The setStockOther set the stock of an different type from the Depot.
     *
     * @param stockOther required a Stock object to set the StockItself.
     */
    public void setStockOther(Stock stockOther) {
        this.stockOther = stockOther;
    }

    /**
     * The setStockAnother set the stock of an third different type from the Depot.
     * The setStockOther set the stock of an third different type from the Depot.
     *
     * @param stockAnother required a Stock object to set the StockItself.
     */
    public void setStockAnother(Stock stockAnother) {
        this.stockAnother = stockAnother;
    }

    
    /**
     * The setAllowance set the allowance for the Depot.
     * The setAllowance set the allowance for the Depot.
     *
     * @param allowance required a allowance object to set the allowance of the depot.
     */
    public void setAllowance(Allowance allowance) {
        this.allowance = allowance;
    }
    /**
     * The getAllowance set the allowance for the Depot.
     * The setAllowance set the allowance for the Depot.
     *
     * @return allowance returns its allowance
     */
    public Allowance getAllowance() {
        return this.allowance;
    }
    /**
     * The setName set the name for the Depot.
     * The setName set the name for the Depot.
     *
     * @param name required a Integer as to set the StockItself.
     */
    public void setName(Integer name) {
        this.name = name;
    }

    /**
     * The getName return the name for the Depot.
     * The getName return the name for the Depot.
     *
     * @return name return a Integer as a name.
     */
    public Integer getName() {
        return this.name;
    }
    /**
     * The getStockItself return the main Stock of itself.
     * The getStockItself return the main Stock of itself.
     *
     * @return Stock return a Stock as a name.
     */
    public Stock getStockItself() {
        return this.stockItself;
    }
    /**
     * The possibleToSell return Boolean if it is possible to sell .
     * The possibleToSell return Boolean if it is possible to sell .
     *
     * @return Boolean return a boolean if it stock its lower than 15.
     */
    public Boolean possibleToSell() {
        return this.stockItself.getStockAmount() > 15;
    }

    /**
     * The sell perform a sell transaction.
     * The sell method perform a sell transaction by updating the sellStock, Sales, and Delivery Sells .
     *
     * @param name required the name of the Depot that is doing the transaction with.
     * @param type required the type of the stock of the Depot that is doing the transaction with.
     * @param sales required the amount of the sales.
     * @param deliverySales required the amount of the sales.
     */
    public void sell(Integer name, Type type, Integer sales, Integer deliverySales) {

        this.stockItself.sellStock();
        this.allowance.setSales(sales);
        this.allowance.setDeliverSales(deliverySales);
    }

    /**
     * The possibleToBuy return Boolean if it is possible to buy .
     * The possibleToBuy return Boolean if it is possible to buy .
     *
     * @param type required the type of the stock of the Depot that is doing the transaction with.
     * @param amount required the amount of the purchase.
     * @return Boolean return a boolean if it stock its higher than 40 and allowance higher than 50.
     */
    public Boolean possibleToBuy(Type type, Integer amount) {
        Boolean test = null;
        if ((this.allowance.getAllowance() - 50) >= amount) {
            if (this.stockOther.getStockType().equals(type)) {
                test = this.stockOther.getStockAmount() < 40;
            } else if (stockAnother.getStockType().equals(type)) {
                test = this.stockAnother.getStockAmount() < 40;
            }
        } else {
            test = false;
        }
        return test;
    }

    /**
     * The buy perform a buy transaction.
     * The buy method perform a buy transaction by updating the Stock of the type, purchase, and delivery Purchase Sells .
     *
     * @param nameDepot required the name of the Depot that is doing the transaction with.
     * @param type required the type of the stock of the Depot that is doing the transaction with.
     * @param purchase required the amount of the purchase.
     * @param deliveryPurchase required the amount of the delivery purchase .
     */
    public void buy(Integer nameDepot, Type type, Integer purchase, Integer deliveryPurchase) {
        if (type.equals(stockOther.getStockType())) {
            stockOther.buyStock();
            allowance.setPurchases(purchase);
            allowance.setDeliverPurchases(deliveryPurchase);
        } else if (type.equals(stockAnother.getStockType())) {
            stockAnother.buyStock();
            allowance.setPurchases(purchase);
            allowance.setDeliverPurchases(deliveryPurchase);
        }
    }

    /**
     * The tradeInformationPrint print the trade information for depot.
     * The tradeInformationPrint method print a formated trade information for depot.
     */
    public void tradeInformationPrint() {
        System.out.printf("| DEPOT%5s | %,10d | %,10d | %,10d | %,10d | %,10d |", this.stockItself.getStockType() + "-" + this.name, allowance.getSales(), allowance.getDeliverSales(), stockItself.getUnitSold(), allowance.getPurchases(), allowance.getDeliverPurchases());
        System.out.println();

    }

}

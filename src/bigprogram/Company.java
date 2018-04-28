/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Company is the class that hold the DepotIterator, and get the total of transaction.
 * Company coordinates DepotIterator in order to perform transaction with each Depot
 * in order to perform need DepotBuilder and DepotStorage to put Depots in its Depot Iterator
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class Company {

    private Integer totalSales = 0;
    private Integer totalDeliverySales = 0;
    private Integer totalPurchases = 0;
    private Integer totalDeliveryPurchases = 0;
    private DepotIterator iterator;
    private Type companyType;

    /**
     * The Company used for creating the Company object.
     * Company need to create a DepotIterator in order to initialize and this DepotIterator need to
     * hold a 100 depots, in order to create the 100 Depots it is required a Type, DepotBuilder and DepotStoragfe
     *
     * @param type enum object that hols the allow Types.
     * @param depotBuilder DepotBuilder Object is required to create all the Depots.
     * @param depotStorage DepotStorage Object is required before passing the Depots to DepotIterator.
     *
     */
    public Company(Type type, DepotBuilder depotBuilder, DepotStorage depotStorage) {
        this.companyType = type;
        for (int i = 1; i < 101; i++) {
            depotStorage.addDepot(depotBuilder.getNewDepot(i, this.companyType));
        }
        iterator = new DepotIterator(depotStorage.getDepots());

    }

    /**
     * The tradeInformationByDepot method iterates over all the depots to gather the information of each of them.
     * the tradeInformationByDepot gather the iterates over each depot on the Depot Iterator and each one of them return data,
     * this is added to the total of the company, it required a param or the type of the user chosen, if the time is the same
     * than the type of Depot, it print the information of each Depot.
     *
     * @param userType Type object to allow to print transaction when the company the Depot is the same type as user.
     */
    public void tradeInformationByDepot(Type userType) {
        Depot one;
        iterator.first();
        for (int i = 0; i < 100; i++) {

            one = iterator.next();
            this.totalSales = this.totalSales + one.getAllowance().getSales();
            this.totalDeliverySales += one.getAllowance().getDeliverSales();
            this.totalPurchases += one.getAllowance().getPurchases();
            this.totalDeliveryPurchases += one.getAllowance().getDeliverPurchases();
            if (userType == companyType) {
                one.tradeInformationPrint();
            }
        }

    }

    /**
     * The profitAndLost print a report of the profit and lost of the company.
     * The profitAndLost print a report of the profit and lost of the company.
     */
    public void profitAndLost() {
        System.out.printf("| Company %3s | %,10d | %,10d | $ %,8d | %,10d | %,10d | $ %,8d | %,10d |", companyType, totalSales, totalDeliverySales, (totalSales + totalDeliverySales), totalPurchases, totalDeliveryPurchases, (totalPurchases + totalDeliveryPurchases), (totalSales + totalDeliverySales - totalPurchases - totalDeliveryPurchases));
        System.out.println();

    }

    /**
     * The spent returns a Integer with the total spent.
     * The spent returns a Integer with the total spent from purchases.
     *
     * @return Integer returns a total spent, that is the sum of purchases and delivery of purchases
     */
    public Integer spent() {
        return totalPurchases + totalDeliveryPurchases;
    }

    /**
     * The made returns a Integer with the total made.
     * The made returns a Integer with the total made from sells.
     *
     * @return Integer returns a total spent, that is the sum of sells and delivery of sells
     */
    public Integer made() {
        return totalSales + totalDeliverySales;
    }

    /**
     * The getCompanyType returns a Type of the company.
     * The getCompanyType returns a Type of the company.
     *
     * @return Type returns a Type of company object.
     */
    public Type getCompanyType() {
        return companyType;
    }

    /**
     * The getDepotIterator returns a DepotIterator of the company.
     * The getDepotIterator returns a DepotIterator of the company.
     *
     * @return DepotIterator returns a DepotIterator object of the Company object.
     */
    public DepotIterator getDepotIterator() {
        return this.iterator;
    }

}

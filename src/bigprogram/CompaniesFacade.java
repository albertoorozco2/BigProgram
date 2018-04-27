/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

import java.util.Random;

/**
 * CompaniesFacade is the class to perform and interact with all the Depots
 * in the Companies Iterators.
 * CompaniesFacade coordinates all the transaction that are perform between the
 * the Depots of each company, in addition to Display information by using console.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class CompaniesFacade {

    private Company companyA;
    private Company companyB;
    private Company companyC;
    private Console console;
    private Type userType;
    Random rand = new Random();

    /**
     * The method used for creating the CompaniesFacade.
     * Any company you want to trade with must be passed here
     *
     * @param companyA company Object is required in order to initialize the Facade.
     * @param companyB company Object is required in order to initialize the Facade.
     * @param companyC company Object is required in order to initialize the Facade.
     * @param console console Object is required in order to initialize the Facade.
     *
     */
    public CompaniesFacade(Company companyA, Company companyB, Company companyC, Console console) {
        this.companyA = companyA;
        this.companyB = companyB;
        this.companyC = companyC;
        this.console = console;
    }

    /**
     * The treading method, display welcome message and perform all transaction. The name
     * this method call other methods in the same class to perform tall the transactions
     * of sell and buy among all the Depots, in addition it call each company to get
     * the report of profit and loss, for each company.
     *
     */
    public void treading() {

        this.userType = console.welcomeMessage();
        performTransactions();
        tradeInformationReport();
        profitAndLostReport();

    }

    /**
     * The performTransactions method, perform all the buy and sell transaction among the depots.
     * this method tall the methods sellFirstTransactions, and buyFirstTransactions, with all the possible
     * combination of the three companies to perform 120,000 transactions sell and buy among all the Depots.
     * =*
     */
    public void performTransactions() {
        console.transactionsCompletedHeader(userType);

        DepotIterator iterator1 = companyA.getDepotIterator();
        DepotIterator iterator2 = companyB.getDepotIterator();
        DepotIterator iterator3 = companyC.getDepotIterator();

        sellFirstTransactions(iterator1, iterator2);
        buyFirstTransactions(iterator1, iterator2);
        sellFirstTransactions(iterator2, iterator3);
        buyFirstTransactions(iterator2, iterator3);
        sellFirstTransactions(iterator1, iterator3);
        buyFirstTransactions(iterator1, iterator3);
        sellFirstTransactions(iterator3, iterator1);
        buyFirstTransactions(iterator3, iterator1);
        sellFirstTransactions(iterator3, iterator2);
        buyFirstTransactions(iterator3, iterator2);
        sellFirstTransactions(iterator2, iterator1);
        buyFirstTransactions(iterator2, iterator1);

    }

    /**
     * The sellFirstTransactions method, perform transaction between the depots of two iterators.
     * the methods give priority to sell transaction, get the first Depot from the iteratorOneParam, and
     * and first from the iteratorTwoParam, check if first depot can sell, and the other can buy, if the result is true
     * it perform the transaction, if the result it is false check if first depot can buy, and the other can sell,
     * if the result is false, skip this transaction. and pass to the second Depot of the iteratorTwoParam.
     * It continue the same process until there are not more Depots to perform a transaction.
     *
     * @param iteratorOneParam an Iterator with a 100 depots to perform transaction.
     * @param iteratorTwoParam another Iterator with a 100 depots to perform transaction.
     */
    public void sellFirstTransactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
        DepotIterator iteratorOne = iteratorOneParam;
        DepotIterator iteratorTwo = iteratorTwoParam;

        for (int i = 0; i < 100; i++) {
            Depot depotOne = iteratorOne.next();
            Type typeOne = depotOne.getStockItself().getStockType();
            for (int j = 0; j < 100; j++) {
                Depot depotTwo = iteratorTwo.next();
                Integer sellOne = rand.nextInt(10) + 1;
                Integer sellDeliveryOne = rand.nextInt(10) + 1;
                Integer sellTwo = rand.nextInt(10) + 1;
                Integer sellDeliveryTwo = rand.nextInt(10) + 1;
                Type typeTwo = depotTwo.getStockItself().getStockType();
                if (depotOne.possibleToSell() == true && depotTwo.possibleToBuy(depotOne.getStockItself().getStockType(), (sellOne + sellDeliveryOne)) == true) {
                    depotOne.sell(depotTwo.getName(), depotTwo.getStockItself().getStockType(), sellOne, sellDeliveryOne);
                    depotTwo.buy(depotOne.getName(), depotOne.getStockItself().getStockType(), sellOne, sellDeliveryOne);
                    if (this.userType.equals(typeOne) || this.userType.equals(typeTwo)) {
                        System.out.printf("|  Depot  %s%03d  Sales  %s  to    Depot  %s%03d   Sale:%2d   Delivery:%2d   Total:%2d  |\n",
                                typeOne, depotOne.getName(), typeOne, typeTwo, depotTwo.getName(), sellOne, sellDeliveryOne, (sellOne + sellDeliveryOne));
                    }
                } else if (depotTwo.possibleToSell() == true && depotOne.possibleToBuy(depotTwo.getStockItself().getStockType(), (sellTwo + sellDeliveryTwo)) == true) {
                    depotTwo.sell(depotOne.getName(), depotOne.getStockItself().getStockType(), sellTwo, sellDeliveryTwo);
                    depotOne.buy(depotTwo.getName(), depotTwo.getStockItself().getStockType(), sellTwo, sellDeliveryTwo);
                    if (this.userType.equals(typeTwo) || this.userType.equals(typeOne)) {
                        System.out.printf("|  Depot  %s%03d  Buys   %s  from  Depot  %s%03d    Buy:%2d   Delivery:%2d   Total:%2d  |\n",
                                typeOne, depotOne.getName(), typeTwo, typeTwo, depotTwo.getName(), sellOne, sellDeliveryOne, (sellOne + sellDeliveryOne));
                    }
                }
            }
            iteratorTwo.first();
        }
        iteratorOne.first();
    }

    /**
     * The buyFirstTransactions method, perform transaction between the depots of two iterators.
     * the methods give priority to buy transaction, get the first Depot from the iteratorOneParam, and
     * and first from the iteratorTwoParam, check if first depot can buy, and the other can sell, if the result is true
     * it perform the transaction, if the result it is false check if first depot can sell, and the other can buy,
     * if the result is false, skip this transaction. and pass to the second Depot of the iteratorTwoParam.
     * It continues the same process until there are not more Depots to perform a transaction.
     *
     * @param iteratorOneParam an Iterator with a 100 depots to perform transaction.
     * @param iteratorTwoParam another Iterator with a 100 depots to perform transaction.
     */
    public void buyFirstTransactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
        DepotIterator iteratorOne = iteratorOneParam;
        DepotIterator iteratorTwo = iteratorTwoParam;

        for (int i = 0; i < 100; i++) {
            Depot depotOne = iteratorOne.next();
            Type typeOne = depotOne.getStockItself().getStockType();
            for (int j = 0; j < 100; j++) {
                Depot depotTwo = iteratorTwo.next();
                Integer sellOne = rand.nextInt(10) + 1;
                Integer sellDeliveryOne = rand.nextInt(10) + 1;
                Integer sellTwo = rand.nextInt(10) + 1;
                Integer sellDeliveryTwo = rand.nextInt(10) + 1;
                Type typeTwo = depotTwo.getStockItself().getStockType();
                if (depotOne.possibleToSell() == true && depotTwo.possibleToBuy(depotOne.getStockItself().getStockType(), (sellOne + sellDeliveryOne)) == true) {
                    depotOne.sell(depotTwo.getName(), depotTwo.getStockItself().getStockType(), sellOne, sellDeliveryOne);
                    depotTwo.buy(depotOne.getName(), depotOne.getStockItself().getStockType(), sellOne, sellDeliveryOne);
                    if (this.userType.equals(typeOne) || this.userType.equals(typeTwo)) {
                        System.out.printf("|  Depot  %s%03d  Buys   %s  from  Depot  %s%03d    Buy:%2d   Delivery:%2d   Total:%2d  |\n",
                                typeTwo, depotTwo.getName(), typeOne, typeOne, depotOne.getName(), sellTwo, sellDeliveryTwo, (sellTwo + sellDeliveryTwo));
                    }
                } else if (depotTwo.possibleToSell() == true && depotOne.possibleToBuy(depotTwo.getStockItself().getStockType(), (sellTwo + sellDeliveryTwo)) == true) {
                    depotTwo.sell(depotOne.getName(), depotOne.getStockItself().getStockType(), sellTwo, sellDeliveryTwo);
                    depotOne.buy(depotTwo.getName(), depotTwo.getStockItself().getStockType(), sellTwo, sellDeliveryTwo);
                    if (this.userType.equals(typeTwo) || this.userType.equals(typeOne)) {
                        System.out.printf("|  Depot  %s%03d  Sales  %s  to    Depot  %s%03d   Sale:%2d   Delivery:%2d   Total:%2d  |\n",
                                typeTwo, depotTwo.getName(), typeTwo, typeOne, depotOne.getName(), sellTwo, sellDeliveryTwo, (sellTwo + sellDeliveryTwo));
                    }
                }
            }
            iteratorTwo.first();
        }
        iteratorOne.first();
    }

    /**
     * The tradeInformationReport method, call each company to gather the information of transactions of each Company.
     * The method call each company to gather the information of transactions of each Company and the company is the same that
     * the user chosen it will print the result of trade of each Depot.
     */
    public void tradeInformationReport() {
        console.tradeInformationHeader(this.userType);
        companyA.tradeInformationByDepot(this.userType);
        companyB.tradeInformationByDepot(this.userType);
        companyC.tradeInformationByDepot(this.userType);
        console.horizontalLine();

    }

    /**
     * The profitAndLostReport method, call each company to get the profit and loss report of each company.
     * The method call console to print a header for the table, and each company and print the profit and lost of each Company.
     */
    public void profitAndLostReport() {
        console.profitAndLossHeader();
        companyA.profitAndLost();
        companyB.profitAndLost();
        companyC.profitAndLost();
        console.horizontalLine();

        Integer mostSpent = companyA.spent();
        Company mostSpentCompany = companyA;
        if (mostSpent < companyB.spent()) {
            mostSpent = companyB.spent();
            mostSpentCompany = companyB;
        }
        if (mostSpent < companyC.spent()) {
            mostSpent = companyC.spent();
            mostSpentCompany = companyC;
        }
        System.out.printf("Company spent the most: Big-%1s Total Spent: $ %,6d \n", mostSpentCompany.getCompanyType(), mostSpentCompany.spent());

        Integer mostMade = companyA.made();
        Company mostMadeCompany = companyA;
        if (mostMade < companyB.made()) {
            mostMade = companyB.made();
            mostMadeCompany = companyB;
        }
        if (mostMade < companyC.made()) {
            mostMade = companyC.made();
            mostMadeCompany = companyC;
        }
        System.out.printf("Company made  the most: Big-%1s Total  Made: $ %,6d \n", mostMadeCompany.getCompanyType(), mostMadeCompany.made());
    }
}

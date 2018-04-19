/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigprogram;

import java.util.Random;

/**
 *
 * @author A1
 */
public class CompaniesFacade {

    private Company companyA;
    private Company companyB;
    private Company companyC;
//    private DepotIterator iteratorA;
//    private DepotIterator iteratorB;
//    private DepotIterator iteratorC;
    private Console console;
    private String userType;
    public Integer TryingNum = 0;
    Random rand = new Random();

    public CompaniesFacade(Company companyA, Company companyB, Company companyC, Console console) {
        this.companyA = companyA;
        this.companyB = companyB;
        this.companyC = companyC;
        this.console = console;
    }

    public void treading() {

        this.userType = console.welcomeMessage();
        
//        iteratorA = companyA.getDepotIterator();
//        iteratorB = companyB.getDepotIterator();
//        iteratorC = companyC.getDepotIterator();
        performTransactions(companyA.getDepotIterator(), companyB.getDepotIterator(), companyC.getDepotIterator());
        tradeInformationReport();
        profitAndLostReport();

    }

    public void performTransactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam, DepotIterator iteratorThreeParam) {
        console.transactionsCompletedHeader(userType);

        DepotIterator iterator1 = iteratorOneParam;
        DepotIterator iterator2 = iteratorTwoParam;
        DepotIterator iterator3 = iteratorThreeParam;

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

    public void sellFirstTransactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
        DepotIterator iteratorOne = iteratorOneParam;
        DepotIterator iteratorTwo = iteratorTwoParam;

        Depot depotOne;
        String typeOne;
        Integer sellOne;
        Integer sellDeliveryOne;
        Depot depotTwo;
        String typeTwo;
        Integer sellTwo;
        Integer sellDeliveryTwo;
//        Integer count = 0;

        for (int i = 0; i < 100; i++) {
            depotOne = iteratorOne.next();
            typeOne = depotOne.stockItself.getStockType();

            for (int j = 0; j < 100; j++) {
                depotTwo = iteratorTwo.next();
                sellOne = rand.nextInt(10) + 1;
                sellDeliveryOne = rand.nextInt(10) + 1;
                sellTwo = rand.nextInt(10) + 1;
                sellDeliveryTwo = rand.nextInt(10) + 1;
                typeTwo = depotTwo.stockItself.getStockType();
                //                System.out.println(TryingNum++);
                if (depotOne.possibleToSell() == true && depotTwo.possibleToBuy(depotOne.stockItself.getStockType(), (sellOne + sellDeliveryOne)) == true) {
                    // System.out.println(transactionNum++);
                    depotOne.sell(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    depotTwo.buy(depotOne.getName(), depotOne.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    if (this.userType.equals(typeOne) || this.userType.equals(typeTwo)) {

                        System.out.printf("|  Depot  %s%03d  Sales  %s  to    Depot  %s%03d   Sale:%2d   Delivery:%2d   Total:%2d  |",
                                typeOne, depotOne.getName(), typeOne, typeTwo, depotTwo.getName(), sellOne, sellDeliveryOne, (sellOne + sellDeliveryOne));
                        System.out.println();

                    }

                } else if (depotTwo.possibleToSell() == true && depotOne.possibleToBuy(depotTwo.stockItself.getStockType(), (sellTwo + sellDeliveryTwo)) == true) {
                    // System.out.println(transactionNum++);
                    depotTwo.sell(depotOne.getName(), depotOne.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    depotOne.buy(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    if (this.userType.equals(typeTwo) || this.userType.equals(typeOne)) {
                        System.out.printf("|  Depot  %s%03d  Buys   %s  from  Depot  %s%03d    Buy:%2d   Delivery:%2d   Total:%2d  |",
                                typeOne, depotOne.getName(), typeTwo, typeTwo, depotTwo.getName(), sellOne, sellDeliveryOne, (sellOne + sellDeliveryOne));
                        System.out.println();

                    }
                }

            }
            iteratorTwo.first();
        }
        iteratorOne.first();
    }

    public void buyFirstTransactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
        DepotIterator iteratorOne = iteratorOneParam;
        DepotIterator iteratorTwo = iteratorTwoParam;

        Depot depotOne;
        String typeOne;
        Integer sellOne;
        Integer sellDeliveryOne;
        Depot depotTwo;
        String typeTwo;
        Integer sellTwo;
        Integer sellDeliveryTwo;
        Integer count = 0;

        for (int i = 0; i < 100; i++) {
            depotOne = iteratorOne.next();
            typeOne = depotOne.stockItself.getStockType();

            for (int j = 0; j < 100; j++) {
                depotTwo = iteratorTwo.next();
                sellOne = rand.nextInt(10) + 1;
                sellDeliveryOne = rand.nextInt(10) + 1;
                sellTwo = rand.nextInt(10) + 1;
                sellDeliveryTwo = rand.nextInt(10) + 1;
                typeTwo = depotTwo.stockItself.getStockType();
                //               System.out.println(TryingNum++);

                if (depotOne.possibleToSell() == true && depotTwo.possibleToBuy(depotOne.stockItself.getStockType(), (sellOne + sellDeliveryOne)) == true) {
                    // System.out.println(transactionNum++);
                    depotOne.sell(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    depotTwo.buy(depotOne.getName(), depotOne.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    if (this.userType.equals(typeOne) || this.userType.equals(typeTwo)) {
                        System.out.printf("|  Depot  %s%03d  Buys   %s  from  Depot  %s%03d    Buy:%2d   Delivery:%2d   Total:%2d  |",
                                typeTwo, depotTwo.getName(), typeOne, typeOne, depotOne.getName(), sellTwo, sellDeliveryTwo, (sellTwo + sellDeliveryTwo));
                        System.out.println();

                    }
                } else if (depotTwo.possibleToSell() == true && depotOne.possibleToBuy(depotTwo.stockItself.getStockType(), (sellTwo + sellDeliveryTwo)) == true) {
                    // System.out.println(transactionNum++);
                    depotTwo.sell(depotOne.getName(), depotOne.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    depotOne.buy(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    if (this.userType.equals(typeTwo) || this.userType.equals(typeOne)) {

                        System.out.printf("|  Depot  %s%03d  Sales  %s  to    Depot  %s%03d   Sale:%2d   Delivery:%2d   Total:%2d  |",
                                typeTwo, depotTwo.getName(), typeTwo, typeOne, depotOne.getName(), sellTwo, sellDeliveryTwo, (sellTwo + sellDeliveryTwo));
                        System.out.println();

                    }

                }

            }
            iteratorTwo.first();
        }
        iteratorOne.first();
    }

    public void tradeInformationReport() {
        console.tradeInformationHeader(this.userType);
        companyA.tradeInformationByDepot(this.userType);
        companyB.tradeInformationByDepot(this.userType);
        companyC.tradeInformationByDepot(this.userType);
        console.horizontalLine();

    }

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

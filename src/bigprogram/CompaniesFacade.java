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
    private DepotIterator iteratorA;
    private DepotIterator iteratorB;
    private DepotIterator iteratorC;
    private String userType;
//    DepotIterator iteratorA = companyA.getIterator();
//    DepotIterator iteratorB = companyB.getIterator();
//    DepotIterator iteratorC = companyC.getIterator();
    Random rand = new Random();
    Console console = new Console();

    public CompaniesFacade() {
        companyA = new Company("A");
        companyB = new Company("B");
        companyC = new Company("C");

    }

    public void treading(String userType) {

        this.userType = userType;

        iteratorA = companyA.getDepotIterator();
        iteratorB = companyB.getDepotIterator();
        iteratorC = companyC.getDepotIterator();
        console.transactionsCompletedHeader(userType);
        transactions(iteratorA, iteratorB);
        transactions(iteratorC, iteratorB);
        transactions(iteratorC, iteratorA);
        console.tradeInformationHeader(userType);
        companyA.tradeInformationByDepot(userType.equals("A"));
        companyB.tradeInformationByDepot(userType.equals("B"));
        companyC.tradeInformationByDepot(userType.equals("C"));
        console.horizontalLine();

        console.profitAndLossHeader();
        companyA.profitAndLost("A");
        companyB.profitAndLost("B");
        companyC.profitAndLost("C");
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

    public void transactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
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

}

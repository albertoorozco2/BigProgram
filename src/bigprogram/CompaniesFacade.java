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

    public void Treading(String userType) {

        this.userType = userType;

        iteratorA = companyA.getIterator();
        iteratorB = companyB.getIterator();
        iteratorC = companyC.getIterator();
        console.TransactionCompletedHeader(userType);
        Transactions(iteratorA, iteratorB);
        Transactions(iteratorA, iteratorC);
        Transactions(iteratorB, iteratorC);
        console.TradeInformationHeader(userType);
        companyA.tradeInformationByDepot(userType.equals("A"));
        companyB.tradeInformationByDepot(userType.equals("B"));
        companyC.tradeInformationByDepot(userType.equals("C"));
        console.ProfitAndLossHeader();
        companyA.profitAndLost("A");
        companyB.profitAndLost("B");
        companyC.profitAndLost("C");
        System.out.println("-------------------------------------------------------------------------------");

        Integer mostSpent = companyA.Spent();
        Company mostSpentCompany = companyA;
        if (mostSpent < companyB.Spent()) {
            mostSpent = companyB.Spent();
            mostSpentCompany = companyB;
        }
        if (mostSpent < companyC.Spent()) {
            mostSpent = companyC.Spent();
            mostSpentCompany = companyC;
        }
        System.out.println("Company spent the most: Big " + mostSpentCompany.CompanyType() + " Total Spent : " + mostSpentCompany.Spent());

        Integer mostMade = companyA.Spent();
        Company mostMadeCompany = companyA;
        if (mostMade < companyB.Made()) {
            mostMade = companyB.Spent();
            mostMadeCompany = companyB;
        }
        if (mostMade < companyC.Made()) {
            mostMade = companyC.Spent();
            mostMadeCompany = companyC;
        }
        System.out.println("Company made the most: Big " + mostMadeCompany.CompanyType() + " Total Made : " + mostMadeCompany.Made());
    }

    public void Transactions(DepotIterator iteratorOneParam, DepotIterator iteratorTwoParam) {
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
                if (depotOne.PossibleToSell() == true && depotTwo.PossibleToBuy(depotOne.stockItself.getStockType(), (sellOne + sellDeliveryOne)) == true) {
                    // System.out.println(transactionNum++);
                    depotOne.Sell(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    depotTwo.Buy(depotOne.getName(), depotOne.stockItself.getStockType(), sellOne, sellDeliveryOne);
                    if (this.userType.equals(typeOne) || this.userType.equals(typeTwo)) {

                        System.out.printf("  Depot  %s%03d  Sales  %s  to    Depot  %s%03d   Sale:%2d   Delivery:%2d   Total:%2d",
                                typeOne, depotOne.getName(), typeOne, typeTwo, depotTwo.getName(), sellOne, sellDeliveryOne, (sellOne + sellDeliveryOne));
                        System.out.println();

                    }

                } else if (depotTwo.PossibleToSell() == true && depotOne.PossibleToBuy(depotTwo.stockItself.getStockType(), (sellTwo + sellDeliveryTwo)) == true) {
                    // System.out.println(transactionNum++);
                    depotTwo.Sell(depotOne.getName(), depotOne.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    depotOne.Buy(depotTwo.getName(), depotTwo.stockItself.getStockType(), sellTwo, sellDeliveryTwo);
                    if (this.userType.equals(typeTwo) || this.userType.equals(typeOne)) {
                        System.out.printf("  Depot  %s%03d  Buys   %s  from  Depot  %s%03d    Buy:%2d   Delivery:%2d   Total:%2d",
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

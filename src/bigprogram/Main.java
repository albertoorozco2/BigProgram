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

public class Main {
    public static DepotBuilder depotBuilder = new DepotBuilder();

    public static void main(String[] args) {
         depotBuilder.BuildDepot(1, "A");
         Depot first = depotBuilder.getDepot();
         depotBuilder.BuildDepot(1, "B");
         Depot second = depotBuilder.getDepot();
//         Boolean day = first.PossibleBuy(second.stockItself.getStockType(), 10);
       // first.Buy(second.getName(), second.stockItself.getStockType(), 2, 1);
       first.getName();
       first.PossibleSell();
       first.TradeInformation();
       first.Sell(first.getName(), first.stockItself.getStockType(), 10, 10);
       first.TradeInformation();
       first.PossibleSell();
       first.TradeInformation();
       first.PossibleBuy(second.stockItself.getStockType(), 10);
       first.TradeInformation();
       first.Buy(second.getName(), second.stockItself.getStockType(), 22, 2);
       first.TradeInformation();
       first.PossibleBuy(second.stockItself.getStockType(), 10);
       first.Buy(second.getName(), second.stockItself.getStockType(), 2, 22);
       first.TradeInformation();
    }
 
}

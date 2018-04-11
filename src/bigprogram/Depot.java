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
public class Depot {

    private Integer name = null;
    Stock stockItself = null;
    private Stock stockOther = null;
    private Stock stockAnother = null;
    Allowance allowance = null;

    public Depot() {
    }

    public void setStockItself(Stock stockItself) {
        this.stockItself = stockItself;
    }

    public void setStockOther(Stock stockOther) {
        this.stockOther = stockOther;
    }

    public void setStockAnother(Stock stockAnother) {
        this.stockAnother = stockAnother;
    }

    public void setAllowance(Allowance allowance) {
        // System.out.print("this allowance"+allowance);
        this.allowance = allowance;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getName() {
        //   System.out.println("name = " +this.name );
        return this.name;
    }

    public Boolean possibleToSell() {
//               System.out.println("posible sel = " +this.stockItself.getStockAmount() );
        //      System.out.println("posible sel = " +(this.stockItself.stockAmount>15) );

        return this.stockItself.getStockAmount() > 15;
    }

    public void sell(Integer name, String type, Integer sales, Integer deliverySales) {
        //       System.out.println("stock deliverySales : " +deliverySales+" sales: "+sales );

        this.stockItself.sellStock();
        this.allowance.setSales(sales);
        this.allowance.setDeliverSales(deliverySales);
        //         System.out.printf("Depot%s%03d sales %s from Depot%s%03d Sale %2d Delivery Sale %2d, Total %2d",
        //                        this.stockItself.getStockType(), this.name, this.stockItself.getStockType(),  type, name, sales, deliverySales, (sales+deliverySales));
        //        System.out.println();

    }

    public Boolean possibleToBuy(String type, Integer amount) {
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
        //System.out.println("posible Buy "+test);
        return test;
    }

    public void buy(Integer nameDepot, String type, Integer purchase, Integer deliveryPurchase) {
        //            System.out.println(type+" "+stockOther.getStockType());
        //            System.out.println(type+" "+stockAnother.getStockType());

        //      System.out.println(type.equals(stockOther.getStockType()));
        //     System.out.println(type == stockAnother.getStockType());
        if (type.equals(stockOther.getStockType())) {
            stockOther.buyStock();
            allowance.setPurchases(purchase);
            allowance.setDeliverPurchases(deliveryPurchase);
        } else if (type.equals(stockAnother.getStockType())) {
            stockAnother.buyStock();
            allowance.setPurchases(purchase);
            allowance.setDeliverPurchases(deliveryPurchase);
        }
        // System.out.printf("Depot%s%03d purchase %s from Depot%s%03d Purchase %2d Delivery Purchase %2d, Total %2d",
        //                     this.stockItself.getStockType(), this.name, type, type, nameDepot, purchase, deliveryPurchase, (purchase+deliveryPurchase));
        // System.out.println();
    }

    public void tradeInformationPrint() {
        System.out.printf("| DEPOT%5s | %,10d | %,10d | %,10d | %,10d | %,10d |", this.stockItself.getStockType() + this.name, allowance.getSales(), allowance.getDeliverSales(), stockItself.getUnitSold(), allowance.getPurchases(), allowance.getDeliverPurchases());
        System.out.println();
  //      System.out.printf("| DEPOT%5s | %,10d | %,10d | %,10d | %,10d | %,10d |", this.stockItself.getStockType() + this.name, 0, 0, stockItself.stockInitial, this.stockAnother.getStockAmount(), this.stockOther.getStockAmount());
  //
//        System.out.println(" Iallowance>"+ allowance.initialAllowance +
//                            " Falowance>"+allowance.getAllowance()+
//                            " Istocki>"+ stockItself.stockInitial+
//                            " FStocki>"+stockItself.getStockAmount()+
//                            " IStockO>"+stockOther.stockInitial+
//                            " FStockO>"+stockOther.getStockAmount()+
//                            " IStockA>"+stockAnother.stockInitial+
//                            " FStockA>"+stockAnother.getStockAmount()
//                );
          
                   
    }

}

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
public class Stock {

    private Type stockType;
    private Integer stockAmount = 0;
    public Integer stockInitial = 0;

    public Stock(Type stockType, Integer stockAmount) {
        this.stockType = stockType;
        this.stockAmount = stockAmount;
        this.stockInitial = stockAmount;
    //    System.out.println(stockInitial);
        //  System.out.println("Stocktype = " +stockType+"   stockamount= "+ stockAmount );

    }

    public Type getStockType() {
        //  System.out.println("Stocktype -" +this.stockType );

        return this.stockType;
    }

    public Integer getStockAmount() {
        // System.out.println("stockAmount -" +this.stockAmount );

        return this.stockAmount;
    }

    public Integer getUnitSold() {
        //   System.out.println("getUnitSold -" + (this.stockInitial - this.stockAmount) );
        return this.stockInitial - this.stockAmount;
    }

    public void sellStock() {
        this.stockAmount = this.stockAmount - 1;
        //System.out.println("stockAmount : " +this.stockAmount );
    }

    public void buyStock() {
        this.stockAmount = this.stockAmount + 1;
        // System.out.println("stockAmount -" +this.stockAmount );

    }
}

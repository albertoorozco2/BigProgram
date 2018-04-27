/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Stock is the class to hold and keep track of specific the stock.
 * Stock is the class to hold and keep track of specific the stock.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public class Stock {

    private Type stockType;
    private Integer stockAmount = 0;
    private Integer stockInitial = 0;

    /**
     * The Stock used for initialization of the Stock Object require the Type of STock and the Amount.
     * The Stock used for initialization of the Stock Object require the Type of STock and the Amount.
     *
     * @param stockType a Type of stock to be stored
     * @param stockAmount amount of the stock to be stored
     */
    public Stock(Type stockType, Integer stockAmount) {
        this.stockType = stockType;
        this.stockAmount = stockAmount;
        this.stockInitial = stockAmount;

    }

    /**
     * The getStockType return an Type of the Stock object.
     * The getStockType return an Type of the Stock object.
     *
     * @return Type the type of the stock.
     */
    public Type getStockType() {
        return this.stockType;
    }

    /**
     * The getStockAmount return an amount available of the Stock object.
     * The getStockAmount return an amount available of the Stock object.
     *
     * @return Integer amount available of the Stock.
     */
    public Integer getStockAmount() {
        return this.stockAmount;
    }

    /**
     * The getUnitSold return an amount units sold of the Stock object.
     * The getUnitSold return an amount units sold of the Stock object,
     * by subtracting the actual amount from the initial amount.
     *
     * @return Integer amount units sold of the Stock.
     */
    public Integer getUnitSold() {
        return this.stockInitial - this.stockAmount;
    }

    /**
     * The sellStock register the sell of one unit.
     * The sellStock register the sell of one unit,
     * by subtracting a unit from the stock amount.
     *
     */
    public void sellStock() {
        this.stockAmount = this.stockAmount - 1;
    }

    /**
     * The buyStock register the buy of one unit.
     * The buyStock register the buy of one unit.
     * by adding a unit from to stock amount.
     *
     */
    public void buyStock() {
        this.stockAmount = this.stockAmount + 1;

    }
}

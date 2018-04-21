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
public class DepotBuilder {

    private Integer name = null;
    private Stock stockItself = null;
    private Stock stockOther  = null;
    private Stock stockAnother = null;
    private Allowance allowance  =null;
    private Depot depot = null;
    Random rand = new Random();
    
    public DepotBuilder() {

    }
    
    public void buildDepot (Integer name, Type type){
    //    System.out.println(type);
          depot = new Depot();   
     switch (type) {
            case A:  this.stockItself = new Stock(type.A, (rand.nextInt((50 - 15) + 1) + 15));
                       this.stockOther = new Stock(type.B, (rand.nextInt((40 - 3) + 1) + 3));
                       this.stockAnother = new Stock(type.C, (rand.nextInt((40 - 3) + 1) + 3));
                       this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                     break;
            case B:  this.stockItself = new Stock(Type.B, (rand.nextInt((50 - 15) + 1) + 15));
                       this.stockOther = new Stock(Type.C, (rand.nextInt((40 - 3) + 1) + 3));
                       this.stockAnother = new Stock(Type.A, (rand.nextInt((40 - 3) + 1) + 3));
                       this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                     break;
            case C:  this.stockItself = new Stock(Type.C, (rand.nextInt((50 - 15) + 1) + 15));
                       this.stockOther = new Stock(Type.A, (rand.nextInt((40 - 3) + 1) + 3));
                       this.stockAnother = new Stock(Type.B, (rand.nextInt((40 - 3) + 1) + 3));
                       this.allowance = new Allowance((rand.nextInt((100 - 40) + 1) + 40));
                     break;
            default: System.out.println("Invalid Type");
                     break;
        }
     this.depot.setName(name); 
     this.depot.setStockItself(this.stockItself);
     this.depot.setStockOther(this.stockOther);
     this.depot.setStockAnother(this.stockAnother);
     this.depot.setAllowance(this.allowance);
    }
    
    public Depot getNewDepot(Integer name, Type type){
        buildDepot (name, type);
        return depot;
    }
  
}

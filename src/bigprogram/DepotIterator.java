/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigprogram;

import java.util.Iterator;

/**
 *
 * @author A1
 */
public class DepotIterator implements Iterator<Depot> {

    private Depot[] depots;
    int pos;

    public DepotIterator(Depot[] depots) {
        this.depots = depots;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        if (pos >= depots.length || depots[pos] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Depot next() {
        return depots[pos++];
    }
    
    public void first() {
         pos = 0;
    }
   

}

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
public enum Type {
    A("A"), B("B"), C("C"), X("X");
    public String name;

    private Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

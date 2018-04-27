/*
 * College of Computing Technology.
 * Object Orientation with Design
 * Teacher: Mark Morrissey
 */
package bigprogram;

/**
 * Type is the enum to hold allow types "A", "B", "C" and "X".
 * Type is the enum to hold allow types "A", "B", "C" and "X",
 * type A, B, C, are the allow companies name and Type, 
 * and X it is used in case user does not select a specific company, 
 * adnd decides to trade autonomously.
 *
 * @author Alberto Orozco
 * @author Roberto Rivera
 * @author Camila Silva
 */
public enum Type {
    A("A"), B("B"), C("C"), X("X");
    public String name;
    /**
     * The Type required a String to set name of the Type.
     * The Type required a String to set name of the Type.
     *
     * @param name a String name of stock type.
     */
    private Type(String name) {
        this.name = name;
    }
    /**
     * The toString return a String to of name of the Type.
     * The toString return a String to of name of the Type.
     *
     * @return String name of stock type.
     */
    @Override
    public String toString() {
        return name;
    }
}

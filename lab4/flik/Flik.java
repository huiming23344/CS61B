package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */

    // use .equals if you want to check if the two objects are "equal"
    // use == when you want to see if they point to the same instance
    // @Source
    // https://stackoverflow.com/questions/1700081/why-is-128-128-false-but-127-127-is-true-when-comparing-integer-wrappers-in-ja
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b);
    }
}

package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testRandomlyExample () {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        L.addLast(1);
        BuggyAList<Integer> broken = new BuggyAList<>();
        broken.addLast(1);
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
                int size = L.size();
                //System.out.println("size:" + size);
                //System.out.println("----------------------------");
            } else if (operationNumber == 1) {
                // getLast
                if (L.size() > 0) {
                    int rightLast = L.getLast();
                    int testLast = broken.getLast();
                    if (rightLast != testLast) {
                        System.out.println("shouldGet:" + rightLast);
                        System.out.println("butGet:" + testLast);
                        int rsize = L.size();
                        int tsize = broken.size();
                        System.out.println("size: " + rsize);
                        System.out.println("size: " + tsize);
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("nothingHappened");
                        System.out.println("----------------------------");
                    }
                }
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    L.removeLast();
                    broken.removeLast();
                    int rsize = L.size();
                    int tsize = broken.size();
                    //System.out.println("remove");
                    //System.out.println("size: " + rsize);
                    //System.out.println("size: " + tsize);
                    //System.out.println("----------------------------");
                }
            }
        }
    }
}

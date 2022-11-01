package deque;

import org.junit.Test;
import org.junit.Assert.*;

import java.util.Deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {

    @Test
    /**
     *  Add a few things to the list checking .isEmpty() .size()
     */
    public void sizeIsEmptyTest(){
        Deque<Integer> test = new ArrayDeque<>();
        assertEquals(0, test.size());


        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        assertEquals(3, test.size());
    }

    @Test
    /**
     * Add things use .addLast() checking whether the array is correctly circular
     */
    public void circularTest(){
        Deque<Integer> test = new ArrayDeque<>();
        test.addLast(1);
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        assertEquals(4, test.size());
        int fouth = 0;
        boolean isOffered = test.offerLast(fouth);
        assertTrue(isOffered);
        assertEquals(4, fouth);
    }
}

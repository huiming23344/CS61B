package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {


    @Test
    /**
     *  Add a few things to the list checking .isEmpty() .size()
     */
    public void sizeIsEmptyTest(){
        ArrayDeque<Integer> test = new ArrayDeque<>();
        assertEquals(0, test.size());


        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        assertEquals(3, test.size());
    }

    @Test
    /**
     * Add things use .addLast() and .removeLast
     * to check whether the array is correctly circular
     */
    public void circularTest(){

        // test whether .addLast() and .removeLast() goes well
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 1; i < 5; i++) {
            test.addLast(i);
        }
        assertEquals(4, test.size());
        int last = test.removeLast();
        assertEquals(4, last);
        last = test.removeLast();
        assertEquals(3, last);
        assertEquals(2, test.size());
        last = test.removeLast();
        assertEquals(2, last);
        assertEquals(1, test.size());

        // test whether .addFirst() and .removeFirst() goes well
        test.clear();
        // fully fill the deque test
        for (int i = 0; i < 8; i++) {
            test.addFirst(i);
        }
        int first = test.removeFirst();;
        assertEquals(7, first);
        assertEquals(7,test.size());
    }
    @Test
    /**
     * need to be checked:
     * 1. is circular rightly?
     * 2. the Deque is not changed
     *
     */
    public void arrayDequeTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 7; i++) {
            test.addFirst(i);
        }
        test.printDeque();

    }

    @Test
    /**
     * manually resize an arraydeque
     */
    public void manuallyResize() {
//        for (int i = 0; i < 7; i++) {
//            test.addFirst(i);
//        }
//        test.resize(16);
//        for (int i = 0; i < 7; i++) {
//            test.addFirst(i);
//        }
        //test.printDeque();

        // resize the array auto
        ArrayDeque<Integer> test2 = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            test2.addFirst(i);
        }
        test2.printDeque();
        System.out.println("---------------------------");
        for (int i = 0; i < 8; i++) {
            test2.removeFirst();
        }
        test2.printDeque();
    }

    @Test
    /**
     * add few items and test .get()
     */
    public void getTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            test.addFirst(i);
        }
        int toBeTest = test.get(0);
        assertEquals(4, toBeTest);
        toBeTest = test.get(1);
        assertEquals(3, toBeTest);
        toBeTest = test.get(3);
        assertEquals(1, toBeTest);
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        ArrayDeque<Integer> test2 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            test1.addFirst(i);
            test2.addFirst(i);
        }
        assertTrue(test1.equals(test1));
        assertTrue(test1.equals(test2));
        assertTrue(test2.equals(test1));

        test1.addFirst(2);
        assertFalse(test1.equals(test2));

        test2.addFirst(4);
        assertFalse(test1.equals(test2));
    }
}

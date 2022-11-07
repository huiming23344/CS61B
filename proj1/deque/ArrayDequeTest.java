package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Deque;
import java.util.Iterator;

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

    @Test
    public void randomTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        Deque<Integer> solution = new java.util.ArrayDeque<>();
        assertTrue(test.isEmpty());
        assertTrue(solution.isEmpty());
        int times = 100000;
        for (int i = 0; i < times; i++) {
            int operationCode = StdRandom.uniform(0, 5);
            if (operationCode == 0 || test.size() == 0) {
                // test the add func
                int toBeAdd = StdRandom.uniform(0, 100);
                test.addFirst(toBeAdd);
                solution.addFirst(toBeAdd);
                assertEquals(test.size(), solution.size());
            }
            if (operationCode == 1) {
                int toBeAdd = StdRandom.uniform(0, 100);
                test.addLast(toBeAdd);
                solution.addLast(toBeAdd);
                assertEquals(test.size(), solution.size());
            }
            if (operationCode == 2) {
                // test the remove func
                int num_stu = test.removeFirst();
                int num_sol = solution.removeFirst();
                assertEquals(num_sol, num_stu);
                assertEquals(test.size(), solution.size());
            }
            if (operationCode == 3) {
                assertEquals(test.size(), solution.size());
                int size = solution.size();
                int sol = solution.removeLast();
                int sul = test.removeLast();

                assertEquals(test.size(), solution.size());
            }
            if (operationCode == 6) {
                // test get func
                int Index = StdRandom.uniform(0, test.size());
                int stu = test.get(Index);
                //int sol = solution.get(Index);
                //assertEquals(stu, sol);
                //assertEquals(test.size(), solution.size());
            }
        }
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 1000; i++) {
            test.addLast(i);

        }
        System.out.println("size:" + test.size());
        int times = 100;
        for (int j = 0; j < times; j++) {
            for (int i = 0; i < 1000; i++) {
                test.addLast(i);
            }
            for (int i = 0; i < 999; i++) {
                int k = test.removeLast();
                System.out.println("" + k);
            }
        }
        //test.printDeque();
    }

    @Test
    /**
     * now I believe that the wrong maybe about the iter
     */
    public void hasNextTest() {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 9; i++) {
            System.out.println("add" + i);
            test.addLast(i);
        }
        test.printDeque();
        test.addLast(3);
        test.printDeque();
    }
}


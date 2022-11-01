package deque;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {

    /**
     * create a new int ArrayDeque from 1 to size use addFirst
     * @param size
     * @return Deque<Integer>
     */
    private ArrayDeque<Integer> createDeque(int size) {
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            ans.addFirst(i);
        }
        return ans;
    }

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
     * TODO:test if remove and add work well
     * 1. add over
     * 2. remove over
     */
    public void circularTest(){
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addLast(1);
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        assertEquals(4, test.size());
        int last = test.removeLast();
        assertEquals(4, last);
        last = test.removeLast();
        assertEquals(3, last);
        assertEquals(2, test.size());
    }
    @Test
    /**
     * need to be checked:
     * 1. is circular rightly?
     * 2. the Deque is not changed
     *
     * TODO: test the getAllItems func!
     */
    public void getAllItemsTest() {
    }
}

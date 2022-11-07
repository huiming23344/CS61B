package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void testAll() {
        IntComparator c = new IntComparator();
        MaxArrayDeque<Integer> test = new MaxArrayDeque<>(c);
        for (int i = 0; i < 8; i++) {
            test.addFirst(i);
        }
        int max = test.max();
        System.out.println(max);
    }
}

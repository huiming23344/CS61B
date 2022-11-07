package deque;

import java.util.Comparator;

public class IntComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if ((int) o1 == (int) o2) {
            return 0;
        } else {
            return (int) o1 - (int) o2;
        }
    }
}

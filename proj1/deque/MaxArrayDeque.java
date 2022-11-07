package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<item> extends ArrayDeque<item>{

    private item maxItem;
    private Comparator<item> comparator;

    public MaxArrayDeque(Comparator<item> c) {
        comparator = c;
    }

    public item max() {
        if (size() == 0) {
            return null;
        } else {
            item max_item = get(0);
            Iterator<item> iter = iterator();
            while (iter.hasNext()) {
                item to_comparator = iter.next();
                if (comparator.compare(max_item, to_comparator) < 0) {
                    max_item = to_comparator;
                }
            }
            return max_item;
        }
    }

    public item max(Comparator<item> c) {
        if (size() == 0) {
            return null;
        } else {
            item max_item = get(0);
            Iterator<item> iter = iterator();
            while (iter.hasNext()) {
                item to_comparator = iter.next();
                if (c.compare(max_item, to_comparator) > 0) {
                    max_item = to_comparator;
                }
            }
            return max_item;
        }
    }
}

package deque;

import net.sf.saxon.om.Item;

import java.security.DrbgParameters;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<item> implements Deque<item> , Iterable<item>{

    private class ArrayDequeIterator implements Iterator<item> {
        int cur_pointer;

        public ArrayDequeIterator(){
            cur_pointer = first;
        }
        @Override
        public boolean hasNext() {
            return (cur_pointer != last + 1 || (cur_pointer == 0 && last == capacity - 1));
        }

        @Override
        public item next() {
            if (cur_pointer == 0) {
                cur_pointer = capacity - 1;
            } else {
                cur_pointer--;
            }
            return items[cur_pointer];
        }
    }
    private item[] items;
    private int size;
    int first = 3;
    int last = 2;
    public int capacity = 8;

    public ArrayDeque(){
        items = (item[]) new Object[capacity];
        size = 0;
    }
    public ArrayDeque(int new_cap) {
        capacity = new_cap;
        items = (item[]) new Object[new_cap];
        size = 0;
    }


     public Iterator<item> Iterator(){
        Iterator<item> ans = new ArrayDequeIterator();
        return ans;
     }

    // TODO: after done with the iterator implement the .reSize func
    // change this to private while done
    public void resize(int new_capacity) {
        if (size > capacity) {
            System.out.println("The size is bigger then capacity!");
        } else {
            ArrayDeque<item> new_deque = new ArrayDeque<>(new_capacity);
            Iterator<item> oldItemIter = new ArrayDequeIterator();
            while (oldItemIter.hasNext()) {
                new_deque.addLast(oldItemIter.next());
            }
            items = new_deque.items;
            first = new_deque.first;
            last = new_deque.last;
            capacity = new_deque.capacity;
        }
    }


    /**
     * print all the items in Deque
     * or print it is empty
     */
    public void printDeque() {
        if (size == 0) {
            System.out.println("It is an empty Deque");
        } else {
            Iterator<item> iterArrayDeque = new ArrayDequeIterator();
            while (iterArrayDeque.hasNext()) {
                System.out.println("" + iterArrayDeque.next());
            }
        }
    }

    @Override
    public void addFirst(item item) {
        items[first] = item;
        size++;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first++;
        }
        // if the size of deque is larger than 75% of the array
        // resize the array double
        if (size >= (items.length * 0.75)) {
            resize(capacity * 2);
        }
    }

    @Override
    public void addLast(item item) {
        items[last] = item;
        size++;
        if (last == 0) {
            last = capacity - 1;
        } else {
            last--;
        }
        // if the size of deque is larger than 75% of the array
        // resize the array double
        if (size >= (items.length * 0.75)) {
            resize(capacity * 2);
        }
    }

    @Override
    /**
     * the .offerFirst(item) is a func that add an item to first
     * if failed it will not throw an exception like add func
     * rather than just return false when the Deque is full
     *
     * but here we will handle the size automatically
     * it just simply return true
     */
    public boolean offerFirst(item item) {
        items[first] = item;
        size++;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first++;
        }
        return true;
    }

    @Override
    public boolean offerLast(item item) {
        items[last] = item;
        size++;
        if (last == 0) {
            last = capacity - 1;
        } else {
            last--;
        }
        return true;
    }

    @Override
    public item removeFirst() {
        if (size == 0) {
            System.out.println("It is an empty Deque");
            return null;
        } else {
            if (first == 0) {
                first = capacity - 1;
            } else {
                first = first - 1;
            }
            // resie the arraydeque half if the size is smaller than 30% of the array
            if (size <= items.length * 0.3) {
                resize(capacity / 2);
            }
            size--;
            return items[first];
        }
    }

    @Override
    public item removeLast() {
        if (size == 0) {
            System.out.println("It is an empty Deque");
            return null;
        } else {
            if (last == capacity - 1) {
                last = 0;
            } else {
                last = last + 1;
            }
            // resie the arraydeque half if the size is smaller than 30% of the array
            if (size <= items.length * 0.3) {
                resize(capacity / 2);
            }
            size--;
            return items[last];
        }
    }

    @Override
    public item pollFirst() {
        return null;
    }

    @Override
    public item pollLast() {
        return null;
    }

    @Override
    public item getFirst() {
        int first_item = 0;
        if (size == 0) {
            System.out.println("It is an empty Deque");
            return null;
        } else {
            if (first == 0) {
                first_item = capacity - 1;
            } else {
                first_item = first - 1;
            }
            return items[first_item];
        }
    }

    @Override
    public item getLast() {
        int last_item = 0;
        if (size == 0) {
            System.out.println("It is an empty Deque");
            return null;
        } else {
            if (last == capacity - 1) {
                last_item = 0;
            } else {
                last_item = last + 1;
            }
            return items[last_item];
        }
    }

    @Override
    public item peekFirst() {
        return null;
    }

    @Override
    public item peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(item item) {
        return false;
    }

    @Override
    public boolean offer(item item) {
        return false;
    }

    @Override
    public item remove() {
        return null;
    }

    @Override
    public item poll() {
        return null;
    }

    @Override
    public item element() {
        return null;
    }

    @Override
    public item peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends item> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        items = (item[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(item item) {

    }

    @Override
    public item pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<item> iterator() {
        if (size == 0) {
            return null;
        } else {
            Iterator<item> iter = new ArrayDequeIterator();
            return iter;
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<item> descendingIterator() {
        return null;
    }
}

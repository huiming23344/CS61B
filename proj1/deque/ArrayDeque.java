package deque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<item> implements Deque<item> {

    public item[] items;
    public int size;
    int first = 3;
    int last = 2;
    public int capacity = 100;

    public ArrayDeque(){
        items = (item[]) new Object[capacity];
        size = 0;
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
        System.out.println(size);
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
    }

    @Override
    // TODO:fix .offer function here
    public boolean offerFirst(item item) {
        if (size == 0) {
            return false;
        } else {
            if (first == 0) {
                item = items[capacity - 1];
                return true;
            } else {
                item = items[first - 1];
                return true;
            }
        }
    }

    @Override
    public boolean offerLast(item item) {
        if (size == 0) {
            return false;
        } else {
            if (last == capacity - 1) {
                item = items[0];
            } else {
                item =items[last + 1];
            }
            return true;
        }
    }

    @Override
    public item removeFirst() {
        return null;
    }

    @Override
    public item removeLast() {
        return null;
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
        return null;
    }

    @Override
    public item getLast() {
        return null;
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
        return null;
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

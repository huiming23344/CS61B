package deque;

import java.awt.print.Printable;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDeque<item> implements Deque, Iterable{
    public class Node {
        public item item;
        public Node next;
        public Node previous;
        public Node(item i, Node p, Node n) {
            item = i;
            previous = p;
            next = n;
        }

        public Node() {
            item = null;
            previous = null;
            next = null;
        }
    }

    private class linkedListDequeIterator implements Iterator {

        private Node cur_node = new Node();

        public linkedListDequeIterator() {
            if (size == 0) {
                System.out.println("it is an empty Deque");
            } else {
                cur_node = sentinel.next;
            }
        }
        @Override
        public boolean hasNext() {
            return cur_node != sentinel;
        }

        @Override
        public Object next() {
            cur_node = cur_node.next;
            return cur_node.previous.item;
        }
    }

    private Node sentinel;
    private int size = 0;

    public LinkedListDeque(item i){
        Node sent = new Node(i, null, null);
        sent.previous = sent;
        sent.next = sent;
        sentinel = sent;
    }

    public LinkedListDeque() {
        Node sent = new Node();
        sent.previous = sent;
        sent.next = sent;
        sentinel = sent;
    }

    public Iterator<item> Iterator() {
        Iterator<item> ans = new linkedListDequeIterator();
        return ans;
    }

    public item get(int Index) {
        if (size == 0 || Index >= size) {
            return null;
        } else {
            Iterator<item> iter = new linkedListDequeIterator();
            for (int i = 0; i < Index; i++) {
                iter.next();
            }
            return iter.next();
        }
    }

    public item getRecursive(int Index) {
        if (size == 0 || Index >= size) {
            return null;
        } else {
            return recHelper(Index, sentinel.next);
        }
    }

    private item recHelper(int Index, Node node) {
        if (Index == 0) {
            return node.item;
        } else {
            return recHelper(Index - 1, node.next);
        }
    }

    public boolean equals(LinkedListDeque o) {
        if (size != o.size()) {
            return false;
        } else {
            Iterator<item> self_iter = new linkedListDequeIterator();
            Iterator<item> o_iter = o.Iterator();
            while (o_iter.hasNext()) {
                if (self_iter.next() != o_iter.next()) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean printDeque() {
        if (size == 0) {
            System.out.println("This is a empty Deque");
            return false;
        } else {
            Node cur_node = new Node();
            cur_node = sentinel.next;
            while(cur_node != sentinel) {
                System.out.println("" + cur_node.item);
                cur_node = cur_node.next;
            }
            return true;
        }
    }

    @Override
    public void addLast(Object o) {
        Node to_add_first = new Node((item) o, sentinel.previous, sentinel);
        sentinel.previous.next = to_add_first;
        sentinel.previous = to_add_first;
        size++;
    }

    @Override
    public void addFirst(Object o) {
        Node to_add_last = new Node((item) o, sentinel, sentinel.next);
        sentinel.next.previous = to_add_last;
        sentinel.next = to_add_last;
        size++;
    }

    /**
     * .offer func should simply return false if the list is full,
     * but it won't
     * so we just do the same thing as add
     * @param o the element to add
     * @return
     */
    @Override
    public boolean offerLast(Object o) {
        Node to_add_last = new Node((item) o, sentinel, sentinel.next);
        sentinel.next.previous = to_add_last;
        sentinel.next = to_add_last;
        size++;
        return true;
    }

    @Override
    public boolean offerFirst(Object o) {
        Node to_add_last = new Node((item) o, sentinel, sentinel.next);
        sentinel.next.previous = to_add_last;
        sentinel.next = to_add_last;
        size++;
        return true;
    }

    @Override
    public Object removeFirst() {
        if(size == 0) {
            System.out.println("This is an empty Deque");
            return null;
        }
        Node cur_Node = new Node();
        cur_Node = sentinel.next;
        cur_Node.next.previous = sentinel;
        sentinel.next = cur_Node.next;
        size--;
        return cur_Node.item;
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            System.out.println("This is an empty Deque");
            return null;
        }
        Node cur_Node = new Node();
        cur_Node = sentinel.previous;
        cur_Node.previous.next = sentinel;
        sentinel.previous = cur_Node.previous;
        size--;
        return cur_Node.item;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object peekFirst() {
        return null;
    }

    @Override
    public Object peekLast() {
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
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
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
        if (size == 0) return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator descendingIterator() {
        return null;
    }
}

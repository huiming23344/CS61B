package hashmap;

import org.apache.commons.math3.geometry.partitioning.utilities.AVLTree;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private class MyHashMapKeyIterator implements Iterator<K> {

        private Iterator<Node> nodeIter = new MyHashMapNodeIterator();
        @Override
        public boolean hasNext() {
            return nodeIter.hasNext();
        }

        @Override
        public K next() {
            return nodeIter.next().key;
        }
    }
    private class MyHashMapNodeIterator implements Iterator<Node> {

        private Queue<Node> nodesQueue = new ArrayDeque<>();
        public MyHashMapNodeIterator(){
            for (Collection<Node> nodes: buckets) {
                for (Node n: nodes) {
                    nodesQueue.add(n);
                }
            }
        }
        @Override
        public boolean hasNext() {
            return !nodesQueue.isEmpty();
        }

        @Override
        public Node next() {
            return nodesQueue.remove();
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    int size = 0;
    int capacity = 16;
    double max_load_factor = 0.75;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        buckets = createTable(capacity);
    }

    public MyHashMap(int initialSize) {
        capacity = initialSize;
        buckets = createTable(capacity);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        capacity = initialSize;
        max_load_factor = maxLoad;
        buckets = createTable(capacity);
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        Node n = new Node(key, value);
        return n;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        LinkedList<Node> ans = new LinkedList<>();
        return ans;
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = createBucket();
        }
        return table;
    }
    @Override
    public void clear() {
        capacity = 16;
        buckets = createTable(capacity);
        size = 0;
    }

    /**
     * a help func to get the index in buckets
     * find the right bucket to put out node
     * @param key
     * @return index in buckets
     */
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.floorMod(hashCode, buckets.length);
    }

    /**
     * find a node by key in the HashTable
     * if the key don't exist, return null
     * @param Key
     * @return node or null
     */
    private Node getNode(K Key) {
        int index = getIndex(Key);
        for(Node n: buckets[index]) {
            if (n.key.equals(Key)) {
                return n;
            }
        }
        return null;
    }

    // TODO: implement the reSize after iterator
    private void reSize(int newCapacity) {
        Iterator<Node> nodeIterator = new MyHashMapNodeIterator();
        MyHashMap<K, V> newMap = new MyHashMap<>(newCapacity);
        while (nodeIterator.hasNext()) {
            Node n = nodeIterator.next();
            newMap.put(n.key, n.value);
        }
        buckets = newMap.buckets;
        size = newMap.size;
        capacity = newCapacity;
    }
    @Override
    public boolean containsKey(K key) {
        if (getNode(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (getNode(key) != null) {
            return getNode(key).value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (getNode(key) != null) {
            getNode(key).value = value;
        } else {
            int index = getIndex(key);
            Node n = createNode(key, value);
            buckets[index].add(n);
            size++;
        }
        if (size >= capacity * max_load_factor) {
            reSize(capacity * 2);
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> ans = new HashSet<>();
        for (Collection<Node> nodes: buckets) {
            for (Node n: nodes) {
                ans.add(n.key);
            }
        }
        return ans;
    }

    @Override
    public V remove(K key) {
        Node n = getNode(key);
        if (n != null) {
            size--;
            buckets[getIndex(key)].remove(n);
            return n.value;
        }
        return null;
    }

    @Override
    public V remove(K key, V value) {
        Node n = getNode(key);
        if (n != null && n.value == value) {
            size--;
            buckets[getIndex(key)].remove(n);
            return n.value;
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> kIterator = new MyHashMapKeyIterator();
        return kIterator;
    }

//    /**
//     * Need this func to implement .reSize func.
//     * Or you can also Overload the put and get index func,
//     * which I think reduces the readability
//     * @return buckets
//     */
//    public Collection<Node>[] getBuckets() {
//        return buckets;
//    }
}

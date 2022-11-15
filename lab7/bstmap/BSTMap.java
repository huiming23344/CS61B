package bstmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B{

    private class Node {
        private K key;
        private V value;
        // supposed to use node here
        // maybe I'll change it one day
        private BSTMap left;
        private BSTMap right;
        private int size;

        public Node(K k, V v, int s) {
            key = k;
            value = v;
            size = s;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BSTMap(){
    }
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (root == null) {
            return false;
        } else {
            int cmp = root.key.compareTo((K) key);
            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                if (root.left == null) {
                    return false;
                } else {
                    return root.left.containsKey(key);
                }
            } else if (cmp < 0) {
                if (root.right == null) {
                    return false;
                } else {
                    return root.right.containsKey(key);
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        if (root == null) {
            return null;
        } else {
            int cmp = root.key.compareTo((K) key);
            if (cmp == 0) {
                return root.value;
            } else if (cmp > 0) {
                if (root.left == null){
                    return null;
                } else {
                    return root.left.get(key);
                }
            } else if (cmp < 0) {
                if (root.right == null) {
                    return null;
                } else {
                    return root.right.get(key);
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }

    @Override
    public void put(Object key, Object value) {
        Node toBeAdd = new Node((K) key, (V) value, 0);
        BSTMap toBeAddTree = new BSTMap();
        toBeAddTree.root = toBeAdd;
        if (root == null) {
            root = toBeAdd;
            root.size++;
        } else {
            int cmp = root.key.compareTo((K)key);
            if (cmp != 0) {
                if (cmp > 0) {
                    if (root.left == null) {
                        root.left = toBeAddTree;
                    } else {
                        root.left.put(key, value);
                    }
                } else if (cmp < 0) {
                    if (root.right == null) {
                        root.right = toBeAddTree;
                    } else {
                        root.right.put(key, value);
                    }
                }
                root.size++;
            }
        }
    }

    @Override
    /**
     * don't need
     */
    public Set keySet() {
        if (root == null) {
            return null;
        } else {
            Set<K> ans = new HashSet<>();
            return ans;
        }
    }

    private void removeHelper(Node supNode, BSTMap toRemove) {

    }
    @Override
    /**
     * don't need to complete for now
     */
    public Object remove(Object key) {
//        if (root == null) {
//            return null;
//        } else {
//            int cmp = root.key.compareTo((K)key);
//            if (cmp == 0) {
//                V toReturn = root.value;
//                removeHelper(root, );
//                return toReturn;
//            }
//        }
        return null;
    }

    @Override
    /**
     * no need to implement for now
     */
    public Object remove(Object key, Object value) {
        return null;
    }

    @Override
    /**
     * don't need to complete now
     */
    public Iterator iterator() {
        return null;
    }
}

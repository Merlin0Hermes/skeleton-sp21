package bstmap;

import edu.princeton.cs.algs4.BST;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class BSTNode {
        K key;
        V value;
        BSTNode left;
        BSTNode right;

        public BSTNode() {
        }
        public BSTNode(K k, V v) {
            key = k;
            value = v;
        }
    }

    private BSTNode tree;
    private int size;

    public BSTMap() {
        tree = new BSTNode();
        int size = 0;
    }
    public BSTMap(K k, V v) {
        tree = new BSTNode(k, v);
        int size = 1;
    }

    @Override
    public void clear() {
        tree = new BSTNode();
    }

    private BSTNode find(BSTNode T, K key) {
        if (T == null) {
            return null;
        }
        if (T.key.equals(key)) {
            return T;
        }
        else if (key.compareTo(T.key) < 0) {
            return find(T.left, key);
        }
        else {
            return find(T.right, key);
        }
    }

    @Override
    public boolean containsKey(K key) {
        return find(tree, key) != null;
    }

    @Override
    public V get(K key) {
        return find(tree, key).value;
    }

    private BSTNode insert(BSTNode T, K key, V value) {
        if (T == null) {
            return new BSTNode(key, value);
        }
        if (key.compareTo(T.key) < 0) {
            T.left = insert(T.left, key, value);
        }
        else if(key.compareTo(T.key) > 0){
            T.right = insert(T.right, key, value);
        }
        return T;
    }

    @Override
    public void put(K key, V value) {
        insert(tree, key, value);
        ++size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
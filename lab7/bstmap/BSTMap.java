package bstmap;

import edu.princeton.cs.algs4.BST;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

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

    private class BSTMapIterator implements Iterator<K>{

        Stack<BSTNode> stack = new Stack<>();

        private BSTMapIterator() {
            push(tree);
        }

        private void push(BSTNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            BSTNode node = stack.pop();
            push(node.right);
            return node.key;
        }

    }

    private BSTNode tree;
    private int size;

    public BSTMap() {
        int size = 0;
    }
    public BSTMap(K k, V v) {
        tree = new BSTNode(k, v);
        int size = 1;
    }

    @Override
    public void clear() {
        tree = null;
        size = 0;
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
        BSTNode node = find(tree, key);
        if (node == null) {
            return null;
        }
        return node.value;
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
        tree = insert(tree, key, value);
        ++size;
    }

    @Override
    public int size() {
        return size;
    }

    private BSTNode delete(BSTNode T, K key) {
        if (T == null) {
            return null;
        }

        if (key.compareTo(T.key) < 0) {
            T.left = delete(T.left, key);
        }
        else if (key.compareTo(T.key) > 0) {
            T.right = delete(T.right, key);
        }
        else {
            if (T.left == null) {
                return T.right;
            }
            else if (T.right == null) {
                return T.left;
            }

            BSTNode successor = minNode(T.right);
            T.key = successor.key;
            T.value = successor.value;
            T.right = delete(T.right, T.key);
        }
        return T;
    }

    private BSTNode minNode(BSTNode T) {
        while (T.left != null) {
            T = T.left;
        }
        return T;
    }

    @Override
    public V remove(K key) {
        V val = get(key);
        if (val == null) {
            return null;
        }
        tree = delete(tree, key);
        --size;
        return val;
    }

    @Override
    public V remove(K key, V value) {
        V val = get(key);
        if (val == null) {
            return null;
        }
        if (val.equals(value)) {
            remove(key);
            --size;
        }
        return val;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new TreeSet<>();
        for (K key : this) {
            set.add(key);
        }
        return set;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }
}
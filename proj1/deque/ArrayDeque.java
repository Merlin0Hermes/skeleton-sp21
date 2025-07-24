package deque;

import java.sql.Array;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private  int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

//    private void resize(int capacity) {
//        T[] arr = (T[]) new Object[capacity];
//        System.arraycopy(items, 0, arr, 0,  nextLast);
//        System.arraycopy(items, nextFirst, arr, capacity - (size / 2),  (size - nextFirst));
//
//        items = arr;
//    }

    public void addLast(T item) {
//        double RFACTOR = 2;
//        if (size == items.length) {
//            resize((int) Math.ceil(size * RFACTOR));
//            nextFirst = nextFirst + size;
//        }
        items[nextLast] = item;
        ++size;
        ++nextLast;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    public T getLast() {
        return items[lastIndex()];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    private int lastIndex() {
        if ((nextLast - 1) < 0) {
            return items.length - 1;
        }
        return nextLast - 1;
    }

    public T removeLast() {
        T item = getLast();
        items[lastIndex()] = null;
        --size;
        return item;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int it;
        for (int i = 0; i < 100000; ++i) {
            list.addLast(i);
            it = list.getLast();
        }
    }
}
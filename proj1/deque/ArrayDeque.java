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
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T item = getLast();
        items[size - 1] = null;
        --size;
        return item;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < 100000; ++i) {
            list.addLast(i);
        }
    }
}
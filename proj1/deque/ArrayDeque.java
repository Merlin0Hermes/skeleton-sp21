package deque;

import java.sql.Array;

public class ArrayDeque<T> {
    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[1];
        size = 0;
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, arr, 0, size);
        items = arr;
    }

    public void addLast(T item) {
        double RFACTOR = 0.25;
        if (size == items.length) {
            resize(size + (int) Math.ceil(size * RFACTOR));
        }
        items[size++] = item;
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
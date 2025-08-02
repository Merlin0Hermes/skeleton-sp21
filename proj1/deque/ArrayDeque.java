package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements  Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private  int nextLast;

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;
        private int index;

        public ArrayDequeIterator() {
            pos = firstIndex();
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (pos == items.length) {
                pos = 0;
            }
            ++index;
            return items[pos++];
        }
    }

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        int j = capacity / 4;

        for (T item : this) {
            arr[j++] = item;
        }

        nextFirst = (capacity / 4) - 1;
        nextLast = j;
        items = arr;
    }

    private void increaseCapacity() {
        double RFACTOR = 2;
        resize((int) Math.ceil(size * RFACTOR));
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            increaseCapacity();
        }
        items[nextLast] = item;
        ++size;
        ++nextLast;

        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    @Override
    public T getLast() {
        return items[lastIndex()];
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            increaseCapacity();
        }

        items[nextFirst] = item;
        ++size;
        --nextFirst;

        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    @Override
    public T getFirst() {
        return items[firstIndex()];
    }

    @Override
    public T get(int index) {
        for (T item : this) {
            if (index == 0) {
                return item;
            }
            --index;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int lastIndex() {
        if ((nextLast - 1) < 0) {
            return items.length - 1;
        }
        return nextLast - 1;
    }

    private int firstIndex() {
        if ((nextFirst + 1) >= items.length) {
            return 0;
        }
        return nextFirst + 1;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;

        T item = getLast();
        items[lastIndex()] = null;
        nextLast = lastIndex();
        --size;
        return item;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;

        T item = getFirst();
        items[firstIndex()] = null;
        nextFirst = firstIndex();
        --size;
        return item;
    }

    @Override
    public void printDeque() {
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof Deque<?> deque)) {
            return false;
        }
        if (this.size != deque.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); ++i) {
            if (! this.get(i).equals(deque.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
}
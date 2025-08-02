package deque;

public class ArrayDeque<T> implements  Deque<T> {
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

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        int j = capacity / 4;
        nextFirst = j - 1;

        for (int i = 0; i < size(); ++i) {
            arr[j] = items[i];
            ++j;
        }

        nextLast = j;
        items = arr;
    }

    private void increaseCapacity() {
        double RFACTOR = 2;
        resize((int) Math.ceil(size * RFACTOR));
    }

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

    public T getLast() {
        return items[lastIndex()];
    }

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

    public T getFirst() {
        return items[firstIndex()];
    }

    public T get(int index) {
        if (index < 0 || index > this.size()) {
            return null;
        }
        int i = firstIndex();
        while (index > 0) {
            if (i == items.length) {
                i = 0;
            }
            if (i == nextLast) {
                return null;
            }
            ++i;
            --index;
        }
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

    private int firstIndex() {
        if ((nextFirst + 1) >= items.length) {
            return 0;
        }
        return nextFirst + 1;
    }

    public T removeLast() {
        if (isEmpty()) return null;

        T item = getLast();
        items[lastIndex()] = null;
        nextLast = lastIndex();
        --size;
        return item;
    }

    public T removeFirst() {
        if (isEmpty()) return null;

        T item = getFirst();
        items[firstIndex()] = null;
        nextFirst = firstIndex();
        --size;
        return item;
    }

    public void printDeque() {
        for (int i = 0; i < size(); ++i) {
            T item = get(i);
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int it;
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) list.addLast(i);
            else list.addFirst(i);
        }

        list.printDeque();
    }
}
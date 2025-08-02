package deque;

public class LinkedListDeque<T> implements  Deque<T> {

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }

        public Node(Node<T> p, Node<T> n) {
            prev = p;
            next = n;
        }

        public Node() {
        }
    }

    /** first item in list is at sentinel.next (if it exists) */
    Node<T> sentinel;
    int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<T>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(T item) {
        size = 1;
        sentinel = new Node<T>();
        Node<T> node = new Node<T>(item, sentinel, sentinel);

        sentinel.next = node;
        sentinel.prev = node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next = node;
        node.next.prev = node;
        ++size;
    }

    public void addLast(T item) {
        Node<T> node = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        ++size;
    }

    public void printDeque() {
        Node<T> p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (item != null) --size;
        return item;
    }

    public T removeLast() {
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        if (item != null) --size;
        return item;
    }

    public T get(int index) {
        Node<T> p = sentinel.next;
        while (index != 0 && p != sentinel) {
            p = p.next;
            --index;
        }
        return p.item;
    }
}
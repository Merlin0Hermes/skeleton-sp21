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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next = node;
        node.next.prev = node;
        ++size;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        ++size;
    }

    @Override
    public void printDeque() {
        Node<T> p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (item != null) --size;
        return item;
    }

    @Override
    public T removeLast() {
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        if (item != null) --size;
        return item;
    }

    @Override
    public T get(int index) {
        Node<T> p = sentinel.next;
        while (index != 0 && p != sentinel) {
            p = p.next;
            --index;
        }
        return p.item;
    }

    @Override
    public T getLast() {
        return sentinel.prev.item;
    }

    @Override
    public T getFirst() {
        return sentinel.next.item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof LinkedListDeque<?> list)) {
            return false;
        }
        if (this.size != list.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); ++i) {
            if (! this.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
package deque;

import java.util.Iterator;

public interface Deque<T> {

    /** add item to front of deque. */
    public void addFirst(T item);

    /** add item to back of deque */
    public void addLast(T item);

    /** return true if deque is empty. */
    public boolean isEmpty();

    /** returns the current size (number of items in deque) */
    public int size();

    /** prints the deque */
    public void printDeque();

    /** remove and return the first item */
    public T removeFirst();

    /** remove and return the last items */
    public T removeLast();

    /** get the item at index, returns null if item not found
     * or if index is invalid.
     */
    public T get(int index);

    /** get the first item without removing it. */
    public T getFirst();

    /** get the last item without removing it. */
    public T getLast();

    /** returns true if deque is equal to o.
     * That is, if o is same size as o
     * and o contains same items as deque
     * in the same order.
     */
    public boolean equals(Object o);

    /** iterator method */
    public Iterator<T> iterator();
}

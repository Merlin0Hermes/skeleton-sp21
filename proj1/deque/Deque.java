package deque;

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
}

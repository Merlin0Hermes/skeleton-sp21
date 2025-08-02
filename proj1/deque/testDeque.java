package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeque {

    @Test
    public void testEquals() {
        Deque<Integer> list = new LinkedListDeque<>();
        Deque<Integer> arr = new ArrayDeque<>();

        list.addLast(10);
        arr.addLast(10);
        assertEquals(list, arr);

        list.addFirst(5);
        assertNotEquals(list, arr);

        arr.addFirst(5);
        assertEquals(list, arr);

        for (int i = 0; i < 1000; ++i) {
            arr.addLast(i);
            list.addLast(i);
        }
        for (int i = 0; i < 1000; ++i) {
            list.addFirst(i);
            arr.addFirst(i);
        }
        assertEquals(list, arr);
    }
}

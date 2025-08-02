package deque;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque {
    private ArrayDeque<Integer> deque;

    @Before
    public void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test
    public void testAddFirst() {
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        deque.addFirst(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void testAddLast() {
        deque.addLast(1);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        deque.addFirst(1);
        assertEquals(1, deque.size());
        deque.addLast(2);
        assertEquals(2, deque.size());
        deque.removeFirst();
        assertEquals(1, deque.size());
        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    public void testPrintDeque() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(4);
        deque.addFirst(8);
        deque.addLast(10);
        deque.printDeque(); // output should be: 8 2 1 4 10
    }

    @Test
    public void testRemoveFirst() {
        assertNull(deque.removeFirst()); // Should return null for empty deque
        deque.addFirst(1);
        assertEquals(Integer.valueOf(1), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        assertNull(deque.removeLast()); // Should return null for empty deque
        deque.addLast(1);
        assertEquals(Integer.valueOf(1), deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testMultipleOperations() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
        assertEquals(Integer.valueOf(3), deque.removeFirst());
        assertEquals(Integer.valueOf(2), deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(Integer.valueOf(1), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testGet() {
        deque.addFirst(1); // index 0
        assertEquals(Integer.valueOf(1), deque.get(0));
        deque.addLast(-1);
        deque.addLast(10);
        deque.addLast(-107); // index 3
        assertEquals(Integer.valueOf(-107), deque.get(3));
        deque.removeLast();
        assertEquals(Integer.valueOf(10), deque.get(2));
        assertNull(deque.get(3));
        assertNull(deque.get(5));
        assertNull(deque.get(-1));

    }

    @Test
    public void iterationTest() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for (int i = 0; i < 16; ++i) {
            arr.addLast(i);
        }
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}


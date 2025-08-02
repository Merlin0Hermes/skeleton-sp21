package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;


public class TestMaxArrayDeque {
    private static class CompareInt implements Comparator<Integer> {

        @Override
        public int compare(Integer i, Integer j) {
            return i - j;
        }
    }

    private static class CompareString implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    @Test
    public void testMax() {
        MaxArrayDeque<Integer> marr = new MaxArrayDeque<>(new CompareInt());
        marr.addFirst(2);
        marr.addLast(-1);
        marr.addLast(5);

        assertEquals(5, (int) marr.max());

        marr.addFirst(10);
        marr.addLast(10);
        assertEquals(10, (int) marr.max());
        assertEquals(10, (int) marr.max(new CompareInt()));
    }

    @Test
    public void testMaxComp() {
        MaxArrayDeque<String> marr = new MaxArrayDeque<>(new CompareString());
        marr.addFirst("what");
        marr.addLast("reading");
        marr.addLast("wheeee");

        assertEquals("reading", marr.max());
        assertEquals("reading", marr.max(new CompareString()));
    }
}

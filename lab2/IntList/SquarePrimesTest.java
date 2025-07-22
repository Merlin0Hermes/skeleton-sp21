package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesNoChange() {
        IntList lst = IntList.of(1, 10, 20);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 10 -> 20", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSqurePrimesComples() {
        IntList lst = IntList.of(5, 6, 7, 10, 11, 12, 13, 19, 27, 37);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("25 -> 6 -> 49 -> 10 -> 121 -> 12 -> 169 -> 361 -> 27 -> 1369", lst.toString());
        assertTrue(changed);
    }
}

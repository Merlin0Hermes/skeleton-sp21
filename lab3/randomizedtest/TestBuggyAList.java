package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> list = new AListNoResizing<>();
        BuggyAList<Integer> list2 = new BuggyAList<>();

        list.addLast(3);
        list2.addLast(3);

        list.addLast(4);
        list2.addLast(4);

        list.addLast(5);
        list2.addLast(5);

        assertEquals(list.removeLast(), list2.removeLast());
        assertEquals(list.removeLast(), list2.removeLast());
        assertEquals(list.removeLast(), list2.removeLast());

    }
}

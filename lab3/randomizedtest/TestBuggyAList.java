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

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                System.out.println("L size: " + L.size());
                System.out.println("BL size: " + BL.size());
                assertEquals(L.size(), BL.size());
            }
            else if (operationNumber == 2 && L.size() > 0) {
                System.out.println("getLast(" + L.getLast() + ")");
                assertEquals(L.getLast(), BL.getLast());
            }
            else if (operationNumber == 3 && L.size() > 0) {
                System.out.println("removeLast(" + L.getLast() + ")");
                assertEquals(L.removeLast(), BL.removeLast());
            }
        }
    }
}

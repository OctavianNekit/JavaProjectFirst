import JavaClass.BinarryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void Test1() {
        BinarryTree bt = new BinarryTree(7);

        bt.add(8);
        bt.add(5);
        bt.add(3);
        bt.add(10);
        bt.add(3);

        assertTrue(bt.find(8));
        assertFalse(bt.find(8 + 5 + 3 + 10 + 3));
    }

    @Test
    void Test2() {
        BinarryTree bt = new BinarryTree(10);

        bt.add(9);
        bt.add(4);
        bt.add(2);
        bt.add(5);
        bt.add(8);

        assertTrue(bt.find(9));
        assertFalse(bt.find(9 + 4 + 2 + 5 + 8));
    }

    @Test
    void DeleteTest() {
        BinarryTree bt = new BinarryTree(1);

        bt.add(10);
        bt.add(5);
        bt.add(12);
        bt.add(6);
        bt.add(3);
        bt.add(2);

        assertTrue(bt.find(10));
        bt.delete(10);
        assertFalse(bt.find(10));
    }

    @Test
    void DeleteTest2() {
        BinarryTree bt = new BinarryTree(5);

        bt.add(1);
        bt.add(2);
        bt.add(7);
        bt.add(6);
        bt.add(4);

        assertTrue(bt.find(1));
        bt.delete(1);
        assertFalse(bt.find(1));
    }

    @Test
    void FriendTest1() throws Exception {
        BinarryTree bt = new BinarryTree(9);

        bt.add(3);
        bt.add(6);
        bt.add(1);

        BinarryTree[] m = bt.nearby(3);
        assertEquals(m[0].getValue(), 9);
        assertEquals(m[1].getValue(), 6);
        assertEquals(m[2].getValue(), 1);
    }
}
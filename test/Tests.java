import static org.junit.jupiter.api.Assertions.*;

import JavaClass.BinarryTree;
import org.junit.jupiter.api.Test;


class Tests {
    @Test
    void Test1() {
        BinarryTree bt = new BinarryTree(2);
        bt.add(4);
        bt.add(5);
        bt.add(8);
        bt.add(1);
        bt.add(10);
        assertTrue(bt.find(4));
        assertFalse(bt.find(30));
    }

    @Test
    void Test2() {
        BinarryTree bt = new BinarryTree(6);
        bt.add(5);
        bt.add(4);
        bt.add(1);
        bt.add(8);
        bt.add(10);
        bt.add(15);
        assertTrue(bt.find(8));
        assertFalse(bt.find(20));
    }

    @Test
    void DeleteTest1() {
        BinarryTree bt = new BinarryTree(10);
        bt.add(5);
        bt.add(8);
        bt.add(15);
        bt.add(3);
        bt.add(1);
        assertTrue(bt.find(15));
        bt.delete(15);
        assertFalse(bt.find(15));
    }

    @Test
    void  DeleteTest2() {
        BinarryTree bt = new BinarryTree(5);
        bt.add(9);
        bt.add(4);
        bt.add(2);
        bt.add(7);
        bt.add(8);
        bt.add(17);
        assertTrue(bt.find(2));
        bt.delete(2);
        assertFalse(bt.find(2));
    }

    @Test
    void NearbyTest1() throws Exception {
        BinarryTree bt = new BinarryTree(5);
        bt.add(7);
        bt.add(4);
        bt.add(6);
        bt.add(8);
        bt.add(3);
        bt.add(1);
        BinarryTree.Node[] n = bt.nearby(7);
        assertEquals(n[0].getValue(), 5);
        assertEquals(n[1].getValue(), 8);
        assertEquals(n[2].getValue(), 6);
    }

    @Test
    void NearbyTest2() throws Exception {
        BinarryTree bt = new BinarryTree(10);
        bt.add(15);
        bt.add(8);
        bt.add(5);
        BinarryTree.Node[] n = bt.nearby(15);
        assertEquals(n[0].getValue(), 10);
        assertNull(n[1]);
        assertNull(n[2]);
    }

    @Test
    void NearbyTest3() throws Exception {
        BinarryTree bt = new BinarryTree(1);
        bt.add(2);
        bt.add(0);
        BinarryTree.Node[] n = bt.nearby(1);
        assertNull(n[0]);
        assertEquals(n[1].getValue(), 2);
        assertEquals(n[2].getValue(), 0);
        assertThrows(Exception.class, () -> bt.nearby(10));
    }
}
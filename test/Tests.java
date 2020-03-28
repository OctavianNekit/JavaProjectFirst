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
}
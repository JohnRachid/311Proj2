import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestComputerNode {

    private ComputerNode node;

    @Before
    public void initNode() {
        this.node = new ComputerNode(0,0);
    }

    @Test
    public void testID() {
        node.setId(10);
        assertNotEquals("ID should not be 0 after call to setID(10)", 0, node.getID());
        assertEquals("ID should be 10 after call to setID(10)", 10, node.getID());
    }

    @Test
    public void testTimestamp() {
        node.setTimestamp(10);
        assertNotEquals("Timestamp should not be 0 after call to setTimestamp(10)", 0, node.getTimestamp());
        assertEquals("Timestamp should be 10 after call to setTimestamp(10)", 10, node.getTimestamp());
    }

    @Test
    public void testNeighbors1() {
        ComputerNode node2 = new ComputerNode(11, 3);
        node.addNeighbor(node2);
        assertTrue("node1 should have node2 as a neighbor", node.getOutNeighbors().contains(node2));

        LinkedList<ComputerNode> testList = new LinkedList<>();
        testList.add(node2);
        assertTrue("node2 should be the only node in the neighbor list", testList.equals(node.getOutNeighbors()));
    }
}

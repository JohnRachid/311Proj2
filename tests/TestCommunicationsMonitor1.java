import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestCommunicationsMonitor1 {

    private CommunicationsMonitor monitor;

    @Before
    public void initTestCase() {
        monitor = new CommunicationsMonitor();
        monitor.addCommunication(1, 4, 12); // done out of order to ensure sorting works
        monitor.addCommunication(1, 2, 4);
        monitor.addCommunication(2, 4, 8);
        monitor.addCommunication(3, 4, 8);
        monitor.createGraph();
    }

    @Test
    public void testNodeMappingsRunner() {
        LinkedList<ComputerNode> expectedNodes = new LinkedList<>();

        // Node 1
        expectedNodes.add(new ComputerNode(1, 4));
        expectedNodes.add(new ComputerNode(1, 12));
        TestUtils.testNodeMappings(monitor, 1, expectedNodes);
        expectedNodes.clear();

        // Node 2
        expectedNodes.add(new ComputerNode(2, 4));
        expectedNodes.add(new ComputerNode(2, 8));
        TestUtils.testNodeMappings(monitor, 2, expectedNodes);
        expectedNodes.clear();

        // Node 3
        expectedNodes.add(new ComputerNode(3, 8));
        TestUtils.testNodeMappings(monitor, 3, expectedNodes);
        expectedNodes.clear();

        // Node 4
        expectedNodes.add(new ComputerNode(4, 8));
        expectedNodes.add(new ComputerNode(4, 12));
        TestUtils.testNodeMappings(monitor, 4, expectedNodes);
        expectedNodes.clear();
    }

    @Test
    public void testNodeNeighborsRunner() {
        LinkedList<ComputerNode> expectedNeighbors = new LinkedList<>();

        // Node (1, 4)
        expectedNeighbors.add(new ComputerNode(2, 4));
        expectedNeighbors.add(new ComputerNode(1, 12));
        TestUtils.testNodeNeighbors(monitor, 1, 4, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (1, 12)
        expectedNeighbors.add(new ComputerNode(4, 12));
        TestUtils.testNodeNeighbors(monitor, 1, 12, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 4)
        expectedNeighbors.add(new ComputerNode(1, 4));
        expectedNeighbors.add(new ComputerNode(2, 8));
        TestUtils.testNodeNeighbors(monitor, 2, 4, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 8)
        expectedNeighbors.add(new ComputerNode(4, 8));
        TestUtils.testNodeNeighbors(monitor, 2, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 8)
        expectedNeighbors.add(new ComputerNode(4, 8));
        TestUtils.testNodeNeighbors(monitor, 3, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 8)
        expectedNeighbors.add(new ComputerNode(2, 8));
        expectedNeighbors.add(new ComputerNode(3, 8));
        expectedNeighbors.add(new ComputerNode(4, 12));
        TestUtils.testNodeNeighbors(monitor, 4, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 12)
        expectedNeighbors.add(new ComputerNode(1, 12));
        TestUtils.testNodeNeighbors(monitor, 4, 12, expectedNeighbors);
        expectedNeighbors.clear();
    }

    @Test
    public void testComputerMapping() {
        HashMap<Integer, List<ComputerNode>> computerMapping = monitor.getComputerMapping();

        Set<Integer> keys = computerMapping.keySet();
        HashSet<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        assertEquals("Wrong keys in HashMap", expected, keys);
    }

    @Test
    public void testQuery1() {
        List<ComputerNode> result = monitor.queryInfection(1, 3, 2, 8);
        assertNotNull("Result should not be null. An infection path exists when 1 is infected at t=2 and 3 by t=8", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(1, 4));
        expected.add(new ComputerNode(2, 4));
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(4, 8));
        expected.add(new ComputerNode(3, 8));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery2() {
        List<ComputerNode> result = monitor.queryInfection(1, 3, 2, 4);
        assertNull("Result should be null. An infection path does not exist when 1 is infected at t=2 and 3 by t=4", result);
    }

    @Test
    public void testQuery3() {
        List<ComputerNode> result = monitor.queryInfection(3, 1, 8, 12);

        System.out.println(result);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=12", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(3, 8));
        expected.add(new ComputerNode(4, 8));
        expected.add(new ComputerNode(4, 12));
        expected.add(new ComputerNode(1, 12));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery4() {
        List<ComputerNode> result = monitor.queryInfection(3, 1, 8, 5);
        assertNull("Result should not be null. t1 is greater than t2", result);
    }

    @Test
    public void testQuery5() {
        List<ComputerNode> result = monitor.queryInfection(2, 4, 8, 8);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=12", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(4, 8));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery6() {
        List<ComputerNode> result = monitor.queryInfection(2, 3, 8, 8);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=12", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(4, 8));
        expected.add(new ComputerNode(3, 8));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery7() {
        List<ComputerNode> result = monitor.queryInfection(2, 3, 4, 8);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=12", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(2, 4));
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(4, 8));
        expected.add(new ComputerNode(3, 8));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }
}

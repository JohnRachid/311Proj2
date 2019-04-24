import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestCommunicationsMonitor2 {

    private CommunicationsMonitor monitor;

    @Before
    public void initTestCase() {
        monitor = new CommunicationsMonitor();
        monitor.addCommunication(2, 3, 8);
        monitor.addCommunication(1, 4, 12);
        monitor.addCommunication(1, 2, 14);
        monitor.createGraph();
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
    public void testNodeMappingsRunner() {
        LinkedList<ComputerNode> expectedNodes = new LinkedList<>();

        // Node 1
        expectedNodes.add(new ComputerNode(1, 12));
        expectedNodes.add(new ComputerNode(1, 14));
        TestUtils.testNodeMappings(monitor, 1, expectedNodes);
        expectedNodes.clear();

        // Node 2
        expectedNodes.add(new ComputerNode(2, 8));
        expectedNodes.add(new ComputerNode(2, 14));
        TestUtils.testNodeMappings(monitor, 2, expectedNodes);
        expectedNodes.clear();

        // Node 3
        expectedNodes.add(new ComputerNode(3, 8));
        TestUtils.testNodeMappings(monitor, 3, expectedNodes);
        expectedNodes.clear();

        // Node 4
        expectedNodes.add(new ComputerNode(4, 12));
        TestUtils.testNodeMappings(monitor, 4, expectedNodes);
        expectedNodes.clear();
    }

    @Test
    public void testNodeNeighborsRunner() {
        LinkedList<ComputerNode> expectedNeighbors = new LinkedList<>();

        // Node (1, 12)
        expectedNeighbors.add(new ComputerNode(1, 14));
        expectedNeighbors.add(new ComputerNode(4, 12));
        TestUtils.testNodeNeighbors(monitor, 1, 12, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (1, 14)
        expectedNeighbors.add(new ComputerNode(2, 14));
        TestUtils.testNodeNeighbors(monitor, 1, 14, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 8)
        expectedNeighbors.add(new ComputerNode(3, 8));
        expectedNeighbors.add(new ComputerNode(2, 14));
        TestUtils.testNodeNeighbors(monitor, 2, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 14)
        expectedNeighbors.add(new ComputerNode(1, 14));
        TestUtils.testNodeNeighbors(monitor, 2, 14, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 8)
        expectedNeighbors.add(new ComputerNode(2, 8));
        TestUtils.testNodeNeighbors(monitor, 3, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 12)
        expectedNeighbors.add(new ComputerNode(1, 12));
        TestUtils.testNodeNeighbors(monitor, 4, 12, expectedNeighbors);
        expectedNeighbors.clear();
    }

    @Test
    public void testQuery1() {
        List<ComputerNode> result = monitor.queryInfection(1, 3, 2, 14);
        assertNull("Result should be null. An infection path Does not exist between 1 and 3", result);
    }

    @Test
    public void testQuery2() {
        List<ComputerNode> result = monitor.queryInfection(2, 1, 8, 14);
        assertNotNull("Result should not be null. An infection path exists when 2 is infected at t=8 and 1 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(2, 14));
        expected.add(new ComputerNode(1, 14));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery3() {
        List<ComputerNode> result = monitor.queryInfection(2, 1, 8, 15);
        assertNotNull("Result should not be null. An infection path exists when 2 is infected at t=8 and 1 by t=15", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(2, 14));
        expected.add(new ComputerNode(1, 14));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery4() {
        List<ComputerNode> result = monitor.queryInfection(3, 1, 8, 14);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(3, 8));
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(2, 14));
        expected.add(new ComputerNode(1, 14));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery5() {
        List<ComputerNode> result = monitor.queryInfection(3, 2, 8, 14);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 2 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(3, 8));
        expected.add(new ComputerNode(2, 8));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery6() {
        List<ComputerNode> result = monitor.queryInfection(3, 1, 8, 14);
        assertNotNull("Result should not be null. An infection path exists when 3 is infected at t=8 and 1 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(3, 8));
        expected.add(new ComputerNode(2, 8));
        expected.add(new ComputerNode(2, 14));
        expected.add(new ComputerNode(1, 14));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery7() {
        List<ComputerNode> result = monitor.queryInfection(4, 2, 12, 14);
        assertNotNull("Result should not be null. An infection path exists when 4 is infected at t=12 and 2 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(4, 12));
        expected.add(new ComputerNode(1, 12));
        expected.add(new ComputerNode(1, 14));
        expected.add(new ComputerNode(2, 14));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery8() {
        List<ComputerNode> result = monitor.queryInfection(4, 4, 12, 14);
        assertNotNull("Result should not be null. An infection path exists when 4 is infected at t=12 and 4 by t=14", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(4, 12));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }
}

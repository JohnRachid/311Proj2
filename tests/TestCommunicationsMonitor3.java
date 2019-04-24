import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.*;

public class TestCommunicationsMonitor3 {

    private CommunicationsMonitor monitor;

    @Before
    public void initTestCase() {
        monitor = new CommunicationsMonitor();

        File file = new File("combos.csv");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(",");
                monitor.addCommunication(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        monitor.createGraph();
    }

    @Test
    public void testNodeMappingsRunner() {
        LinkedList<ComputerNode> expectedNodes = new LinkedList<>();

        // Node 1
        expectedNodes.add(new ComputerNode(1, 5));
        expectedNodes.add(new ComputerNode(1, 43));
        expectedNodes.add(new ComputerNode(1, 23));
        TestUtils.testNodeMappings(monitor, 1, expectedNodes);
        expectedNodes.clear();

        // Node 2
        expectedNodes.add(new ComputerNode(2, 24));
        expectedNodes.add(new ComputerNode(2, 32));
        expectedNodes.add(new ComputerNode(2, 14));
        expectedNodes.add(new ComputerNode(2, 1));
        TestUtils.testNodeMappings(monitor, 2, expectedNodes);
        expectedNodes.clear();

        // Node 3
        expectedNodes.add(new ComputerNode(3, 2));
        expectedNodes.add(new ComputerNode(3, 35));
        expectedNodes.add(new ComputerNode(3, 8));
        expectedNodes.add(new ComputerNode(3, 34));
        expectedNodes.add(new ComputerNode(3, 37));
        expectedNodes.add(new ComputerNode(3, 39));
        expectedNodes.add(new ComputerNode(3, 7));
        TestUtils.testNodeMappings(monitor, 3, expectedNodes);
        expectedNodes.clear();

        // Node 4
        expectedNodes.add(new ComputerNode(4, 23));
        expectedNodes.add(new ComputerNode(4, 2));
        expectedNodes.add(new ComputerNode(4, 1));
        expectedNodes.add(new ComputerNode(4, 11));
        expectedNodes.add(new ComputerNode(4, 34));
        TestUtils.testNodeMappings(monitor, 4, expectedNodes);
        expectedNodes.clear();

        // Node 5
        expectedNodes.add(new ComputerNode(5, 2));
        expectedNodes.add(new ComputerNode(5, 5));
        expectedNodes.add(new ComputerNode(5, 12));
        expectedNodes.add(new ComputerNode(5, 42));
        TestUtils.testNodeMappings(monitor, 5, expectedNodes);
        expectedNodes.clear();

        // Node 6
        expectedNodes.add(new ComputerNode(6, 11));
        expectedNodes.add(new ComputerNode(6, 37));
        TestUtils.testNodeMappings(monitor, 6, expectedNodes);
        expectedNodes.clear();

        // Node 7
        expectedNodes.add(new ComputerNode(7, 6));
        expectedNodes.add(new ComputerNode(7, 7));
        expectedNodes.add(new ComputerNode(7, 35));
        expectedNodes.add(new ComputerNode(7, 11));
        expectedNodes.add(new ComputerNode(7, 2));
        TestUtils.testNodeMappings(monitor, 7, expectedNodes);
        expectedNodes.clear();

        // Node 8
        expectedNodes.add(new ComputerNode(8, 32));
        expectedNodes.add(new ComputerNode(8, 8));
        TestUtils.testNodeMappings(monitor, 8, expectedNodes);
        expectedNodes.clear();

        // Node 9
        expectedNodes.add(new ComputerNode(9, 12));
        expectedNodes.add(new ComputerNode(9, 24));
        expectedNodes.add(new ComputerNode(9, 23));
        TestUtils.testNodeMappings(monitor, 9, expectedNodes);
        expectedNodes.clear();

        // Node 10
        expectedNodes.add(new ComputerNode(10, 14));
        expectedNodes.add(new ComputerNode(10, 23));
        expectedNodes.add(new ComputerNode(10, 20));
        expectedNodes.add(new ComputerNode(10, 6));
        expectedNodes.add(new ComputerNode(10, 36));
        expectedNodes.add(new ComputerNode(10, 2));
        TestUtils.testNodeMappings(monitor, 10, expectedNodes);
        expectedNodes.clear();

        // Node 11
        expectedNodes.add(new ComputerNode(11, 35));
        expectedNodes.add(new ComputerNode(11, 5));
        expectedNodes.add(new ComputerNode(11, 34));
        TestUtils.testNodeMappings(monitor, 11, expectedNodes);
        expectedNodes.clear();

        // Node 12
        expectedNodes.add(new ComputerNode(12, 42));
        expectedNodes.add(new ComputerNode(12, 39));
        TestUtils.testNodeMappings(monitor, 12, expectedNodes);
        expectedNodes.clear();

        // Node 13
        expectedNodes.add(new ComputerNode(13, 43));
        expectedNodes.add(new ComputerNode(13, 20));
        TestUtils.testNodeMappings(monitor, 13, expectedNodes);
        expectedNodes.clear();

        // Node 14
        expectedNodes.add(new ComputerNode(14, 34));
        expectedNodes.add(new ComputerNode(14, 36));
        expectedNodes.add(new ComputerNode(14, 35));
        TestUtils.testNodeMappings(monitor, 14, expectedNodes);
        expectedNodes.clear();
    }

    @Test
    public void testNodeNeighborsRunner() {
        LinkedList<ComputerNode> expectedNeighbors = new LinkedList<>();

        // Node (4, 1)
        expectedNeighbors.add(new ComputerNode(2, 1));
        expectedNeighbors.add(new ComputerNode(4, 2));
        TestUtils.testNodeNeighbors(monitor, 4, 1, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 1)
        expectedNeighbors.add(new ComputerNode(4, 1));
        expectedNeighbors.add(new ComputerNode(2, 14));
        TestUtils.testNodeNeighbors(monitor, 2, 1, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 2)
        expectedNeighbors.add(new ComputerNode(5, 2));
        expectedNeighbors.add(new ComputerNode(3, 7));
        TestUtils.testNodeNeighbors(monitor, 3, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 2)
        expectedNeighbors.add(new ComputerNode(10, 2));
        expectedNeighbors.add(new ComputerNode(5, 2));
        expectedNeighbors.add(new ComputerNode(4, 11));
        TestUtils.testNodeNeighbors(monitor, 4, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (5, 2)
        expectedNeighbors.add(new ComputerNode(3, 2));
        expectedNeighbors.add(new ComputerNode(7, 2));
        expectedNeighbors.add(new ComputerNode(4, 2));
        expectedNeighbors.add(new ComputerNode(5, 5));
        TestUtils.testNodeNeighbors(monitor, 5, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 2)
        expectedNeighbors.add(new ComputerNode(5, 2));
        expectedNeighbors.add(new ComputerNode(7, 6));
        TestUtils.testNodeNeighbors(monitor, 7, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 2)
        expectedNeighbors.add(new ComputerNode(5, 2));
        expectedNeighbors.add(new ComputerNode(7, 6));
        TestUtils.testNodeNeighbors(monitor, 7, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 2)
        expectedNeighbors.add(new ComputerNode(4, 2));
        expectedNeighbors.add(new ComputerNode(10, 6));
        TestUtils.testNodeNeighbors(monitor, 10, 2, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (1, 5)
        expectedNeighbors.add(new ComputerNode(5, 5));
        expectedNeighbors.add(new ComputerNode(1, 23));
        TestUtils.testNodeNeighbors(monitor, 1, 5, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (5, 5)
        expectedNeighbors.add(new ComputerNode(1, 5));
        expectedNeighbors.add(new ComputerNode(11, 5));
        expectedNeighbors.add(new ComputerNode(5, 12));
        TestUtils.testNodeNeighbors(monitor, 5, 5, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (11, 5)
        expectedNeighbors.add(new ComputerNode(5, 5));
        expectedNeighbors.add(new ComputerNode(11, 34));
        TestUtils.testNodeNeighbors(monitor, 11, 5, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 6)
        expectedNeighbors.add(new ComputerNode(10, 6));
        expectedNeighbors.add(new ComputerNode(7, 7));
        TestUtils.testNodeNeighbors(monitor, 7, 6, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 6)
        expectedNeighbors.add(new ComputerNode(7, 6));
        expectedNeighbors.add(new ComputerNode(10, 14));
        TestUtils.testNodeNeighbors(monitor, 10, 6, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 7)
        expectedNeighbors.add(new ComputerNode(7, 7));
        expectedNeighbors.add(new ComputerNode(3, 8));
        TestUtils.testNodeNeighbors(monitor, 3, 7, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 7)
        expectedNeighbors.add(new ComputerNode(3, 7));
        expectedNeighbors.add(new ComputerNode(7, 11));
        TestUtils.testNodeNeighbors(monitor, 7, 7, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 8)
        expectedNeighbors.add(new ComputerNode(8, 8));
        expectedNeighbors.add(new ComputerNode(3, 34));
        TestUtils.testNodeNeighbors(monitor, 3, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (8, 8)
        expectedNeighbors.add(new ComputerNode(3, 8));
        expectedNeighbors.add(new ComputerNode(8, 32));
        TestUtils.testNodeNeighbors(monitor, 8, 8, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 11)
        expectedNeighbors.add(new ComputerNode(7, 11));
        expectedNeighbors.add(new ComputerNode(6, 11));
        expectedNeighbors.add(new ComputerNode(4, 23));
        TestUtils.testNodeNeighbors(monitor, 4, 11, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (6, 11)
        expectedNeighbors.add(new ComputerNode(4, 11));
        expectedNeighbors.add(new ComputerNode(6, 37));
        TestUtils.testNodeNeighbors(monitor, 6, 11, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 11)
        expectedNeighbors.add(new ComputerNode(4, 11));
        expectedNeighbors.add(new ComputerNode(7, 35));
        TestUtils.testNodeNeighbors(monitor, 7, 11, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (5, 12)
        expectedNeighbors.add(new ComputerNode(9, 12));
        expectedNeighbors.add(new ComputerNode(5, 42));
        TestUtils.testNodeNeighbors(monitor, 5, 12, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (9, 12)
        expectedNeighbors.add(new ComputerNode(5, 12));
        expectedNeighbors.add(new ComputerNode(9, 23));
        TestUtils.testNodeNeighbors(monitor, 9, 12, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 14)
        expectedNeighbors.add(new ComputerNode(10, 14));
        expectedNeighbors.add(new ComputerNode(2, 24));
        TestUtils.testNodeNeighbors(monitor, 2, 14, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 14)
        expectedNeighbors.add(new ComputerNode(2, 14));
        expectedNeighbors.add(new ComputerNode(10, 20));
        TestUtils.testNodeNeighbors(monitor, 10, 14, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 20)
        expectedNeighbors.add(new ComputerNode(13, 20));
        expectedNeighbors.add(new ComputerNode(10, 23));
        TestUtils.testNodeNeighbors(monitor, 10, 20, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (13, 20)
        expectedNeighbors.add(new ComputerNode(10, 20));
        expectedNeighbors.add(new ComputerNode(13, 43));
        TestUtils.testNodeNeighbors(monitor, 13, 20, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (1, 23)
        expectedNeighbors.add(new ComputerNode(10, 23));
        expectedNeighbors.add(new ComputerNode(1, 43));
        TestUtils.testNodeNeighbors(monitor, 1, 23, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 23)
        expectedNeighbors.add(new ComputerNode(9, 23));
        expectedNeighbors.add(new ComputerNode(4, 34));
        TestUtils.testNodeNeighbors(monitor, 4, 23, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (9, 23)
        expectedNeighbors.add(new ComputerNode(4, 23));
        expectedNeighbors.add(new ComputerNode(9, 24));
        TestUtils.testNodeNeighbors(monitor, 9, 23, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 23)
        expectedNeighbors.add(new ComputerNode(1, 23));
        expectedNeighbors.add(new ComputerNode(10, 36));
        TestUtils.testNodeNeighbors(monitor, 10, 23, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 24)
        expectedNeighbors.add(new ComputerNode(9, 24));
        expectedNeighbors.add(new ComputerNode(2, 32));
        TestUtils.testNodeNeighbors(monitor, 2, 24, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (9, 24)
        expectedNeighbors.add(new ComputerNode(2, 24));
        TestUtils.testNodeNeighbors(monitor, 9, 24, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (2, 32)
        expectedNeighbors.add(new ComputerNode(8, 32));
        TestUtils.testNodeNeighbors(monitor, 2, 32, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (8, 32)
        expectedNeighbors.add(new ComputerNode(2, 32));
        TestUtils.testNodeNeighbors(monitor, 8, 32, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 34)
        expectedNeighbors.add(new ComputerNode(4, 34));
        expectedNeighbors.add(new ComputerNode(3, 35));
        TestUtils.testNodeNeighbors(monitor, 3, 34, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (4, 34)
        expectedNeighbors.add(new ComputerNode(3, 34));
        TestUtils.testNodeNeighbors(monitor, 4, 34, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (11, 34)
        expectedNeighbors.add(new ComputerNode(14, 34));
        expectedNeighbors.add(new ComputerNode(11, 35));
        TestUtils.testNodeNeighbors(monitor, 11, 34, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (14, 34)
        expectedNeighbors.add(new ComputerNode(11, 34));
        expectedNeighbors.add(new ComputerNode(14, 35));
        TestUtils.testNodeNeighbors(monitor, 14, 34, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 35)
        expectedNeighbors.add(new ComputerNode(14, 35));
        expectedNeighbors.add(new ComputerNode(3, 37));
        TestUtils.testNodeNeighbors(monitor, 3, 35, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (7, 35)
        expectedNeighbors.add(new ComputerNode(11, 35));
        TestUtils.testNodeNeighbors(monitor, 7, 35, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (11, 35)
        expectedNeighbors.add(new ComputerNode(7, 35));
        TestUtils.testNodeNeighbors(monitor, 11, 35, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (14, 35)
        expectedNeighbors.add(new ComputerNode(3, 35));
        expectedNeighbors.add(new ComputerNode(14, 36));
        TestUtils.testNodeNeighbors(monitor, 14, 35, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (10, 36)
        expectedNeighbors.add(new ComputerNode(14, 36));
        TestUtils.testNodeNeighbors(monitor, 10, 36, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (14, 36)
        expectedNeighbors.add(new ComputerNode(10, 36));
        TestUtils.testNodeNeighbors(monitor, 14, 36, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 37)
        expectedNeighbors.add(new ComputerNode(6, 37));
        expectedNeighbors.add(new ComputerNode(3, 39));
        TestUtils.testNodeNeighbors(monitor, 3, 37, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (6, 37)
        expectedNeighbors.add(new ComputerNode(3, 37));
        TestUtils.testNodeNeighbors(monitor, 6, 37, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (3, 39)
        expectedNeighbors.add(new ComputerNode(12, 39));
        TestUtils.testNodeNeighbors(monitor, 3, 39, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (12, 39)
        expectedNeighbors.add(new ComputerNode(3, 39));
        expectedNeighbors.add(new ComputerNode(12, 42));
        TestUtils.testNodeNeighbors(monitor, 12, 39, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (5, 42)
        expectedNeighbors.add(new ComputerNode(12, 42));
        TestUtils.testNodeNeighbors(monitor, 5, 42, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (12, 42)
        expectedNeighbors.add(new ComputerNode(5, 42));
        TestUtils.testNodeNeighbors(monitor, 12, 42, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (1, 43)
        expectedNeighbors.add(new ComputerNode(13, 43));
        TestUtils.testNodeNeighbors(monitor, 1, 43, expectedNeighbors);
        expectedNeighbors.clear();

        // Node (13, 43)
        expectedNeighbors.add(new ComputerNode(1, 43));
        TestUtils.testNodeNeighbors(monitor, 13, 43, expectedNeighbors);
        expectedNeighbors.clear();
    }

    @Test
    public void testComputerMapping() {
        HashMap<Integer, List<ComputerNode>> computerMapping = monitor.getComputerMapping();

        Set<Integer> keys = computerMapping.keySet();
        HashSet<Integer> expected = new HashSet<>();

        for(int i = 1; i < 15; i++) {
            expected.add(i);
        }

        assertEquals("Wrong keys in HashMap", expected, keys);
    }

    @Test
    public void testQuery1() {
        List<ComputerNode> result = monitor.queryInfection(5, 10, 3, 36);
        assertNotNull("Result should not be null. An infection path exists.", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(5, 5));
        expected.add(new ComputerNode(11, 5));
        expected.add(new ComputerNode(11, 34));
        expected.add(new ComputerNode(14, 34));
        expected.add(new ComputerNode(14, 35));
        expected.add(new ComputerNode(14, 36));
        expected.add(new ComputerNode(10, 36));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery2() {
        List<ComputerNode> result = monitor.queryInfection(5, 10, 3, 20);
        assertNull("Result should be null. An infection path does not exist.", result);
    }

    @Test
    public void testQuery3() {
        List<ComputerNode> result = monitor.queryInfection(5, 10, 3, 30);
        assertNotNull("Result should not be null. An infection path exists.", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(5, 5));
        expected.add(new ComputerNode(1, 5));
        expected.add(new ComputerNode(1, 23));
        expected.add(new ComputerNode(10, 23));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery4() {
        List<ComputerNode> result = monitor.queryInfection(5, 13, 2, 20);
        assertNotNull("Result should not be null. ", result);

        List<ComputerNode> expected = new LinkedList<>();
        expected.add(new ComputerNode(5, 2));
        expected.add(new ComputerNode(7, 2));
        expected.add(new ComputerNode(7, 6));
        expected.add(new ComputerNode(10, 6));
        expected.add(new ComputerNode(10, 14));
        expected.add(new ComputerNode(10, 20));
        expected.add(new ComputerNode(13, 20));

        assertEquals("The expected transmission path does not match the result", expected, result);
    }

    @Test
    public void testQuery5() {
        List<ComputerNode> result = monitor.queryInfection(2, 4, 8, 1);
        assertNull("Result should be null. t1 > t2", result);
    }
}

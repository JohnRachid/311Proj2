import java.util.List;

import static org.junit.Assert.*;

public class TestUtils {

    public static void testNodeMappings(CommunicationsMonitor monitor, int id, List<ComputerNode> expectedMappings) {
        List<ComputerNode> mapping = monitor.getComputerMapping(id);
        StringBuilder errorMessage = new StringBuilder();

        errorMessage.append("Node ");
        errorMessage.append(id);
        errorMessage.append(" mapping does not exist");

        assertNotNull(errorMessage.toString(), mapping);

        errorMessage = new StringBuilder();
        errorMessage.append("Node ");
        errorMessage.append(id);
        errorMessage.append(" mapping does not match expected mapping");

        assertTrue(errorMessage.toString(), mapping.containsAll(expectedMappings));

        errorMessage = new StringBuilder();
        errorMessage.append("Extra neighbors for Node ");
        errorMessage.append(id);

        assertEquals(errorMessage.toString(), expectedMappings.size(), mapping.size());
    }

    public static void testNodeNeighbors(CommunicationsMonitor monitor, int id, int timestamp, List<ComputerNode> expectedNeighbors) {
        ComputerNode node = null;
        List<ComputerNode> mapping = monitor.getComputerMapping(id);
        StringBuilder errorMessage = new StringBuilder();

        for (ComputerNode computerNode : mapping) {
            if (computerNode.getID() == id && computerNode.getTimestamp() == timestamp) {
                node = computerNode;
            }
        }

        errorMessage.append("Node (");
        errorMessage.append(id);
        errorMessage.append(", ");
        errorMessage.append(timestamp);
        errorMessage.append(") does not exist in the graph");

        assertNotNull(errorMessage.toString(), node);

        List<ComputerNode> neighbors = node.getOutNeighbors();

        errorMessage = new StringBuilder();
        errorMessage.append("Neighbors missing for (");
        errorMessage.append(id);
        errorMessage.append(",");
        errorMessage.append(timestamp);
        errorMessage.append(");");

        assertTrue(errorMessage.toString(), neighbors.containsAll(expectedNeighbors));

        errorMessage = new StringBuilder();
        errorMessage.append("Extra neighbors for (");
        errorMessage.append(id);
        errorMessage.append(",");
        errorMessage.append(timestamp);
        errorMessage.append(");");

        assertEquals(errorMessage.toString(), expectedNeighbors.size(), neighbors.size());
    }
}

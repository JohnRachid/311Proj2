import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestInitializations {

    @Test
    public void testNewNode() {
        ComputerNode node = new ComputerNode(0,0);
        assertEquals("ID should be 0 when created", 0, node.getID());
        assertEquals("Timestamp should be 0 when created", 0, node.getTimestamp());
        assertNotNull("OutNeighbors should not be null on new ComputerNode", node.getOutNeighbors());
        assertTrue("OutNeighbors should be empty when initially created", node.getOutNeighbors().isEmpty());
    }

    @Test
    public void testNewMonitor() {
        CommunicationsMonitor monitor = new CommunicationsMonitor();
        List<ComputerNode> result = monitor.queryInfection(0, 1, 0, 1);
        assertNull("Query should result null on empty monitor", result);

        HashMap<Integer, List<ComputerNode>> mapping = monitor.getComputerMapping();
        assertNotNull("ComputerMapping should not be null on new Computer Monitor", mapping);
        assertTrue("ComputerMapping should be empty on new Computer Monitor", mapping.isEmpty());

        List<ComputerNode> mappingC = monitor.getComputerMapping(1);
        assertNull("ComputerMapping on a c for a new ComputerMonitor should be null", mappingC);
    }
}

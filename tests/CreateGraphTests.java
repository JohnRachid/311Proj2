import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateGraphTests {

    @Test
    public void sortTest() throws Exception {
        ComputerNode cn = new ComputerNode(2, 8);
        ComputerNode cn2 = new ComputerNode(1, 4);
        ComputerNode cn3 = new ComputerNode(4, 16);
        ComputerNode cn4 = new ComputerNode(3, 12);
        ArrayList<ComputerNode> nodes = new ArrayList<ComputerNode>();
        nodes.add(cn);
        nodes.add(cn2);
        nodes.add(cn3);
        nodes.add(cn4);
        CommunicationsMonitor cm = new CommunicationsMonitor();
        cm.quickSort(nodes, 0, nodes.size() - 1);
        System.out.println(nodes);
        assertEquals(nodes.get(0).getID(), 1);
    }
}

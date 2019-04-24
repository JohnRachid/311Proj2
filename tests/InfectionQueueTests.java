import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InfectionQueueTests {


    @Test
    public void infectionQueue_Example_1_Good() {
//        HashMap<Integer, List<ComputerNode>> G = new HashMap<Integer, List<ComputerNode>>();
//
//        List<ComputerNode> c1Nodes = new ArrayList<ComputerNode>();
//        ComputerNode c1_4 = new ComputerNode(1, 4);
//        ComputerNode c1_12 = new ComputerNode(1, 12);
//        c1Nodes.add(c1_4);
//        c1Nodes.add(c1_12);
//
//
//        List<ComputerNode> c2Nodes = new ArrayList<ComputerNode>();
//        ComputerNode c2_4 = new ComputerNode(2, 4);
//        ComputerNode c2_8 = new ComputerNode(2, 8);
//        c1Nodes.add(c2_4);
//        c1Nodes.add(c2_8);
//
//        List<ComputerNode> c3Nodes = new ArrayList<ComputerNode>();
//        ComputerNode c3_8 = new ComputerNode(3, 8);
//        c1Nodes.add(c3_8);
//
//        List<ComputerNode> c4Nodes = new ArrayList<ComputerNode>();
//        ComputerNode c4_8 = new ComputerNode(4, 8);
//        ComputerNode c4_8_2 = new ComputerNode(4, 8);
//        ComputerNode c4_12 = new ComputerNode(4, 12);
//        c1Nodes.add(c4_8);
//        c1Nodes.add(c4_8_2);
//        c1Nodes.add(c4_12);
//
//        c1_4.addNeighbor(c2_4);
//        c2_4.addNeighbor(c1_4);
//        c2_4.addNeighbor(c2_8);
//
//        c2_8.addNeighbor(c4_8);
//        c4_8.addNeighbor(c2_8);
//        c4_8.addNeighbor(c4_8_2);
//        c4_8_2.addNeighbor(c4_12);
//
//        c3_8.addNeighbor(c4_8);
//        c4_8.addNeighbor(c3_8);
//
//        c1_12.addNeighbor(c4_12);
//        c4_12.addNeighbor(c1_12);
//        c1_4.addNeighbor(c1_12);
//
//
//        G.put(1, c1Nodes);
//        G.put(2, c2Nodes);
//        G.put(3, c3Nodes);
//        G.put(4, c4Nodes);

        CommunicationsMonitor monitor = new CommunicationsMonitor();
        monitor.addCommunication(1, 2, 4);
        monitor.addCommunication(2, 4, 8);
        monitor.addCommunication(3, 4, 8);
        monitor.addCommunication(1, 4, 12);
        monitor.createGraph();

        List<ComputerNode> results = monitor.queryInfection(1, 3, 2, 8);
        System.out.println(results);
    }




    private List<ComputerNode> queryInfection(HashMap<Integer, List<ComputerNode>> G, int c1, int c2, int x, int y){
        if (G.get(c1) != null) {
            ComputerNode startNode = G.get(c1).get(0);
            List<ComputerNode> Q = new LinkedList<>();
            List<ComputerNode> path = new LinkedList<>();
            Q.add(startNode);
            ComputerNode current;
            while (!Q.isEmpty()) {
                current = Q.remove(0);
                current.visited = true;
                path.add(current);
                for (ComputerNode neighbor : current.getNeighbors()) {
                    if (!neighbor.visited && neighbor.getTimestamp() >= current.getTimestamp()
                            && neighbor.getTimestamp() >= x
                            && neighbor.getTimestamp() <= y) {
                        Q.add(neighbor);
                    }
                    if (current.getID() == c2) {
                        for (int i = 0; i < path.size(); i++) {
                            path.get(i).visited = false;
                        }
                        return path;
                    }
                }
            }
        }
        return null;
    }
}

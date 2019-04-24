import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateGraphTests {

    @Test
    public void sortTest() throws Exception {
        ComputerNode cn = new ComputerNode(2, 8);
        ComputerNode cn2 = new ComputerNode(1, 8);
        ComputerNode cn3 = new ComputerNode(4, 16);
        ComputerNode cn4 = new ComputerNode(3, 16);
        ComputerNode cn5 = new ComputerNode(5, 2);
        ComputerNode cn6 = new ComputerNode(6, 2);
        ComputerNode cn7 = new ComputerNode(7, 5);
        ComputerNode cn8 = new ComputerNode(8, 5);
        ComputerNode cn9 = new ComputerNode(9, 1);
        ComputerNode cn10 = new ComputerNode(10, 1);
        ComputerNode cn11 = new ComputerNode(11, 20);
        ComputerNode cn12 = new ComputerNode(12, 20);

        ArrayList<ComputerNode[]> nodes = new ArrayList<ComputerNode[]>();
        nodes.add(new ComputerNode[] {cn, cn2});
        nodes.add(new ComputerNode[] {cn3, cn4});
        nodes.add(new ComputerNode[] {cn5, cn6});
        nodes.add(new ComputerNode[] {cn7, cn8});
        nodes.add(new ComputerNode[] {cn9, cn10});
        nodes.add(new ComputerNode[] {cn11, cn12});

        CommunicationsMonitor cm = new CommunicationsMonitor();
        nodes = cm.quickSort(nodes, 0, nodes.size() - 1);
        assertEquals(9, nodes.get(0)[0].getID());
    }

    @Test
    public void createGraph1(){
        ComputerNode cn = new ComputerNode(2, 8);
        ComputerNode cn2 = new ComputerNode(1, 8);
        ComputerNode cn3 = new ComputerNode(4, 16);
        ComputerNode cn4 = new ComputerNode(8, 16);
        ComputerNode cn5 = new ComputerNode(5, 2);
        ComputerNode cn6 = new ComputerNode(6, 2);
        ComputerNode cn7 = new ComputerNode(3, 5);
        ComputerNode cn8 = new ComputerNode(8, 5);
        ComputerNode cn9 = new ComputerNode(9, 1);
        ComputerNode cn10 = new ComputerNode(10, 1);
        ComputerNode cn11 = new ComputerNode(8, 20);
        ComputerNode cn12 = new ComputerNode(12, 20);

        CommunicationsMonitor cm = new CommunicationsMonitor();
        ArrayList<ComputerNode[]> dad = cm.E;
        dad.add(new ComputerNode[] {cn, cn2});
        dad.add(new ComputerNode[] {cn3, cn4});
        dad.add(new ComputerNode[] {cn5, cn6});
        dad.add(new ComputerNode[] {cn7, cn8});
        dad.add(new ComputerNode[] {cn9, cn10});
        dad.add(new ComputerNode[] {cn11, cn12});
        cm.createGraph();
        assertEquals(12, cm.E.size() * 2);
    }

    @Test
    public void runtimeTest1(){
        int maxC = 10000;
        int maxT = 2500;
        CommunicationsMonitor cm = new CommunicationsMonitor();
        ArrayList<ComputerNode[]> nodes = cm.getE();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            nodes.add(TripleGenerator.generateTripleRand(maxC, maxT));
        }
        cm.createGraph();
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
        assertEquals(true, duration <= 3000);
    }
}

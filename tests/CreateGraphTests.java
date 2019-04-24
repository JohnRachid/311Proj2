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
        for (ComputerNode[] cnArr : nodes){
            System.out.println(cnArr[0] + ", " + cnArr[1]);
        }
        System.out.println();
        CommunicationsMonitor cm = new CommunicationsMonitor();
        nodes = cm.quickSort(nodes, 0, nodes.size() - 1);
        for (ComputerNode[] cnArr : nodes){
            System.out.println(cnArr[0] + ", " + cnArr[1]);
        }
        assertEquals(9, nodes.get(0)[0].getID());
    }
}

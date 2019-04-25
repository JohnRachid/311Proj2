import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class CommunicationsMonitor {
    private HashMap<Integer, List<ComputerNode>> G;
    public ArrayList<ComputerNode[]> E;
    private boolean calledCreateGraph;


    public CommunicationsMonitor(){
        G = new HashMap<Integer, List<ComputerNode>>();
        E = new ArrayList<ComputerNode[]>();
        ArrayList computerNodeList = new ArrayList<ComputerNode>();
        calledCreateGraph = false;
    }

    public void createGraph(){
        if (!calledCreateGraph) {
            calledCreateGraph = true;
            ArrayList<ComputerNode[]> sorted = (ArrayList<ComputerNode[]>) E.clone();
            sorted = quickSort(sorted, 0, sorted.size() - 1);


            for (int i = 0; i < sorted.size(); i++) {
                ComputerNode[] curNode = sorted.get(i);
                if (!G.containsKey(curNode[0].getID())) {
                    G.put(curNode[0].getID(), new LinkedList<ComputerNode>());
                }
                if (!G.containsKey(curNode[1].getID())) {
                    G.put(curNode[1].getID(), new LinkedList<ComputerNode>());
                }

                ComputerNode cn1 = sorted.get(i)[0];
                ComputerNode cn2 = sorted.get(i)[1];

                LinkedList<ComputerNode> list1 = (LinkedList<ComputerNode>) G.get(curNode[0].getID());
                LinkedList<ComputerNode> list2 = (LinkedList<ComputerNode>) G.get(curNode[1].getID());
                int size1 = list1.size();
                int size2 = list2.size();

                handleNeighbors(cn1, cn2, size1, size2);
                handleNeighbors(cn2, cn1, size2, size1);

                if (size1 >= 1 && G.get(cn1.getID()).get(size1-1).getTimestamp() == cn1.getTimestamp()) {
                    G.get(cn1.getID()).get(size1-1).addNeighbor(cn2);
                }else{
                    list1.add(cn1);
                }
                if (size2 >= 1 && G.get(cn2.getID()).get(size2-1).getTimestamp() == cn2.getTimestamp()) {
                    G.get(cn2.getID()).get(size2-1).addNeighbor(cn1);
                }else{
                    list2.add(cn2);
                }

                if (size1 >= 1 && !(G.get(cn1.getID()).get(size1-1).equals(cn1)) && !(G.get(cn1.getID()).get(size1-1).getNeighbors().contains(cn1))) {
                    G.get(cn1.getID()).get(size1-1).addNeighbor(cn1);
                }
                if (size2 >= 1 && !(G.get(cn2.getID()).get(size2-1).equals(cn2)) && !(G.get(cn2.getID()).get(size2-1).getNeighbors().contains(cn2))) {
                    G.get(cn2.getID()).get(size2-1).addNeighbor(cn2);
                }
            }
        }else{
            System.err.println("According to the PDF, this method can't be called more than once.");
        }

    }

    public void handleNeighbors(ComputerNode cn1, ComputerNode cn2, int size1, int size2)
    {
        if (size1 >= 1 && G.get(cn1.getID()).get(size1 - 1).equals(cn1)) {
            G.get(cn1.getID()).get(size1 - 1).addNeighbor(cn2);
        } else if (size2 >= 1 && G.get(cn2.getID()).get(size2 - 1).equals(cn2)) {
            cn1.addNeighbor(G.get(cn2.getID()).get(size2 - 1));
        } else {
            cn1.addNeighbor(cn2);
        }
    }

    public static ArrayList<ComputerNode[]> quickSort(ArrayList<ComputerNode[]> computerNodeList, int first, int last) {
        if (first >= last) {
            return computerNodeList;
        }
        int p = partition(computerNodeList, first, last);
        computerNodeList = quickSort(computerNodeList, first, p - 1);
        computerNodeList = quickSort(computerNodeList, p + 1, last);
        return computerNodeList;
    }

    private static int partition(ArrayList<ComputerNode[]> computerNodeList, int first, int last) {
        ComputerNode[] pivot = computerNodeList.get(last);
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (computerNodeList.get(j)[0].getTimestamp() <= pivot[0].getTimestamp()) {
                i++;
                ComputerNode[] temp = computerNodeList.get(i);
                computerNodeList.set(i, computerNodeList.get(j));
                computerNodeList.set(j, temp);
            }
        }
        i++;
        ComputerNode[] next = computerNodeList.get(i);
        computerNodeList.set(i, pivot);
        computerNodeList.set(last, next);
        return i;
    }

    public void addCommunication(int c1, int c2, int timestamp){
        ComputerNode a = new ComputerNode(c1,timestamp);
        ComputerNode b = new ComputerNode(c2,timestamp);
        E.add(new ComputerNode[]{a, b});

    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){
        if (G.get(c1) != null) {
            ComputerNode startNode = G.get(c1).get(0);
            int currentPlace = 1;
            while(!(startNode.getTimestamp() >= x && startNode.getTimestamp() <= y) && currentPlace < G.get(c1).size()) {
                startNode = G.get(c1).get(currentPlace);
                currentPlace++;
                if (currentPlace >= G.get(c1).size()) {
                    return null;
                }
            }
            List<ComputerNode> Q = new LinkedList<>();
            List<ComputerNode> path = new LinkedList<>();
            ComputerNode current;
            Q.add(startNode);
            while (!Q.isEmpty()) {
                current = Q.remove(0);
                current.visited = true;
                path.add(current);
                for (ComputerNode neighbor : current.getNeighbors()) {
                    if (!neighbor.visited && neighbor.getTimestamp() >= current.getTimestamp()
                            && neighbor.getTimestamp() >= x
                            && neighbor.getTimestamp() <= y) {
                        Q.add(neighbor);
                        neighbor.pred = current;
                    }
                    if (current.getID() == c2) {
                        for (int i = 0; i < path.size(); i++) {
                            path.get(i).visited = false;
                        }
                        List<ComputerNode> finalPath = new LinkedList<ComputerNode>();
                        ComputerNode travNode = current;
                        finalPath.add(0, travNode);
                        while (travNode.pred != null) {
                            finalPath.add(0, travNode.pred);
                            travNode = travNode.pred;
                        }
                        return finalPath;
                    }
                }
            }
            for (int i = 0; i < path.size(); i++) {
                path.get(i).visited = false;
            }
        }
        return null;
    }

    public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
        return G;
    }

    public List<ComputerNode> getComputerMapping(int c){
        return G.get(c);
    }

    public void printMap(){
        for (Integer i : G.keySet()){
            LinkedList<ComputerNode> list = (LinkedList<ComputerNode>)G.get(i);
            for (int j = 0; j < list.size(); j++){
                ComputerNode node = list.get(j);
                System.out.print("(" + node + "), ");
            }
            System.out.println();
        }
    }

    public ArrayList<ComputerNode[]> getE() {
        return E;
    }
}
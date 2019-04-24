import javafx.util.Pair;

import java.util.*;

public class CommunicationsMonitor {
    private HashMap<Integer, List<ComputerNode>> G;
    public ArrayList<ComputerNode[]> E;


    public CommunicationsMonitor() {
        G = new HashMap<Integer, List<ComputerNode>>();
        E = new ArrayList<ComputerNode[]>();
        ArrayList computerNodeList = new ArrayList<ComputerNode>();
    }

    public void createGraph() {
        ArrayList<ComputerNode[]> sorted = (ArrayList<ComputerNode[]>) E.clone();
        sorted = quickSort(sorted, 0, sorted.size() - 1);

        for (int i = 0; i < sorted.size(); i++) {
            if (!G.containsKey(sorted.get(i)[0])) {
                G.put(sorted.get(i)[0].getID(), new LinkedList<ComputerNode>());
            }
            if (!G.containsKey(sorted.get(i)[1])) {
                G.put(sorted.get(i)[1].getID(), new LinkedList<ComputerNode>());
            }
            ComputerNode cn1 = E.get(i)[0];
            ComputerNode cn2 = E.get(i)[1];
            LinkedList<ComputerNode> list1 = (LinkedList<ComputerNode>) G.get(i);
            LinkedList<ComputerNode> list2 = (LinkedList<ComputerNode>) G.get(i);
            int size1 = list1.size();
            int size2 = list2.size();
            list1.add(cn1);
            list2.add(cn2);
            if (size1 > 1) {
                cn1.addNeighbor(sorted.get(i - 1)[0]);
            }
            if (size2 > 1) {
                cn1.addNeighbor(sorted.get(i - 1)[0]);
            }
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
        int j = first;
        int i = first - 1;
        for (; j < last; j++) {
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

    public void addCommunication(int c1, int c2, int timestamp) {
        ComputerNode a = new ComputerNode(c1, timestamp);
        ComputerNode b = new ComputerNode(c2, timestamp);
        E.add(new ComputerNode[]{a, b});

        a.addNeighbor(b);
        b.addNeighbor(a);

    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y) {
        if (G.get(c1) != null) {
            ComputerNode startNode = G.get(c1).get(0);
            List<ComputerNode> Q = new LinkedList<>();
            List<ComputerNode> path = new LinkedList<>();
            Q.add(startNode);
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

    public HashMap<Integer, List<ComputerNode>> getComputerMapping() {
        return G;
    }

    public List<ComputerNode> getComputerMapping(int c) {
        return null;
    }

//    public void bfs(int start) {
//        int[] visited = new int[adjList.length];
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//
//        if (start >= adjList.length || start < 0) {
//            System.err.println("Start value doesn't exist");
//            return;
//        }
//        visited[start] = 1;
//        queue.add(start);
//
//        while (queue.size() != 0) {
//            start = queue.poll();
//            System.out.print(start);
//            for (int i = 0; i < adjList[start].size(); i++) {
//                int next = adjList[start].get(i);
//                if (visited[next] == 0) {
//                    visited[next] = 1;
//                    queue.add(next);
//                }
//            }
//        }
//    }
}

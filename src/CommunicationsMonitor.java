import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class CommunicationsMonitor {
    private HashMap<Integer, List<ComputerNode>> G;
    public ArrayList<ComputerNode> computerNodeList;
    public ArrayList<Pair<ComputerNode, ComputerNode>> E;


    public CommunicationsMonitor(){
        G = new HashMap<Integer, List<ComputerNode>>();
        E = new ArrayList<Pair<ComputerNode, ComputerNode>>();
        ArrayList computerNodeList = new ArrayList<ComputerNode>();
    }

    public void createGraph(){
        ArrayList<ComputerNode> sorted = (ArrayList<ComputerNode>)computerNodeList.clone();
        sorted = quickSort(sorted, 0, sorted.size()-1);

       // for (int i = 0; i < )

    }

    public static ArrayList<ComputerNode> quickSort(ArrayList<ComputerNode> computerNodeList, int first, int last) {
        if (first >= last) {
            return computerNodeList;
        }
        int p = partition(computerNodeList, first, last);
        computerNodeList = quickSort(computerNodeList, first, p - 1);
        computerNodeList = quickSort(computerNodeList, p + 1, last);
        return computerNodeList;
    }

    private static int partition(ArrayList<ComputerNode> computerNodeList, int first, int last) {
        ComputerNode pivot = computerNodeList.get(last);
        int j = first;
        int i = first - 1;
        for (; j < last; j++) {
            if (computerNodeList.get(j).getTimestamp() <= pivot.getTimestamp()) {
                i++;
                ComputerNode temp = computerNodeList.get(i);
                computerNodeList.set(i, computerNodeList.get(j));
                computerNodeList.set(i, temp);
            }
        }
        ComputerNode temp = computerNodeList.get(last);
        i++;
        ComputerNode next = computerNodeList.get(i);
        for (int k = i; k < last; k++) {
            temp = computerNodeList.get(k+1);
            computerNodeList.set(k+1, next);
            next = temp;
        }
        computerNodeList.set(i, pivot);
        int[][] output = new int[2][];
        return i;
    }

    public void addCommunication(int c1, int c2, int timestamp){
        ComputerNode a = new ComputerNode(c1,timestamp);
        ComputerNode b = new ComputerNode(c2,timestamp);
        E.add(new Pair<ComputerNode, ComputerNode>(a, b));
        computerNodeList.add(a);
        computerNodeList.add(b);

        a.addNeighbor(b);
        b.addNeighbor(a);

    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){
        return null;
    }

    public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
        return G;
    }

    public List<ComputerNode> getComputerMapping(int c){
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

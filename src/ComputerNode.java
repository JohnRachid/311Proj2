import java.util.ArrayList;
import java.util.List;

public class ComputerNode {

    private int id;
    private int timestamp;
    public boolean visited;
    public ArrayList<ComputerNode> neighbors;

    ComputerNode(int newID, int newTimestamp){
        id = newID;
        timestamp = newTimestamp;
        neighbors = new ArrayList<ComputerNode>();
        visited = false;
    }

    public String toString(){
        return id + " " + timestamp;
    }

    int getID(){
        return id;
    }

    int getTimestamp(){
        return timestamp;
    }

    List<ComputerNode> getOutNeighbors(){
        return neighbors;
    }

    public void addNeighbor(ComputerNode node){
        neighbors.add(node);
    }

    public ArrayList<ComputerNode> getNeighbors(){
        return neighbors;
    }


}

import java.util.ArrayList;
import java.util.List;

public class ComputerNode {
    private int id;
    private int timestamp;
    public ArrayList<ComputerNode> neighbors;

    ComputerNode(int newID, int newTimestamp){
        id = newID;
        timestamp = newTimestamp;
        ArrayList<ComputerNode> neighbors = new ArrayList<ComputerNode>();
    }

    int getID(){
        return id;
    }

    int getTimestamp(){
        return timestamp;
    }
    List<ComputerNode> getOutNeighbors(int c){
        return null; //TODO finish getOutNeighbors
    }

    public void addNeighbor(ComputerNode node){
        neighbors.add(node);
    }

    public ArrayList<ComputerNode> getNeighbors(){
        return neighbors;
    }


}

import java.util.ArrayList;
import java.util.List;

public class ComputerNode {

    private int id;
    private int timestamp;
    public boolean visited;
    public ComputerNode pred;
    public ArrayList<ComputerNode> neighbors;

    ComputerNode(int newID, int newTimestamp){
        id = newID;
        timestamp = newTimestamp;
        neighbors = new ArrayList<ComputerNode>();
        visited = false;
        pred = null;
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
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).equals(node)) {
                return;
            }
        }
        neighbors.add(node);
    }

    public ArrayList<ComputerNode> getNeighbors(){
        return neighbors;
    }


    public boolean equals(ComputerNode c2) {
        if (c2 == null) {
            return false;
        }
        if (timestamp == c2.getTimestamp() && id == c2.getID()) {
            return true;
        } else {
            return false;
        }
    }

    public void setId(int id2){
        id = id2;
    }
    public int setTimestamp(int timestamp2){
        return timestamp = timestamp2;
    }

}

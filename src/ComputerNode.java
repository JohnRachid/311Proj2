import java.util.List;

public class ComputerNode {
    private int id;
    private int timestamp;
    ComputerNode(int newID, int newTimestamp){
        id = newID;
        timestamp = newTimestamp;
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
    List<ComputerNode> getOutNeighbors(int c){
        return null; //TODO finish getOutNeighbors
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CommunicationsMonitor {
    private HashMap<Integer, List<ComputerNode>> G;
    public ArrayList<ComputerNode> computerNodeList;
    public CommunicationsMonitor(){
        G = new HashMap<Integer, List<ComputerNode>>;
        ArrayList computerNodeList = new ArrayList<ComputerNode>();
    }

    public void createGraph(){

    }

    public void addCommunication(int c1, int c2, int timestamp){
        ComputerNode a = new ComputerNode(c1,timestamp);
        ComputerNode b = new ComputerNode(c2,timestamp);
        computerNodeList.add(a);
        computerNodeList.add(b);

    }

    public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){

    }

    public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
        return G;
    }

    public List<ComputerNode> getComputerMapping(int c){

    }
}

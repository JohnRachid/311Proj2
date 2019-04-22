import java.util.HashMap;
import java.util.List;

public class CommunicationsMonitor {
    private HashMap<Integer, List<ComputerNode>> G;

    public CommunicationsMonitor(){
        G = new HashMap<Integer, List<ComputerNode>>();
    }

    public void createGraph(){

    }

    public void addCommunication(){
    
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
}

import java.util.HashMap;
import java.util.List;

public class CommunicationsMonitor {
	
	private HashMap<Integer, List<ComputerNode>> G;
	
	public CommunicationsMonitor() {
		G = new HashMap<Integer, List<ComputerNode>>();
	}
	
	public void addCommunication(int c1, int c2, int timestamp) {
		
	}
	
	public void createGraph() {
		
	}
	
	public List<ComputerNode> queryInfection(int c1, int c2, int x, int y){
		return null;
	}
	
	public HashMap<Integer, List<ComputerNode>> getComputerMapping(){
		return null;
	}
	
	public List<ComputerNode> getComputerMapping(int c){
		return null;
	}
}

import java.util.Random;

public class TripleGenerator {

    public static ComputerNode[] generateTripleRand(int maxC, int maxT){
        Random rand = new Random();

        ComputerNode cn1 = new ComputerNode(rand.nextInt(maxC), rand.nextInt(maxT));
        ComputerNode cn2 = new ComputerNode(rand.nextInt(maxC), rand.nextInt(maxT));
        return new ComputerNode[]{cn1, cn2};
    }

    public static ComputerNode[] genrateTriple(int c1, int c2, int t){
        ComputerNode cn1 = new ComputerNode(c1, t);
        ComputerNode cn2 = new ComputerNode(c2, t);
        return new ComputerNode[]{cn1, cn2};
    }

}

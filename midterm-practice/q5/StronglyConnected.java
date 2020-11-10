package q5;
import java.util.ArrayList;

public class StronglyConnected {

    static boolean testStronglyConnected(int nodecount, int linkcount, ArrayList<Integer> listOfLink) {
        if (nodecount > linkcount) return false;

        ArrayList<Integer[]> nodeList = new ArrayList<>();

        for (int i = 0; i<listOfLink.size(); i+=2) {
            nodeList.add(new Integer[]{listOfLink.get(i), listOfLink.get(i + 1)});
        }

        Integer[] firstNode = nodeList.get(0);
        ArrayList<Integer[]> nodeList2 = new ArrayList<>();
        nodeList2.add(nodeList.remove(0));

        while (nodeList.isEmpty()==false) {
            for (int i=0; i < nodeList.size(); i++) {
                if (nodeList2.get(nodeList2.size() - 1)[1] == nodeList.get(i)[0]) {
                    nodeList2.add(nodeList.remove(i));
                    break;
                }
                if (i==nodeList.size() - 1) return false;
            }
        }
        if (nodeList2.get(nodeList2.size() - 1)[1] != firstNode[0]) return false;
        return true;
    }
}



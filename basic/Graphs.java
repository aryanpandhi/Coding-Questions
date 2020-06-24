import java.util.ArrayList;

class Graphs{

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(6);
        for (int i = 0; i<6;i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(4);
        graph.get(0).add(5);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(3).add(2);
        graph.get(3).add(4);
        System.out.println(graph);
    } 

    static int[] DFSRecursive(ArrayList<ArrayList<Integer>> graph){
        return null;
    }

    static int[] DFSIterative(ArrayList<ArrayList<Integer>> graph){
        return null;
    }

    static int[] BFS(ArrayList<ArrayList<Integer>> graph){
        return null;
    }

}
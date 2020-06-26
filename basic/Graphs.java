import java.util.ArrayList;

class Graphs{

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        graph = new ArrayList<ArrayList<Integer>>(6);
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
        visited = new boolean[6];
        System.out.println(DFSRecursive(0));

    } 

    static String DFSRecursive(Integer u){
        visited[u] = true;
        String visits = "";
        for(Integer node: graph.get(u)){
            if (!visited[node]) 
                visits +=  DFSRecursive(node);
        }
        return Integer.toString(u) + " " + visits;
    }

    static int[] DFSIterative(ArrayList<ArrayList<Integer>> graph){
        return null;
    }

    static int[] BFS(ArrayList<ArrayList<Integer>> graph){
        return null;
    }

}
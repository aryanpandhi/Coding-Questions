import java.util.*;

class GraphsTest{

    public static void main(String[] Args) {
        Graphs graph1 = new Graphs(9);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 5);
        graph1.addEdge(1, 7);
        graph1.addEdge(2, 3);
        graph1.addEdge(2, 5);
        graph1.addEdge(3, 5);
        graph1.addEdge(4, 5);
        graph1.addEdge(4, 6);
        graph1.addEdge(7, 5);
        graph1.addEdge(7, 8);
        // int graphSize = 6;
        // graph = new ArrayList<ArrayList<Integer>>(graphSize);
        // for (int i = 0; i<graphSize; i++){
        //     graph.add(new ArrayList<Integer>());
        // }
        // graph.get(0).add(1);
        // graph.get(0).add(4);
        // graph.get(0).add(5);
        // graph.get(1).add(3);
        // graph.get(1).add(4);
        // graph.get(2).add(1);
        // graph.get(3).add(2);
        // graph.get(3).add(4);
        // visited = new boolean[graphSize];
        // discovered = new boolean[graphSize];
        System.out.println(graph1.BFSOptimized(1));

    } 

}
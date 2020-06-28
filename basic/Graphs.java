import java.util.*;

class Graphs{

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean[] discovered; // to avoid multiple copies on the stack/queue

    public static void main(String[] Args) {
        int graphSize = 9;
        graph = new ArrayList<ArrayList<Integer>>(graphSize);
        for (int i = 0; i<graphSize; i++){
            graph.add(new ArrayList<Integer>());
        }
        graph.get(1).add(2);
        graph.get(1).add(5);
        graph.get(1).add(7);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(5);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(7).add(5);
        graph.get(7).add(8);
        visited = new boolean[graphSize];
        discovered = new boolean[graphSize];
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
        System.out.println(BFSOptimized(1));

    } 

    static LinkedList<Integer> DFSRecursive(int u){
        visited[u] = true;
        LinkedList<Integer> visits = new LinkedList<>();
        for(Integer node: graph.get(u)){
            if (!visited[node]) 
                visits.addAll(DFSRecursive(node));
        }
        visits.addFirst(u);
        return visits;
    }

    static LinkedList<Integer> DFSIterative(int u){
        Stack<Integer> stack = new Stack<>();
        stack.push(u);
        LinkedList<Integer> visits = new LinkedList<>();
        while(!stack.isEmpty()){
            int node = stack.pop();
            if (!visited[node]){
                visited[node] = true;
                visits.add(node);
                for (Integer neighbor : graph.get(node)){
                    stack.push(neighbor);
                }
            }
        }
        return visits;
    }

    static LinkedList<Integer> DFSIterativeOptimized(int u){
        Stack<Integer> stack = new Stack<>();
        stack.push(u);
        LinkedList<Integer> visits = new LinkedList<>();
        while(!stack.isEmpty()){
            int node = stack.pop();
            visited[node] = true;
            visits.add(node);
            for (Integer neighbor : graph.get(node)){
                if (!discovered[neighbor]){
                    discovered[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return visits;
    }

    static LinkedList<Integer> BFS(int u){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        LinkedList<Integer> visits = new LinkedList<>();
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            if (!visited[node]){
                visited[node] = true;
                visits.add(node);
                for (Integer neighbor: graph.get(node)){
                    queue.add(neighbor);
                }
            }
        }
        return visits;
    }

    static LinkedList<Integer> BFSOptimized(int u){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        LinkedList<Integer> visits = new LinkedList<>();
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            visited[node] = true;
            visits.add(node);
            for (Integer neighbor : graph.get(node)){
                if (!discovered[neighbor]){
                    discovered[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return visits;
    }

}
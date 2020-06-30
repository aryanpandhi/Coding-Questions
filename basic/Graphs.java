import java.util.*;

class Graphs{

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean[] discovered; // to avoid multiple copies on the stack/queue

    Graphs(int graphSize){
        graph =  new ArrayList<ArrayList<Integer>>(graphSize);
        for (int i = 0; i<graphSize; i++){
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[graphSize];
        discovered = new boolean[graphSize];
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
    }

    LinkedList<Integer> DFSRecursive(int u){
        visited[u] = true;
        LinkedList<Integer> visits = new LinkedList<>();
        for(Integer node: graph.get(u)){
            if (!visited[node]) 
                visits.addAll(DFSRecursive(node));
        }
        visits.addFirst(u);
        return visits;
    }

    LinkedList<Integer> DFSIterative(int u){
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

    LinkedList<Integer> DFSIterativeOptimized(int u){
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

    LinkedList<Integer> BFS(int u){
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

    LinkedList<Integer> BFSOptimized(int u){
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
import java.util.*;

public class Representation {
    public static ArrayList<Integer> BFS(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        boolean vis[] = new boolean[v];

        Q.add(0);
        vis[0] = true;

        while (!Q.isEmpty()) {
            Integer Node = Q.poll();
            bfs.add(Node); // Missing this line to store the BFS traversal

            for (int i = 0; i < adj.get(Node).size(); i++) {
                Integer it = adj.get(Node).get(i);
                if (!vis[it]) {
                    vis[it] = true;
                    Q.add(it);
                }
            }
        }

        return bfs; // Missing return
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> result = BFS(5, adj);
        System.out.println("BFS Traversal: " + result);
    }
}

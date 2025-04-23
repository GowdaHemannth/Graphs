import java.util.*;

public class Path {
    public static class Pair {
        int Node;
        int Weight;
        public Pair(int Node, int Weight) {
            this.Node = Node;
            this.Weight = Weight;
        }
    }

    public static List<Integer> findShortestPath(int v, ArrayList<ArrayList<Pair>> adj) {
        int[] parent = new int[v];
        Arrays.fill(parent, -1);

        int[] dist = new int[v];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.Weight - y.Weight);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().Node;
            int weight = pq.peek().Weight;
            pq.poll();

            for (Pair neighbor : adj.get(node)) {
                int it = neighbor.Node;
                int dis = neighbor.Weight;
                if (weight + dis < dist[it]) {
                    dist[it] = weight + dis;
                    parent[it] = node;
                    pq.add(new Pair(it, dist[it]));
                }
            }
        }

        // Backtrack path from node 4 to 0
        List<Integer> ans = new ArrayList<>();
        int n = 4;
        if (dist[n] == (int) 1e9) return ans; // unreachable
        while (n != -1) {
            ans.add(n);
            n = parent[n];
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(3, 6));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(1).add(new Pair(4, 5));
        adj.get(2).add(new Pair(4, 7));
        adj.get(3).add(new Pair(4, 9));

        List<Integer> path = findShortestPath(V, adj);
        System.out.println("Shortest path from 0 to 4: " + path);
    }
}

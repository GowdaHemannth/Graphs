import java.util.*;
public class PrimsAlgorithm {
     static class Pair{
        int Node;
        int Wieght;
        public Pair(int Node,int Wieght){
            this.Node=Node;
            this.Wieght=Wieght;
        }

        
    }
    public static int AlgorithmOfPrims(ArrayList<ArrayList<Pair>>Adj){
        PriorityQueue<Pair>Pq=new PriorityQueue<>((x,y)-> x.Wieght-y.Wieght);
        int vis[]=new int[5];
        Pq.add(new Pair(0, 0));
        int Sum=0;

        while(!Pq.isEmpty()){
            int Node=Pq.peek().Node;
            int Weight=Pq.peek().Wieght;
            Pq.remove();

            if(vis[Node]==1){
                continue;

            }
            vis[Node]=1;
            Sum=Sum+Weight;

            for(int i=0;i<Adj.get(Node).size();i++){
                int node=Adj.get(Node).get(i).Node;
                int Kilo=Adj.get(Node).get(i).Wieght;
                if(vis[node]!=1){
                    Pq.add(new Pair(node, Kilo));
                }

            }

        }
        return Sum;

    }
    public static void main(String[] args) {
        int Edges[][]={{0,1,2},{0,2,1},{1,2,1},{2,3,2},{3,4,1},{4,2,2}};
        ArrayList<ArrayList<Pair>>Adj=new ArrayList<>();
        int n=5;
        for(int i=0;i<n;i++){
            Adj.add(new ArrayList<>());
        }

        for(int i=0;i<Edges.length;i++){
            int u=Edges[i][0];
            int v=Edges[i][1];
            int wt=Edges[i][2];
            Adj.get(u).add(new Pair(v, wt));
            Adj.get(v).add(new Pair(u, wt));
        }
    System.out.println( AlgorithmOfPrims(Adj));


    }
    
}

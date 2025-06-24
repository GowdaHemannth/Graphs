import java.util.*;
class Edge implements Comparable<Edge>{
    int src;
    int Dest;
    int Weight;
    Edge(int src,int Dest,int Weight){
       src=this.src;
       Dest=this.Dest;
       Weight=this.Weight;


    }
    public int compareTo(Edge compareEdge){
        return this.Weight-compareEdge.Weight;
    }
}
public class Kruskal{
    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<ArrayList<Integer>>>Adj=new ArrayList<>();
        int [][]edges={{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
         for(int i=0;i<V;i++){
            Adj.add(new ArrayList<ArrayList<Integer>>());
         }
            for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            Adj.get(u).add(tmp1);
            Adj.get(v).add(tmp2);
        }

         } 
    }

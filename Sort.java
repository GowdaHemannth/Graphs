import java.util.*;
public class Sort {
    public class Pair{
        int Node;
        int Weight;
        public Pair(int Node,int Weight){
            this.Node=Node;
            this.Weight=Weight;
        }
    }
    public static int[] Function(int V,ArrayList<ArrayList<Integer>>adjArrayList,int S){
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)-> x.Weight-y.Weight);
        int dist[]=new int [V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
       // pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            int node=pq.peek().Node;
            int  weight=pq.peek().Weight;
            pq.remove();
            for(int i=0;i<adjArrayList.get(node).size();i++){
                int it=adjArrayList.get(node).get(i);
                if(weight+1<dist[it]){
                    dist[it]=weight+1;
                   // pq.add(new Pair(it,dist[it]));
                }
            }
        }
        return dist;
      
    }
    public static void main(String[] args) {
        int V = 3, E = 3, S = 2;
        ArrayList<ArrayList<Integer>>adjArrayList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjArrayList.add(new ArrayList<>());
        }
        adjArrayList.get(0).add(1); // 0 -> 1
        adjArrayList.get(1).add(0); // 1 -> 0
        adjArrayList.get(1).add(2); // 1 -> 2
        adjArrayList.get(2).add(1); // 2 -> 1
    
}
}

import java.util.*;
public class DjikistraMain {
    public static int[] Shortest(int n,int m,int Edges[][]){
        ArrayList<ArrayList<Integer>>Ajs=new ArrayList<>();
        for (int i=0;i<n;i++){
            Ajs.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            Ajs.get(Edges[i][0]).add(Edges[i][1]);
            Ajs.get(Edges[i][1]).add(Edges[i][0]);
            // Since It is a Undirectiona; We need to Add edges to the Incoming as well as OutGoing 
        }
    int dist[]=new int[n];
    for(int i=0;i<n;i++){
        dist[i]=(int)1e9;
    }

    dist[0]=0; // We need to Add Sorce Node as Zero Sice it is 0 is a Souce Node Here we are adding it as only Zero 
    Queue<Integer>Q=new LinkedList<>();
    Q.add(0);
    while(!Q.isEmpty()){
        int Node =Q.peek();
        Q.poll();
        for(int i=0;i<Ajs.get(Node).size();i++){
            int it=Ajs.get(Node).get(i);
            if(dist[it]>1+dist[Node]){
                dist[it]=1+dist[Node];
                Q.add(it);
            }
        }
    }
 
   return dist;
    }
    public static void main(String[] args) {
        // Here Everything Has Unit Edges ;
        int Edges[][]={{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int n=9;
        int m=10;
        int Arr[]=Shortest(n, m, Edges);
        for(int i=0;i<n;i++){
            System.out.print(Arr[i]);
        }

    }
    
}

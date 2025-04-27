import java.util.*;
public class BellonmanFord {
    public static int[] Function(   ArrayList<ArrayList<Integer>> edges, int v){
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=(int)1e9;
        }

        dist[0]=0; // Since it is a Souce Node ;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<edges.size();j++){
                int u=edges.get(j).get(0);
                int V=edges.get(j).get(1);
                int Weight=edges.get(j).get(2);
                if(dist[u]!=1e9&&dist[u]+Weight<dist[V]){
                    dist[V]=dist[u]+Weight;
                }
            }
        }

        // To detect the Negative Cycles 
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int V=edges.get(i).get(1);
            int Weight=edges.get(i).get(2);
            if(dist[u]!=1e9&&dist[u]+Weight<dist[V]){
            int arr[]=new int[1];
           arr[0]=-1;
           return arr;
        }

    }
    return dist;
}
    public static void main(String[] args) {
        int v=6;
        int s=0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
    int A[]=Function(edges, v);
     for(int i=0;i<v;i++){
        System.out.println(A[i]);
     }

    }

    
}


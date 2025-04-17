import java.util.*;
class Pair{
    int First;
    int Second;
    Pair(int First,int Second){
        this.First=First;
        this.Second=Second;
    }
}

public class Djikisthra{
    public static void TopoSort(int i,ArrayList<ArrayList<Pair>>Ajs,Stack<Integer>st,int Vis[]){
        Vis[i]=0;
        for(int j=0;j<Ajs.get(i).size();j++){
            int It=Ajs.get(i).get(j).First;
            if(Vis[It]==0){
                TopoSort(It, Ajs, st, Vis);
            }
        }
        st.add(i);
    }
    public static int[] ShortestPath(int N,int M,int Edges[][]){
        ArrayList<ArrayList<Pair>>Ajs=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Pair>Temp=new ArrayList<>();
            Ajs.add(Temp);

        }
        for (int i=0;i<M;i++){
            int u= Edges[i][0];
            int v=Edges[i][1];
            int Wt=Edges[i][2];
            Ajs.get(u).add(new Pair(v, Wt));

        }
        int Vis[]=new int[N];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<N;i++){
            if(Vis[i]==0){
                TopoSort(i,Ajs,st,Vis); // Step2
            }
        }
     // Step3
        int dist[]=new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
          }
          dist[0]=0;
          while ((!st.empty())) {
            int Node=st.peek();
           st.pop();

           for(int H=0;H<Ajs.get(Node).size();H++){
            int v=Ajs.get(Node).get(H).First;// Node
            int D=Ajs.get(Node).get(H).Second;// Distance
            if(dist[Node]+D<dist[v]){
                dist[v]=dist[Node]+D;
            }

                   }
                 
            
          }
          return dist;

    }
    public static void main(String[] args) {
        int N=6; // Number of 
        int M=7; 

        int [][]Edges={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int Arr[]=ShortestPath(N, M, Edges);
        for(int i=0;i<N;i++){
            System.out.println(Arr[i]);
            System.out.println();
        }
       

    }
}
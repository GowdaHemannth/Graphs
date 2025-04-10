import java.util.*;
public class Cycle {
   static  class Pair{
        int First;
        int Second;
        public Pair(int First,int Second){
           this.First=First;
           this.Second=Second;


        }

    }
    public static boolean CheckCycle(int src,boolean vis[],ArrayList<ArrayList<Integer>>adj){
        vis[src]=true;
        Queue<Pair>Q=new LinkedList<>();
        Q.add(new Pair(src, -1));
        while (!Q.isEmpty()) {
            int F=Q.peek().First;
            int S=Q.peek().Second;
            Q.remove();

            for(int i=0;i<adj.get(F).size();i++){
                Integer it=adj.get(F).get(i);
                if(vis[it]==false){
                    vis[it]=true;
                    Q.add(new Pair(it,F));
                }else if(S!=it){
                    return true;
                }
            }
            
        }
        return false;
        

    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>>adj){
       boolean vis[]=new boolean[v];
        Arrays.fill(vis,false);
        for(int i=0;i<v;i++){  // Here we are using for loop Just beacuse we think it might have Components in Graph ;
          if(CheckCycle(i, vis, adj)==true){
            return true;
          }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        int v=4;
        System.out.println(isCycle(v, adj));
        
    }
    
}

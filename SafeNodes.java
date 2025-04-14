import java.util.*;
public class SafeNodes {
    public static boolean SafeNode(int Node,int vis[],int PathVis[],int CheckNode[],ArrayList<ArrayList<Integer>>Ajs){
     vis[Node]=1;
     CheckNode[Node]=0;
     PathVis[Node]=1;
     for(int i=0;i<Ajs.get(Node).size();i++){
        int it = Ajs.get(Node).get(i);
        if(vis[it]==0){
          if( SafeNode(it, vis, PathVis, CheckNode, Ajs)==true){
            return true;

            }

     }else if(PathVis[it]==1){
        return true;
    }
}
     PathVis[Node]=0;
     CheckNode[Node]=1;
     return false;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>Ajs=new ArrayList<>();
        int v=12;
        for(int i=0;i<v;i++){
            Ajs.add(new ArrayList<>());

        }
        int vis[]=new int[v];
        int PathVis[]=new int[v];
        int CheckNode[]=new int[v];
        
        Ajs.get(0).add(1);
        Ajs.get(1).add(2);
        Ajs.get(2).add(3);
        Ajs.get(2).add(4);
        Ajs.get(3).add(4);
        Ajs.get(3).add(5);
        Ajs.get(4).add(6);
        Ajs.get(5).add(6);
        Ajs.get(6).add(7);
        Ajs.get(8).add(1);
        Ajs.get(8).add(9);
        Ajs.get(9).add(10);
        Ajs.get(10).add(8);
        Ajs.get(11).add(9);
        for(int i=0;i<v;i++){
            SafeNode(i, vis, PathVis, CheckNode, Ajs);
        }

      

        for(int i=0;i<v;i++){
            if(CheckNode[i]==1){
                System.out.print(i);
            }
            System.out.println();
        }
        
    }
    
}

// numerical 1
import java.util.*;
public class Provisions {
    public static void DFS(int Node,ArrayList<ArrayList<Integer>>ADJ,  boolean T[]){
    T[Node]=true;
    for(int i=0;i<ADJ.get(Node).size();i++){
        Integer it=ADJ.get(Node).get(i);
        if (!T[it]) {
            DFS(it, ADJ, T);
        }
    }
    }


    
    public static int Provi(int v,ArrayList<ArrayList<Integer>>Matrix){
        ArrayList<ArrayList<Integer>>ADJ= new ArrayList<>();
        for(int i=0;i<v;i++){
            ADJ.add(new ArrayList<>());
          
        }
       
   int Count=0;
        boolean T[]=new boolean[3];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(Matrix.get(i).get(j)==1&&i!=j){
                    ADJ.get(i).add(j);
                    ADJ.get(j).add(i);

                }
            }
        }

        for(int i=0;i<v;i++){
            if (T[i]== false){
                Count++;
                DFS(i,ADJ,T);
            }
              
            
            }
            return Count;
        }
 
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>Matrix=new ArrayList<>();
        Matrix.add(new ArrayList<>());
        Matrix.get(0).add(0,1);
        Matrix.get(0).add(1,1);
        Matrix.get(0).add(2,0);
        Matrix.add(new ArrayList<>());
        Matrix.get(1).add(0,1);
        Matrix.get(1).add(1,1);
        Matrix.get(1).add(2,0);
        Matrix.add(new ArrayList<>());
        Matrix.get(2).add(0,0);
        Matrix.get(2).add(1,0);
        Matrix.get(2).add(2,1);
        int v=3;
       
        System.out.println(Provi(v, Matrix));




    }
    
}

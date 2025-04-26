import java.util.*;
public class MinimumMultiplication {
    public static class Pair{
        int First;
        int Second;
        public Pair(int First,int Second){
            this.First=First;
            this.Second=Second;
        }
    }

        public static int Function(int Start,int end,int arr[]){
            int n=arr.length;
            int dist[]= new int[100000];
    // Here if go and give reason for 5taking array 1000000 ,,,just use or see 
       for(int i=0;i<100000;i++){
        dist[i]=(int)1e9;

       }
       dist[Start]=0;
       PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.First-y.First);
       pq.add(new Pair(Start, 0));

       while(!pq.isEmpty()){
        int first=pq.peek().First;
        int second=pq.peek().Second;
        pq.remove();

        for(int i=0;i<n;i++){
            int num=(arr[i]*first)%100000;
            if(num==end){
                return second+1;
            }
            if(second+1<dist[num]){
                dist[num]=second+1;
                pq.add(new Pair(num, second+1));
            }

            
      
       }



        


        }
        return -1;  
     
    }
    
    public static void main(String[] args) {
        int start=3;
        int end=30;
        int arr[]={2,5,7};
        System.out.println(Function(start, end, arr));
    }
    
}

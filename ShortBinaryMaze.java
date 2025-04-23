import java.util.*;
public class ShortBinaryMaze {
    public static class Pair{
        int first;
        int second;
        int third;
        public Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
 
   public static int Function(int []source,int destination[], int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    int dist[][]=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dist[i][j]=(int)1e9;
        }
    }
    dist[source[0]][source[1]]=0;
    Queue<Pair>Q=new LinkedList<>();
    Q.add(new Pair(0, source[0],source[1]));
    int drow[]={-1,0,1,0};
    int dcol[]={0,1,0,-1};
    while(!Q.isEmpty()){
        int Steps=Q.peek().first;
        int row=Q.peek().second;
        int col=Q.peek().third;
        Q.poll();
        for(int i=0;i<4;i++){
            int nrow= row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]==1&&Steps+1<dist[nrow][ncol]){
                dist[nrow][ncol]=Steps+1;
                if(nrow==destination[0]&&ncol==destination[1]){
                    return Steps+1;
                }
                Q.add(new Pair(Steps+1, nrow, ncol));
                
            }
            
        }
    }
    return -1;
   }
 
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};
        int[][] grid={{1, 1, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {1, 0, 0, 1}};
        System.out.println(Function(source, destination, grid));
    }
  
    
    
}

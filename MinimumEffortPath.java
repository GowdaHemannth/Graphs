// Minimum Effort path here i want to find the Minimum Path From Source to Destination 

import java.util.PriorityQueue;

public class MinimumEffortPath {
    public static class Pair{
        int Distance;
        int row;
        int Col;
        public Pair(int Distance,int row,int col){
            this.Distance=Distance;
            this.row=row;
            this.Col=Col;

        }

    }
    public static int Funtion(int [][] heights){
        int n=heights.length;
        int m=heights[0].length;
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int Effort=pq.peek().Distance;
            int row=pq.peek().row;
            int col=pq.peek().Col;
            pq.remove();
            if(row==n-1&&col==m-1){
                return Effort;
            }
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m){
                    int NewEffort=Math.max(heights[row][col]-heights[nrow][ncol], Effort);
                    if(NewEffort<dist[nrow][ncol]){
                        dist[nrow][ncol]=NewEffort;
                        pq.add(new Pair(NewEffort, nrow, ncol));
                        
                    }
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        
    }
    
}

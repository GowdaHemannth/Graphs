import java.util.*;

public class zeroOrone {
    static class Pair{
        int Row;
        int Column;
        int Steps;
        public Pair(int Row,int Column,int Steps){
            this.Row=Row;
            this.Column=Column;
            this.Steps=Steps;

        }
        
    }
    public static int[][] Function(int grid[][],int Dummy[][]){
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
       
        Queue<Pair>Q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                  Q.add(new Pair(i, j, 0));
                  vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int Delrow[]={-1,0,1,0};
        int DelColumn[]={0,1,0,-1};
        while (!Q.isEmpty()) {
            int row=Q.peek().Row;
            int column=Q.peek().Column;
            int steps=Q.peek().Steps;
            Dummy[row][column]=steps;
            for(int i=0;i<4;i++){
                int newrow=row+Delrow[i];
                int newcolumn=column+DelColumn[i];
                if(newrow>=0&&newrow<n&&newcolumn>=0&&newcolumn<m&&vis[newrow][newcolumn]==0){
                    vis[newrow][newcolumn]=1;
                    Q.add(new Pair(newrow, newcolumn, steps+1));
                }
            }
            
        }
   return Dummy;


    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };
        int n=grid.length;
        int m=grid[0].length;
        int Dummy[][]=new int[n][m];
       
       Function(grid,Dummy);
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            System.out.print(Dummy[i][j]);
        }
        System.out.println();
       }
        
    }
    
}

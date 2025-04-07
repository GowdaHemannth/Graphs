// numerical 2
import java.util.*;
class Pair {
    int row;
    int column;
    int time;

    Pair(int row, int column, int time) { // Capital "P"
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

public class RottenFruit {
    public static int Function(int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair>Q=new LinkedList<>();

        int CountFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    Q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    CountFresh++;
                }
            }
        }

        // Part 2 of a numerical 
        int tm=0;
        int drow []={-1,0,+1,0};
        int dcolumn[]={0,1,0,-1};
        int cnt=0;
        while(!Q.isEmpty()){
            int r=Q.peek().row;
            int c=Q.peek().column;
            int time=Q.peek().time;
            tm=Math.max(tm,time);
            Q.poll();

            for(int i=0;i<4;i++){
                int rrow=r+drow[i];

                int rcolumn=c+dcolumn[i];
                if (rrow >= 0 && rrow < n && rcolumn >= 0 && rcolumn < n && 
                vis[rrow][rcolumn] == 0 && grid[rrow][rcolumn] == 1) {
                
                Q.add(new Pair(rrow, rcolumn, time + 1));
                vis[rrow][rcolumn] = 2;
                cnt++;
            }
            

            }
        }
        if(cnt==CountFresh){
            return tm;
        }else{
            return -1;
        }

    }
  
    public static void main(String[] args) {
int grid[][]={ {2,1,1} , {1,1,0} , {0,1,1} };

System.out.println(Function(grid));

        
    }
    
}

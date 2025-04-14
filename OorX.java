public class OorX {

    public  static void DFS(int i,int j,int vis[][],char mat[][],int Delrow[],int DelColumn[],int n,int m){
     vis[i][j]=1;
     for(int k=0;k<4;k++){
        int newrow=i+Delrow[k];
        int newcolumn=j+DelColumn[k];
        if(newrow>=0&&newrow<n&&newcolumn>=0&&newcolumn<m&&vis[newrow][newcolumn]==0&&mat[newrow][newcolumn]=='O'){
            DFS(newrow,newcolumn,vis,mat,Delrow,DelColumn,n,m);
        }
     }


    }
    public static void main(String[] args) {
        char mat[][] = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}};

            // First Row 
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int Delrow[]={-1,0,1,0};
       int  Delcolumn[]={0,1,0,-1};

       for (int i = 0; i < m; i++) {
        if (vis[0][i] == 0 && mat[0][i] == 'O') {
            DFS(0, i, vis, mat, Delrow, Delcolumn, n, m);
        }
        if (vis[n - 1][i] == 0 && mat[n - 1][i] == 'O') {
            DFS(n - 1, i, vis, mat, Delrow, Delcolumn, n, m);
        }
    }
    
    for (int j = 0; j < n; j++) {
        if (vis[j][0] == 0 && mat[j][0] == 'O') {
            DFS(j, 0, vis, mat, Delrow, Delcolumn, n, m);
        }
        if (vis[j][m - 1] == 0 && mat[j][m - 1] == 'O') {
            DFS(j, m - 1, vis, mat, Delrow, Delcolumn, n, m);
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (vis[i][j] == 0 && mat[i][j] == 'O') {
                mat[i][j] = 'X';
            }
            System.out.print(mat[i][j] + " ");
        }
        System.out.println();
    }
    }
}    
    


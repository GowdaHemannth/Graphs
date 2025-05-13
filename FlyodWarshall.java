public class FlyodWarshall {
    public static int[][] Function(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=(int)(1e9);
                }
                if(i==j){
                    matrix[i][j]=0;
                }
            }
        }
        // Now the three Loops for the Via Which Path should Matrix Take;
        for(int k=0;k<matrix.length;k++){  // These loop for the Like Via 0 or via 1 {
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j]=Math.min(matrix[i][j], (matrix[i][k]+matrix[k][j]));
            }
         }
        }
        return matrix;
            
    }
    public static void main(String[] args) {
        int v=4;
        int matrix[][]=new int[v][v];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=-1;
            }
        }
        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;
    }
    
}

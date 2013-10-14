public class MagicSquare {
    public void magic(int[][] mat){
        int n=mat.length;
        int row=n/2;
        int col=n-1;
        for(int num=1;num<=n*n;){
            if(row==-1&&col==n){
                row=0;
                col=n-2;
            }
            else{
                if(row<0)
                    row=n-1;
                if(col==n)
                    col=0;
            }
            if(mat[row][col]>0){
                row+=1;
                col-=2;
                    continue;
                
            }
            else{
                mat[row][col]=num++;
                row--;
                col++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%3d",mat[i][j]);
            }
            System.out.println("");
        }
    }
}

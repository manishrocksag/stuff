public class NQueen {
    private static final int N=16;
    private int[][] board;
    private int count=0;
    public boolean isSafe(int row,int col,int[][] board){
        int i,j;
        // check row
        for(i=0;i<col;i++)
        {
            if(board[row][i]==1)
                return false;
        }
        //lower diagonal check
        for(i=row,j=col;j>=0&&i<N;i++,j--){
            if(board[i][j]==1)
                return false;
        }
        //upper diagonal check
        for(i=row,j=col;i>=0&&j>=0;i--,j--)
            if(board[i][j]==1)
                return false;
        return true;
    }
    private boolean solveNQueen(int[][] board,int col){
        if(col>=N){
            count++;
            printSolution(board);
            System.out.println();
            System.out.println("count is"+count);
            }
        for(int i=0;i<N;i++){
            if(isSafe(i, col, board)){
                board[i][col]=1;
                    if(solveNQueen(board, col+1)==true){
                        return true;
                    }
                    board[i][col]=0;
                         }
        }
        return false;
    }
    private void printSolution(int sol[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf("%3d",sol[i][j]);
            }
            System.out.println();
        }
    }
    public void solveNQueen(){
        board=new int[N][N];
        if(solveNQueen(board, 0));
          
    }
}
        
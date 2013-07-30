public class KnightTour {
    private static final int N=6;
    private int[][] sol;
    private static final int[] xMove={2,1,-1,-2,-2,-1,1,2};
    private static final int[] yMove={1,2,2,1,-1,-2,-2,-1};
    private boolean isSafe(int x,int y,int[][] sol){
        if(x>=0&&x<N&&y>=0&&y<N&&sol[x][y]==-1)
            return true;
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
    public void solveKnightTour(){
        sol=new int[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                sol[i][j]=-1;
        sol[0][0]=0;
                    if(solveKnightTour(sol,xMove,yMove,0,0,1)==false)
                         System.out.println("No Solution Exists");
                     else
                            printSolution(sol);  
    }
    private boolean solveKnightTour(int[][] sol,int[] xMove,int[] yMove,int x,int y,int noOfMoves){
        int nextX,nextY;
        if(noOfMoves==N*N)
            return true;
        for(int i=0;i<N;i++){
            nextX=x+xMove[i];
            nextY=y+yMove[i];
            if(isSafe(nextX,nextY,sol)){
                sol[nextX][nextY]=noOfMoves;
                if(solveKnightTour(sol,xMove,yMove,nextX,nextY,noOfMoves+1)==true)
                    return true;
                sol[nextX][nextY]=-1;   
            }
        }
        return false;
    } 
}

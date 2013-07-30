public class Maze {
    private int[][] soln;
    private int N;
    public Maze(int N){
        this.N=N;
        soln=new int[N][N];
    }
    private boolean isSafe(int x,int y,int[][] maze){
        if(x<0||x>=N)
            return false;
        if(y<0||y>=N)
            return false;
        if(maze[x][y]==0)
            return false;
        return true;
    }
    private void printSolution(int sol[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf("%3d",sol[i][j]);
            }
            System.out.println();
        }
    }
    public void solve(int[][] maze){
        if(solve(maze,0,0,soln)==true)
            printSolution(soln);
        else
            System.out.println("No Solution");
        
    }
    private boolean solve(int[][] maze,int x,int y,int[][] sol){
        if(x==N-1&&y==N-1){
            sol[x][y]=1;
            return true;
        }
        if(isSafe(x, y, maze)){
            sol[x][y]=1;
            if(solve(maze,x,y+1,sol)==true)
                return true;
            if(solve(maze,x+1,y,sol)==true)
                return true;
            if(solve(maze,x,y-1,sol)==true)
                return true;
            if(solve(maze,x-1,y,sol)==true)
                return true;
            sol[x][y]=0;
            return false;
        }
        return false;
    }   
}

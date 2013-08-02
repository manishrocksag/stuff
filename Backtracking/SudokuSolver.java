public class SudokuSolver {
 /*
 * Function: SolveSudoku
 * ---------------------
 * Takes a partially filled-in grid and attempts to assign values to all
 * unassigned locations in such a way to meet the requirements for Sudoku
 * solution (non-duplication across rows, columns, and boxes). The function
 * operates via recursive backtracking: it finds an unassigned location with
 * the grid and then considers all digits from 1 to 9 in a loop. If a digit
 * is found that has no existing conflicts, tentatively assign it and recur
 * to attempt to fill in rest of grid. If this was successful, the puzzle is
 * solved. If not, unmake that decision and try again. If all digits have
 * been examined and none worked out, return false to backtrack to previous
 * decision point.
 */
   private int[][] model;
   private  static final int UNASSIGNED=0;
   private static int row,col;
   public  boolean solveSudoku(int[][] sudoku){
       if(!findUnassignedLocation(sudoku))
           return true;
       for(int num=1;num<=9;num++){
           if(noConflicts(sudoku,row,col,num)){
               sudoku[row][col]=num; 
           sudoku[row][col]=0;
           }
       }
       return false;    
   }
   /*
 * Function: FindUnassignedLocation
 * --------------------------------
 * Searches the grid to find an entry that is still unassigned. If found,
 * the reference parameters row, col will be set the location that is
 * unassigned, and true is returned. If no unassigned entries remain, false
 * is returned.
 */
   private  boolean findUnassignedLocation(int[][] sudoku){
       for(row=0;row<9;row++)
           for(col=0;col<9;col++)
               if(sudoku[row][col]==0){
                   return true;}
       return false;
   }
   /*
 * Function: NoConflicts
 * ---------------------
 * Returns a boolean which indicates whether it will be legal to assign
 * num to the given row,col location. As assignment is legal if it that
 * number is not already used in the row, col, or box.
 */
   private boolean noConflicts(int[][] sudoku,int row,int col,int num){
       if(!usedInRow(sudoku,row,num)&&!(usedInCol(sudoku,col,num))&&!usedInBox(sudoku,row-row%3,col-col%3,num))
           return true;
       return false; 
   }
   private boolean usedInRow(int[][] sudoku,int row,int num){
       for(int col=0;col<9;col++)
           if(sudoku[row][col]==num)
               return true;
       return false;
       
   }
    private boolean usedInCol(int[][] sudoku,int col,int num){
       for(int row=0;row<9;row++)
           if(sudoku[row][col]==num)
               return true;
       return false;
   }
     private boolean usedInBox(int[][] sudoku,int boxStartRow,int boxStartCol,int num){
       for(int row=0;row<3;row++)
           for(int col=0;col<3;col++)
                if(sudoku[row+boxStartRow][boxStartCol]==num)
                        return true;
       return false;
       
   }
   private void printSolution(int sol[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.printf("%3d",sol[i][j]);
            }
            System.out.println();
        }   
    }
   public void solveSudoku() throws Exception{
        model=new int[9][9];
        if(solveSudoku(model)        
      		printSolution(model);
	   else
			System.out.println("Solution does not exists ");
   }
   
}
   
   
   
   
